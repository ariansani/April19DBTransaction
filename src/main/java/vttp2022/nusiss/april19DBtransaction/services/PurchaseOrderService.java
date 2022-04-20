package vttp2022.nusiss.april19DBtransaction.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vttp2022.nusiss.april19DBtransaction.exceptions.OrderTooLargeException;
import vttp2022.nusiss.april19DBtransaction.models.LineItem;
import vttp2022.nusiss.april19DBtransaction.models.PurchaseOrder;
import vttp2022.nusiss.april19DBtransaction.repository.LineItemRepository;
import vttp2022.nusiss.april19DBtransaction.repository.PurchaseOrderRepository;

@Service
public class PurchaseOrderService {
    
    @Autowired
    private PurchaseOrderRepository poRepo;

    @Autowired
    private LineItemRepository lineItemRepo;

    @Transactional(rollbackFor = OrderTooLargeException.class)
    public Integer createPurchaseOrder(final PurchaseOrder po) throws OrderTooLargeException {
        
        final Integer orderId = poRepo.insertPurchaseOrder(po);
        double totalUnitPrice = 0d;

        for (LineItem li : po.getLineItems()) {
            totalUnitPrice = li.getQuantity() * li.getUnitPrice();
            if(totalUnitPrice > 200){
                
                OrderTooLargeException ex = new OrderTooLargeException("Order exceed SGD200: %.2f".formatted(totalUnitPrice));
                ex.setPo(po);
                throw ex;
            }
        }

        lineItemRepo.addLineItem(orderId, po.getLineItems());

        return orderId;
    }

}

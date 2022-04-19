package vttp2022.nusiss.april19DBtransaction.exceptions;

import vttp2022.nusiss.april19DBtransaction.models.PurchaseOrder;

public class OrderTooLargeException extends Exception{
    
    private PurchaseOrder po;
    
    
    public PurchaseOrder getPo() {
        return po;
    }
    public void setPo(PurchaseOrder po) {
        this.po = po;
    }
    public OrderTooLargeException(){
        super();
    }
    public OrderTooLargeException(String msg){
        super(msg);
    }

}

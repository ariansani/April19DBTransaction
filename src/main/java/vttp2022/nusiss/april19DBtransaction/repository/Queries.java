package vttp2022.nusiss.april19DBtransaction.repository;

public interface Queries {
    
    public static final String SQL_INSERT_PURCHASE_ORDER="insert into purchase_order(name,email) values (?,?)";

    public static final String SQL_INSERT_LINE_ITEM="insert into line_item(order_id, quantity, unit_price, description) values (?,?,?,?)";

    public static final String SQL_PURCHASE_ORDER_TOTAL ="select count(*) from purchase_order";

}

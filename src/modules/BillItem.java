package modules;

public class BillItem {
    
    private int billItemNo;
    private String billNo;
    private String productID;
    private int quantity;
    private double unitPrice;
    private double total;

    public int getBillItemNo() {
        return billItemNo;
    }

    public void setBillItemNo(int billItemNo) {
        this.billItemNo = billItemNo;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    public double getTotal() {
        return total;
    }
    
    public void setTotal(double total) {
        this.total = total;
    }
    
}

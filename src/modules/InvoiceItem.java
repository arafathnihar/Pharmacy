package modules;

import java.util.Date;

public class InvoiceItem {
    
    // in --> invoice //
    private int inItemID;
    private String inID;
    private String productID;
    private int inPackSize;
    private int inItemQuantity;
    private int inItemFree;
    private double inItemPrice;
    private int inItemMargin;
    private Date inItemExpire;
    private double inItemDiscount;
    private int inItemSold;

    public int getInItemID() {
        return inItemID;
    }

    public void setInItemID(int inItemID) {
        this.inItemID = inItemID;
    }

    public String getInID() {
        return inID;
    }
    
    public void setInID(String inID) {
        this.inID = inID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getInPackSize() {
        return inPackSize;
    }

    public void setInPackSize(int inPackSize) {
        this.inPackSize = inPackSize;
    }

    public int getInItemQuantity() {
        return inItemQuantity;
    }

    public void setInItemQuantity(int inItemQuantity) {
        this.inItemQuantity = inItemQuantity;
    }

    public int getInItemFree() {
        return inItemFree;
    }

    public void setInItemFree(int inItemFree) {
        this.inItemFree = inItemFree;
    }

    public double getInItemPrice() {
        return inItemPrice;
    }

    public void setInItemPrice(double inItemPrice) {
        this.inItemPrice = inItemPrice;
    }

    public int getInItemMargin() {
        return inItemMargin;
    }

    public void setInItemMargin(int inItemMargin) {
        this.inItemMargin = inItemMargin;
    }

    public Date getInItemExpire() {
        return inItemExpire;
    }

    public void setInItemExpire(Date inItemExpire) {
        this.inItemExpire = inItemExpire;
    }

    public double getInItemDiscount() {
        return inItemDiscount;
    }

    public void setInItemDiscount(double inItemDiscount) {
        this.inItemDiscount = inItemDiscount;
    }
    public int getInItemSold() {
        return inItemSold;
    }

    public void setInItemSold(int inItemSold) {
        this.inItemSold = inItemSold;
    }
    
}

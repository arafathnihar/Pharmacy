package modules;

import java.util.Date;

public class Bill {

    private String billNo;
    private Date billDate;
    private String billNote;
    private double billAmount;

    public Bill(String billNo, Date billDate, String billNote, double billAmount) {
        this.billNo = billNo;
        this.billDate = billDate;
        this.billNote = billNote;
        this.billAmount = billAmount;
    }
    
    public Bill(){
        this.billNo = "";
        this.billDate = null;
        this.billNote = "";
        this.billAmount = 0.00;
    }
    
    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getBillNote() {
        return billNote;
    }

    public void setBillNote(String billNote) {
        this.billNote = billNote;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

}

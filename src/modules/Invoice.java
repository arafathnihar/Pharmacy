package modules;

import java.util.Date;

public class Invoice {
    
    private String invoiceID;
    private String distibutorCode;
    private Date invoiceDate;
    private String invoiceNote;
    private String invoicePayMode;
    private double invoiceTotal;

    
    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public String getDistibutorCode() {
        return distibutorCode;
    }

    public void setDistibutorCode(String distibutorCode) {
        this.distibutorCode = distibutorCode;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceNote() {
        return invoiceNote;
    }

    public void setInvoiceNote(String invoiceNote) {
        this.invoiceNote = invoiceNote;
    }

    public String getInvoicePayMode() {
        return invoicePayMode;
    }

    public void setInvoicePayMode(String invoicePayMode) {
        this.invoicePayMode = invoicePayMode;
    }

    public double getInvoiceTotal() {
        return invoiceTotal;
    }

    public void setInvoiceTotal(double invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }
    
    
}

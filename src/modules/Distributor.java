package modules;

public class Distributor {
    
    private String distributorCode;
    private String distributorName;
    private String distributorAddress;
    private String distributorTel;

    public Distributor(String distributorCode, String distributorName, String distributorAddress, String distributorTel) {
        this.distributorCode = distributorCode;
        this.distributorName = distributorName;
        this.distributorAddress = distributorAddress;
        this.distributorTel = distributorTel;
    }
    
    public Distributor(){
        this.distributorCode = "";
        this.distributorName = "";
        this.distributorAddress = "";
        this.distributorTel = "";
    }
    
    public String getDistributorCode() {
        return distributorCode;
    }

    public void setDistributorCode(String distributorCode) {
        this.distributorCode = distributorCode;
    }

    public String getDistributorName() {
        return distributorName;
    }

    public void setDistributorName(String distributorName) {
        this.distributorName = distributorName;
    }

    public String getDistributorAddress() {
        return distributorAddress;
    }

    public void setDistributorAddress(String distributorAddress) {
        this.distributorAddress = distributorAddress;
    }

    public String getDistributorTel() {
        return distributorTel;
    }

    public void setDistributorTel(String distributorTel) {
        this.distributorTel = distributorTel;
    }
    
}

package bg.tu_varna.sit.inventorymanagement.presentation.models;


public class CustomerListViewModel {
    private  String cusName;
    private  String telNum;
    private  String email;

    public CustomerListViewModel(String cusName, String telNum, String email) {
        this.cusName=cusName;
        this.telNum=telNum;
        this.email=email;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CustomerListViewModel{" +
                "cusName='" + cusName + '\'' +
                ", telNum='" + telNum + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

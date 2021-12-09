package bg.tu_varna.sit.inventorymanagement.presentation.models;


import java.util.Objects;

public class CustomerListViewModel {
    private  Long idCustomer;
    private  String cusName;
    private  String telNum;
    private  String email;

    public CustomerListViewModel() {
    }

    public CustomerListViewModel(Long idCustomer, String cusName, String telNum, String email) {
        this.idCustomer=idCustomer;
        this.cusName=cusName;
        this.telNum=telNum;
        this.email=email;
    }

    public CustomerListViewModel(String cusName, String telNum, String email) {
        this.cusName = cusName;
        this.telNum = telNum;
        this.email = email;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerListViewModel that = (CustomerListViewModel) o;
        return Objects.equals(cusName, that.cusName) && Objects.equals(telNum, that.telNum) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cusName, telNum, email);
    }

    @Override
    public String toString() {
        return  idCustomer+" - "+cusName;
    }
}

package bg.tu_varna.sit.inventorymanagement.presentation.models;

import bg.tu_varna.sit.inventorymanagement.data.entities.Mol;

import java.util.Date;

public class ProductListViewModel {
    private  String description;
    private  String prodType;
    private  boolean prodStatus;
    private Date discardDate;
    private double productValue;
    private Date exploatationStart;
    private boolean isDiscarded;
    private Mol byMol;

    public ProductListViewModel() {
    }

    public ProductListViewModel(String description, String prodType, boolean prodStatus, Date discardDate, double productValue,
                                Date exploatationStart, boolean isDiscarded, Mol byMol) {
        this.description = description;
        this.prodType = prodType;
        this.prodStatus = prodStatus;
        this.discardDate = discardDate;
        this.productValue = productValue;
        this.exploatationStart = exploatationStart;
        this.isDiscarded = isDiscarded;
        this.byMol = byMol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public boolean isProdStatus() {
        return prodStatus;
    }

    public void setProdStatus(boolean prodStatus) {
        this.prodStatus = prodStatus;
    }

    public Date getDiscardDate() {
        return discardDate;
    }

    public void setDiscardDate(Date discardDate) {
        this.discardDate = discardDate;
    }

    public double getProductValue() {
        return productValue;
    }

    public void setProductValue(double productValue) {
        this.productValue = productValue;
    }

    public Date getExploatationStart() {
        return exploatationStart;
    }

    public void setExploatationStart(Date exploatationStart) {
        this.exploatationStart = exploatationStart;
    }

    public boolean isDiscarded() {
        return isDiscarded;
    }

    public void setDiscarded(boolean discarded) {
        isDiscarded = discarded;
    }

    @Override
    public String toString() {
        return "ProductListViewModel{" +
                "description='" + description + '\'' +
                '}';
    }
}

package bg.tu_varna.sit.inventorymanagement.presentation.models;

import bg.tu_varna.sit.inventorymanagement.data.entities.Amortization;
import bg.tu_varna.sit.inventorymanagement.data.entities.Condition;
import bg.tu_varna.sit.inventorymanagement.data.entities.Mol;

import java.time.LocalDate;
import java.util.Objects;

public class ProductListViewModel {
    private  int idInventoryNumber;
    private  String description;
    private  String prodType;
    private  boolean prodStatus;
    private LocalDate discardDate;
    private double productValue;
    private LocalDate exploatationStart;
    private boolean isDiscarded;
    private Mol byMol;
    private Amortization byAmortization;
    private Condition byCondition;

    public ProductListViewModel() {
    }

    public ProductListViewModel(String description, String prodType, LocalDate discardDate, double productValue,
                                LocalDate exploatationStart,Condition byCondition, Mol byMol, Amortization byAmortization) {
        this.description = description;
        this.prodType = prodType;
        this.prodStatus = true;
        this.discardDate = discardDate;
        this.productValue = productValue;
        this.exploatationStart = exploatationStart;
        this.isDiscarded = false;
        this.byCondition= byCondition;
        this.byMol = byMol;
        this.byAmortization=byAmortization;
    }

    public ProductListViewModel(String description, String prodType, LocalDate discardDate, double productValue,
                                LocalDate exploatationStart,Condition byCondition, Mol byMol) {
        this.description = description;
        this.prodType = prodType;
        this.prodStatus = true;
        this.discardDate = discardDate;
        this.productValue = productValue;
        this.exploatationStart = exploatationStart;
        this.isDiscarded = false;
        this.byCondition= byCondition;
        this.byMol = byMol;

    }

    public ProductListViewModel(int idInventoryNumber, String description) {
        this.idInventoryNumber = idInventoryNumber;
        this.description = description;
    }

    public int getIdInventoryNumber() {
        return idInventoryNumber;
    }

    public void setIdInventoryNumber(int idInventoryNumber) {
        this.idInventoryNumber = idInventoryNumber;
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

    public LocalDate getDiscardDate() {
        return discardDate;
    }

    public void setDiscardDate(LocalDate discardDate) {
        this.discardDate = discardDate;
    }

    public double getProductValue() {
        return productValue;
    }

    public void setProductValue(double productValue) {
        this.productValue = productValue;
    }

    public LocalDate getExploatationStart() {
        return exploatationStart;
    }

    public void setExploatationStart(LocalDate exploatationStart) {
        this.exploatationStart = exploatationStart;
    }

    public boolean isDiscarded() {
        return isDiscarded;
    }

    public void setDiscarded(boolean discarded) {
        isDiscarded = discarded;
    }

    public Mol getByMol() {
        return byMol;
    }

    public void setByMol(Mol byMol) {
        this.byMol = byMol;
    }

    public Amortization getByAmortization() {
        return byAmortization;
    }

    public void setByAmortization(Amortization byAmortization) {
        this.byAmortization = byAmortization;
    }

    public Condition getByCondition() {
        return byCondition;
    }

    public void setByCondition(Condition byCondition) {
        this.byCondition = byCondition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductListViewModel that = (ProductListViewModel) o;
        return Objects.equals(idInventoryNumber, that.idInventoryNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInventoryNumber);
    }

    @Override
    public String toString() {
        return description ;
    }
}

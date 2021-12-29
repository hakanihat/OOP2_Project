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


    public ProductListViewModel(int idInventoryNumber, String description, String prodType, boolean prodStatus, LocalDate exploatationStart , double productValue, Mol byMol, Amortization byAmortization, LocalDate discardDate ) {
        this.idInventoryNumber = idInventoryNumber;
        this.description = description;
        this.prodType = prodType;
        this.prodStatus = prodStatus;
        this.discardDate = discardDate;
        this.productValue = productValue;
        this.exploatationStart = exploatationStart;
        this.byMol = byMol;
        this.byAmortization = byAmortization;
    }

    public ProductListViewModel(int idInventoryNumber, String description) {
        this.idInventoryNumber = idInventoryNumber;
        this.description = description;
    }

    public int getIdInventoryNumber() {
        return idInventoryNumber;
    }

     public String getDescription() {
        return description;
    }

    public String getProdType() {
        return prodType;
    }

    public boolean isProdStatus() {
        return prodStatus;
    }

    public LocalDate getDiscardDate() {
        return discardDate;
    }

    public double getProductValue() {
        return productValue;
    }

    public LocalDate getExploatationStart() {
        return exploatationStart;
    }

    public boolean isDiscarded() {
        return isDiscarded;
    }

    public Mol getByMol() {
        return byMol;
    }

    public Amortization getByAmortization() {
        return byAmortization;
    }

    public Condition getByCondition() {
        return byCondition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductListViewModel that = (ProductListViewModel) o;
        return Objects.equals(idInventoryNumber, that.idInventoryNumber);
    }

    @Override
    public String toString() {
        return idInventoryNumber+"-" + description ;
    }
}

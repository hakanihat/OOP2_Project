package bg.tu_varna.sit.inventorymanagement.presentation.models;

import java.util.Objects;

public class AmortizationListViewModel {
    private  Long idAmortization;
    private  double amortDeg;

    public AmortizationListViewModel() {
    }

    public AmortizationListViewModel(double amortDeg) {
        this.amortDeg = amortDeg;
    }

    public Long getIdAmortization() {
        return idAmortization;
    }

    public void setIdAmortization(Long idAmortization) {
        this.idAmortization = idAmortization;
    }

    public double getAmortDeg() {
        return amortDeg;
    }

    public void setAmortDeg(double amortDeg) {
        this.amortDeg = amortDeg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AmortizationListViewModel that = (AmortizationListViewModel) o;
        return Double.compare(that.amortDeg, amortDeg) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amortDeg);
    }

    @Override
    public String toString() {
        return "Категория " + idAmortization;
    }
}

package bg.tu_varna.sit.inventorymanagement.presentation.models;

public class ConditionListViewModel {
    private  String prodCondition;

    public ConditionListViewModel() {
    }

    public ConditionListViewModel(String prodCondition) {
        this.prodCondition = prodCondition;
    }

    public String getProdCondition() {
        return prodCondition;
    }

    @Override
    public String toString() {
        return  prodCondition ;
    }
}

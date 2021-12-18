package bg.tu_varna.sit.inventorymanagement.business.services;

import bg.tu_varna.sit.inventorymanagement.presentation.models.ConditionListViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ConditionServiceTest {
    private ConditionService conditionService;
    private ConditionListViewModel conditionListViewModel;

    @BeforeEach
    void setUp() {
        this.conditionService=ConditionService.getInstance();
        this.conditionListViewModel=new ConditionListViewModel("Broken");
    }

    @Test
    void addTheCondition() {

       assertTrue(conditionService.addTheCondition(conditionListViewModel));
    }
}
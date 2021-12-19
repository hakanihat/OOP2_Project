package bg.tu_varna.sit.inventorymanagement.business.services;

import bg.tu_varna.sit.inventorymanagement.data.entities.Condition;
import bg.tu_varna.sit.inventorymanagement.data.repositories.ConditionRepository;
import bg.tu_varna.sit.inventorymanagement.presentation.models.ConditionListViewModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ConditionServiceTest {
    private ConditionService conditionService;
    private ConditionListViewModel conditionListViewModel;
    private ConditionRepository conditionRepository;

    @BeforeEach
    void setUp() {
        this.conditionService=ConditionService.getInstance();
        this.conditionRepository=conditionRepository.getInstance();
        this.conditionListViewModel=new ConditionListViewModel("Broken");
    }

    @AfterEach
    void tearDown(){
        Condition temp = new Condition(conditionListViewModel.getProdCondition());
        List<Condition> conditions = conditionRepository.getAll();
        for (Condition condition: conditions) {
            if(condition.equals(temp))
                conditionRepository.delete(condition);
        }

    }

    @Test
    void addTheCondition() {

       assertTrue(conditionService.addTheCondition(conditionListViewModel));
    }
}
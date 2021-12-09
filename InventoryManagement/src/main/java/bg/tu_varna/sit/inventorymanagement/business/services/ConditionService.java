package bg.tu_varna.sit.inventorymanagement.business.services;

import bg.tu_varna.sit.inventorymanagement.data.entities.Condition;
import bg.tu_varna.sit.inventorymanagement.data.repositories.ConditionRepository;
import bg.tu_varna.sit.inventorymanagement.presentation.models.ConditionListViewModel;

public class ConditionService {
    private final ConditionRepository repositoryCondition = ConditionRepository.getInstance();

    public static ConditionService getInstance(){
        return ConditionService.ConditionServiceHolder.INSTANCE;
    }

    private static class ConditionServiceHolder {
        public static final ConditionService INSTANCE = new ConditionService();
    }

    public void addTheCondition(ConditionListViewModel c)
    {
        Condition condition=new Condition(c.getProdCondition());
        repositoryCondition.save(condition);
    }

    public Condition getGoodCondition(){
        Condition c= repositoryCondition.getById(1);
        return c;
    }
}

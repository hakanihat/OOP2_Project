package bg.tu_varna.sit.inventorymanagement.business.services;

import bg.tu_varna.sit.inventorymanagement.data.entities.Condition;
import bg.tu_varna.sit.inventorymanagement.data.repositories.ConditionRepository;
import bg.tu_varna.sit.inventorymanagement.presentation.models.ConditionListViewModel;
import org.apache.log4j.Logger;

import java.util.List;

public class ConditionService {
    private final ConditionRepository repositoryCondition = ConditionRepository.getInstance();
    private static final Logger log= Logger.getLogger(ConditionService.class);
    public static ConditionService getInstance(){
        return ConditionService.ConditionServiceHolder.INSTANCE;
    }

    private static class ConditionServiceHolder {
        public static final ConditionService INSTANCE = new ConditionService();
    }

    public boolean addTheCondition(ConditionListViewModel c)
    {
        Condition condition=new Condition(c.getProdCondition());
        if(isConditionExists(condition))
        {
            return false;
        }
        else {
            repositoryCondition.save(condition);
            return true;
        }
    }

    public Condition getGoodCondition(){
        Condition c= repositoryCondition.getById(1);
        return c;
    }

    public boolean isConditionExists(Condition c){
        List<Condition> allConditions=repositoryCondition.getAll();
        for(Condition condition:allConditions){
            if(condition.equals(c)){
                log.error("Condition is already added!");
                return true;
            }
        }
        return false;
    }
}

package bg.tu_varna.sit.inventorymanagement.data.repositories;

import bg.tu_varna.sit.inventorymanagement.data.access.Connection;
import bg.tu_varna.sit.inventorymanagement.data.entities.Condition;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

public class ConditionRepository implements DAORepository<Condition>{
    private static final Logger log = Logger.getLogger(ConditionRepository.class);
    private static ConditionRepository getInstance(){
        return ConditionRepository.ConditionRepositoryHolder.INSTANCE;}


    private static class ConditionRepositoryHolder {
        public static final  ConditionRepository INSTANCE = new ConditionRepository();
    }

    @Override
    public void save(Condition obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(obj);
            log.info("Condition saved successfully");
        }catch (Exception e)
        {
            log.error("Condition save error" + e.getMessage());
        }finally {
            transaction.commit();

        }   session.close();

    }

    @Override
    public void update(Condition obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(obj);
            log.info("Condition updated successfully");
        }catch (Exception e)
        {
            log.error("Condition update error" + e.getMessage());
        }finally {
            transaction.commit();

        }  session.close();

    }

    @Override
    public void delete(Condition obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(obj);
            log.info("Condition deleted successfully");
        }catch (Exception e)
        {
            log.error("Condition delete error" + e.getMessage());
        }finally {
            transaction.commit();

        }  session.close();

    }

    @Override
    public List<Condition> getById(Long id) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Condition> conditions = new LinkedList<>();//Condition
        try{
            String jpql = "SELECT c FROM Condition c WHERE pkCondition ="+id;// taka li e?
            conditions.addAll(session.createQuery(jpql, Condition.class).getResultList());
            log.info("Successfully got  condition!");
        }catch (Exception e){
            log.error("Get Condition error: " +e.getMessage());
        }finally {
            transaction.commit();

        }session.close();
        return conditions;
    }

    @Override
    public List<Condition> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Condition> admins = new LinkedList<>();
        try{
            String jpql = "SELECT a FROM Admin a ";
            admins.addAll(session.createQuery(jpql, Condition.class).getResultList());
            log.info("Successfully got all admins");
        }catch (Exception e){
            log.error("Get Admin error: " +e.getMessage());
        }finally {
            transaction.commit();

        }  session.close();
        return admins;
    }

}

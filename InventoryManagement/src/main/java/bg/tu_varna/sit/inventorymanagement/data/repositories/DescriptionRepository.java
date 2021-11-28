package bg.tu_varna.sit.inventorymanagement.data.repositories;

import bg.tu_varna.sit.inventorymanagement.data.access.Connection;
import bg.tu_varna.sit.inventorymanagement.data.entities.Description;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

public class DescriptionRepository implements DAORepository<Description>{

    private static final Logger log = Logger.getLogger(DescriptionRepository.class);
    public static DescriptionRepository getInstance(){
        return DescriptionRepository.DescriptionRepositoryHolder.INSTANCE;}


    private static class DescriptionRepositoryHolder {
        public static final DescriptionRepository INSTANCE = new DescriptionRepository();
    }
    @Override
    public void save(Description obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(obj);
            log.info("Description saved successfully");
        }catch (Exception e)
        {
            log.error("Description save error" + e.getMessage());
        }finally {
            transaction.commit();

        } session.close();
    }

    @Override
    public void update(Description obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(obj);
            log.info("Description board updated successfully");
        }catch (Exception e)
        {
            log.error("Description board update error" + e.getMessage());
        }finally {
            transaction.commit();

        }  session.close();
    }

    @Override
    public void delete(Description obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(obj);
            log.info("Description board deleted successfully");
        }catch (Exception e)
        {
            log.error("Description board delete error" + e.getMessage());
        }finally {
            transaction.commit();

        }session.close();
    }

    @Override
    public List<Description> getById(Long id) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Description> description = new LinkedList<>();
        try{
            String jpql = "SELECT d FROM Description d WHERE pkDescription ="+id;
            description.addAll(session.createQuery(jpql, Description.class).getResultList());
            log.info("Successfully got  Description!");
        }catch (Exception e){
            log.error("Get Description error: " +e.getMessage());
        }finally {
            transaction.commit();

        } session.close();
        return description;
    }

    @Override
    public List<Description> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Description> description = new LinkedList<>();
        try{
            String jpql = "SELECT d FROM Description d";
            description.addAll(session.createQuery(jpql, Description.class).getResultList());
            log.info("Successfully got  Description!");
        }catch (Exception e){
            log.error("Get Description error: " +e.getMessage());
        }finally {
            transaction.commit();

        }  session.close();
        return description;
    }
}

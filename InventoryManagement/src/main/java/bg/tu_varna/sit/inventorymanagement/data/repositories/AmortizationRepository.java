package bg.tu_varna.sit.inventorymanagement.data.repositories;

import bg.tu_varna.sit.inventorymanagement.data.access.Connection;
import bg.tu_varna.sit.inventorymanagement.data.entities.Amortization;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
public class AmortizationRepository implements DAORepository<Amortization> {
    private static final Logger log = Logger.getLogger(AmortizationRepository.class);
    public static AmortizationRepository getInstance(){
        return AmortizationRepository.AmortizationRepositoryHolder.INSTANCE;}


    private static class AmortizationRepositoryHolder {
        public static final  AmortizationRepository INSTANCE = new AmortizationRepository();
    }

    @Override
    public void save(Amortization obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(obj);
            log.info("Amortization saved successfully");
        }catch (Exception e)
        {
            log.error("Amortization save error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }

    }

    @Override
    public void update(Amortization obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(obj);
            log.info("Amortization updated successfully");
        }catch (Exception e)
        {
            log.error("Amortization update error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }

    }

    @Override
    public void delete(Amortization obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(obj);
            log.info("Amortization deleted successfully");
        }catch (Exception e)
        {
            log.error("Amortization delete error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();

        }

    }

    @Override
    public Amortization getById(int id) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Amortization> amort = new LinkedList<>();
        try{
            String jpql = "SELECT a FROM Amortization a WHERE idAmortization ="+id;
            amort.addAll(session.createQuery(jpql, Amortization.class).getResultList());
            log.info("Successfully got  amortization!");
        }catch (Exception e){
            log.error("Get Amortization error: " +e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }

        return amort.get(0);
    }

    @Override
    public List<Amortization> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Amortization> admins = new LinkedList<>();
        try{
            String jpql = "SELECT a FROM Amortization a ";
            admins.addAll(session.createQuery(jpql, Amortization.class).getResultList());
            log.info("Successfully got all amortization");
        }catch (Exception e){
            log.error("Get Amortization error: " +e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }

        return admins;
    }
}

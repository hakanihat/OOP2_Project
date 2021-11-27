package bg.tu_varna.sit.inventorymanagement.data.repositories;

import bg.tu_varna.sit.inventorymanagement.data.access.Connection;
import bg.tu_varna.sit.inventorymanagement.data.entities.Customer;
import bg.tu_varna.sit.inventorymanagement.data.entities.CustomerBoard;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

public class CustomerBoardRepository implements DAORepository<CustomerBoard>{

    private static final Logger log = Logger.getLogger(CustomerBoardRepository.class);
    private static CustomerBoardRepository getInstance(){
        return CustomerBoardRepository.CustomerBoardRepositoryHolder.INSTANCE;}


    private static class CustomerBoardRepositoryHolder {
        public static final CustomerBoardRepository INSTANCE = new CustomerBoardRepository();
    }
    @Override
    public void save(CustomerBoard obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(obj);
            log.info("Customer board saved successfully");
        }catch (Exception e)
        {
            log.error("Customer board save error" + e.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public void update(CustomerBoard obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(obj);
            log.info("Customer board updated successfully");
        }catch (Exception e)
        {
            log.error("Customer board update error" + e.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public void delete(CustomerBoard obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(obj);
            log.info("Customer board deleted successfully");
        }catch (Exception e)
        {
            log.error("Customer board delete error" + e.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public List<CustomerBoard> getById(Long id) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<CustomerBoard> customerBoards = new LinkedList<>();
        try{
            String jpql = "SELECT cb FROM CustomerBoard cb WHERE pkCustomerBoard ="+id;
            customerBoards.addAll(session.createQuery(jpql, CustomerBoard.class).getResultList());
            log.info("Successfully got  Customer Board!");
        }catch (Exception e){
            log.error("Get Customer Board error: " +e.getMessage());
        }finally {
            transaction.commit();
        }
        return customerBoards;
    }

    @Override
    public List<CustomerBoard> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<CustomerBoard> customerBoards = new LinkedList<>();
        try{
            String jpql = "SELECT cb FROM CustomerBoard cb ";
            customerBoards.addAll(session.createQuery(jpql, CustomerBoard.class).getResultList());
            log.info("Successfully got  all Customer Boards!");
        }catch (Exception e){
            log.error("Get Customer Boards error: " +e.getMessage());
        }finally {
            transaction.commit();
        }
        return customerBoards;
    }
}

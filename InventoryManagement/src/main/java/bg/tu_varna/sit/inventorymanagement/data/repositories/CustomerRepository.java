package bg.tu_varna.sit.inventorymanagement.data.repositories;

import bg.tu_varna.sit.inventorymanagement.data.access.Connection;
import bg.tu_varna.sit.inventorymanagement.data.entities.Customer;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

public class CustomerRepository implements DAORepository<Customer>{

    private static final Logger log = Logger.getLogger(CustomerRepository.class);
    private static CustomerRepository getInstance(){
        return CustomerRepository.CustomerRepositoryHolder.INSTANCE;}


    private static class CustomerRepositoryHolder {
        public static final CustomerRepository INSTANCE = new CustomerRepository();
    }

    @Override
    public void save(Customer obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(obj);
            log.info("Customer saved successfully");
        }catch (Exception e)
        {
            log.error("Customer save error" + e.getMessage());
        }finally {
            transaction.commit();

        } session.close();
    }

    @Override
    public void update(Customer obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(obj);
            log.info("Customer updated successfully");
        }catch (Exception e)
        {
            log.error("Customer update error" + e.getMessage());
        }finally {
            transaction.commit();

        }session.close();
    }

    @Override
    public void delete(Customer obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(obj);
            log.info("Customer deleted successfully");
        }catch (Exception e)
        {
            log.error("Customer delete error" + e.getMessage());
        }finally {
            transaction.commit();

        }session.close();
    }

    @Override
    public List<Customer> getById(Long id) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Customer> customers = new LinkedList<>();
        try{
            String jpql = "SELECT cu FROM Customer cu WHERE pkCustomer ="+id;
            customers.addAll(session.createQuery(jpql, Customer.class).getResultList());
            log.info("Successfully got  customer!");
        }catch (Exception e){
            log.error("Get Customer error: " +e.getMessage());
        }finally {
            transaction.commit();

        }session.close();
        return customers;
    }

    @Override
    public List<Customer> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Customer> customers = new LinkedList<>();
        try{
            String jpql = "SELECT cu FROM Customer cu ";
            customers.addAll(session.createQuery(jpql, Customer.class).getResultList());
            log.info("Successfully got all customers!");
        }catch (Exception e){
            log.error("Get Customer error: " +e.getMessage());
        }finally {
            transaction.commit();

        }session.close();
        return customers;
    }
}

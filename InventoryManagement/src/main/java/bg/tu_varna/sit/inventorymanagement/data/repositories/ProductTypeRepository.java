package bg.tu_varna.sit.inventorymanagement.data.repositories;

import bg.tu_varna.sit.inventorymanagement.data.access.Connection;
import bg.tu_varna.sit.inventorymanagement.data.entities.Product;
import bg.tu_varna.sit.inventorymanagement.data.entities.ProductType;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

public class ProductTypeRepository implements DAORepository<ProductType>{

    private static final Logger log = Logger.getLogger(ProductTypeRepository.class);
    private static ProductTypeRepository getInstance(){
        return ProductTypeRepository.ProductTypeRepositoryHolder.INSTANCE;}


    private static class ProductTypeRepositoryHolder {
        public static final ProductTypeRepository INSTANCE = new ProductTypeRepository();
    }
    @Override
    public void save(ProductType obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(obj);
            log.info("Product type saved successfully");
        }catch (Exception e)
        {
            log.error("Product type save error" + e.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public void update(ProductType obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(obj);
            log.info("Product type updated successfully");
        }catch (Exception e)
        {
            log.error("Product type update error" + e.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public void delete(ProductType obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(obj);
            log.info("Product type deleted successfully");
        }catch (Exception e)
        {
            log.error("Product type delete error" + e.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public List<ProductType> getById(Long id) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<ProductType> productTypes = new LinkedList<>();
        try{
            String jpql = "SELECT pt FROM ProductType pt WHERE pkProductType ="+id;
            productTypes.addAll(session.createQuery(jpql, ProductType.class).getResultList());
            log.info("Successfully got  Product type!");
        }catch (Exception e){
            log.error("Get Product type error: " +e.getMessage());
        }finally {
            transaction.commit();
        }
        return productTypes;
    }

    @Override
    public List<ProductType> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<ProductType> productTypes = new LinkedList<>();
        try{
            String jpql = "SELECT pt FROM ProductType ";
            productTypes.addAll(session.createQuery(jpql, ProductType.class).getResultList());
            log.info("Successfully got all Product types!");
        }catch (Exception e){
            log.error("Get Product types error: " +e.getMessage());
        }finally {
            transaction.commit();
        }
        return productTypes;
    }
}

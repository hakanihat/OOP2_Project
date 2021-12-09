package bg.tu_varna.sit.inventorymanagement.data.repositories;

import bg.tu_varna.sit.inventorymanagement.data.access.Connection;
import bg.tu_varna.sit.inventorymanagement.data.entities.Product;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

public class ProductRepository implements DAORepository<Product>{

    private static final Logger log = Logger.getLogger(ProductRepository.class);
    public static ProductRepository getInstance(){
        return ProductRepository.ProductRepositoryHolder.INSTANCE;}


    private static class ProductRepositoryHolder {
        public static final ProductRepository INSTANCE = new ProductRepository();
    }
    @Override
    public void save(Product obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(obj);
            log.info("Product saved successfully");
        }catch (Exception e)
        {
            log.error("Product save error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void update(Product obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(obj);
            log.info("Product updated successfully");
        }catch (Exception e)
        {
            log.error("Product update error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void delete(Product obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(obj);
            log.info("Product deleted successfully");
        }catch (Exception e)
        {
            log.error("Product delete error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public Product getById(int id) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Product> products = new LinkedList<>();
        try{
            String jpql = "SELECT p FROM Product p WHERE idInventoryNumber ="+id;
            products.addAll(session.createQuery(jpql, Product.class).getResultList());
            log.info("Successfully got  Product!");
        }catch (Exception e){
            log.error("Get Product error: " +e.getMessage());
        }finally {
            transaction.commit();
            session.close();

        }
        return products.get(0);
    }

    @Override
    public List<Product> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Product> products = new LinkedList<>();
        try{
            String jpql = "SELECT p FROM Product p ";
            products.addAll(session.createQuery(jpql, Product.class).getResultList());
            log.info("Successfully got all Products!");
        }catch (Exception e){
            log.error("Get Products error: " +e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
        return products;
    }
}

package bg.tu_varna.sit.inventorymanagement.data.repositories;
import bg.tu_varna.sit.inventorymanagement.data.access.Connection;
import bg.tu_varna.sit.inventorymanagement.data.entities.Mol;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

public class MolRepository implements  DAORepository<Mol>{

    private static final Logger log = Logger.getLogger(MolRepository.class);
    public static MolRepository getInstance(){
        return MolRepository.MolRepositoryHolder.INSTANCE;}


    private static class MolRepositoryHolder {
        public static final MolRepository INSTANCE = new MolRepository();
    }

    @Override
    public void save(Mol obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(obj);
            log.info("MOL saved successfully");
        }catch (Exception e)
        {
            log.error("MOL save error" + e.getMessage());
        }finally {
            transaction.commit();

        }    session.close();
    }

    @Override
    public void update(Mol obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(obj);
            log.info("MOL updated successfully");
        }catch (Exception e)
        {
            log.error("MOL update error" + e.getMessage());
        }finally {
            transaction.commit();

        } session.close();
    }

    @Override
    public void delete(Mol obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(obj);
            log.info("MOL board deleted successfully");
        }catch (Exception e)
        {
            log.error("MOL board delete error" + e.getMessage());
        }finally {
            transaction.commit();

        }session.close();
    }

    @Override
    public List<Mol> getById(Long id) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Mol> mols = new LinkedList<>();
        try{
            String jpql = "SELECT m FROM Mol m WHERE pkMol ="+id;
            mols.addAll(session.createQuery(jpql, Mol.class).getResultList());
            log.info("Successfully got  Mol!");
        }catch (Exception e){
            log.error("Get Mol error: " +e.getMessage());
        }finally {
            transaction.commit();

        }session.close();
        return mols;
    }

    @Override
    public List<Mol> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Mol> mols = new LinkedList<>();
        try{
            String jpql = "SELECT m FROM Mol m ";
            mols.addAll(session.createQuery(jpql, Mol.class).getResultList());
            log.info("Successfully got  all Mols!");
        }catch (Exception e){
            log.error("Get all Mols error: " +e.getMessage());
        }finally {
            transaction.commit();

        }  session.close();
        return mols;
    }
}

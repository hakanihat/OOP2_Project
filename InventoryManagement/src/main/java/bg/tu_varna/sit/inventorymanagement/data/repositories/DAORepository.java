package bg.tu_varna.sit.inventorymanagement.data.repositories;

import java.util.List;

public interface DAORepository<T> {
    void save(T obj);
    void update(T obj);
    void delete(T obj);
    List<T> getById(Long id);
    List<T> getAll();
}

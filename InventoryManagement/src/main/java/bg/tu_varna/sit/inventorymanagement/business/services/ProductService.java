package bg.tu_varna.sit.inventorymanagement.business.services;

import bg.tu_varna.sit.inventorymanagement.data.entities.Condition;
import bg.tu_varna.sit.inventorymanagement.data.entities.Customer;
import bg.tu_varna.sit.inventorymanagement.data.entities.Product;
import bg.tu_varna.sit.inventorymanagement.data.repositories.ProductRepository;
import bg.tu_varna.sit.inventorymanagement.presentation.models.ConditionListViewModel;
import bg.tu_varna.sit.inventorymanagement.presentation.models.CustomerListViewModel;
import bg.tu_varna.sit.inventorymanagement.presentation.models.ProductListViewModel;

public class ProductService {
    private final ProductRepository repositoryProduct = ProductRepository.getInstance();

    public static ProductService getInstance(){
        return ProductService.ProductServiceHolder.INSTANCE;
    }

    private static class ProductServiceHolder {
        public static final ProductService INSTANCE = new ProductService();
    }

    public void addTheProduct(ProductListViewModel c)
    {       //Product product=new Product(c.);

//dopishi tuk


           // repositoryCondition.save(customer);

    }
}

package bg.tu_varna.sit.inventorymanagement.business.services;

import bg.tu_varna.sit.inventorymanagement.data.entities.Product;
import bg.tu_varna.sit.inventorymanagement.data.repositories.ProductRepository;
import bg.tu_varna.sit.inventorymanagement.presentation.models.ProductListViewModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {
    private ProductService productService;
    private ProductRepository productRepository;
    private Product product;
    private ProductListViewModel productListViewModel;

    @BeforeEach
    void setUp() {
        this.productService=ProductService.getInstance();
        this.productRepository=ProductRepository.getInstance();
        productListViewModel=new ProductListViewModel(1111,"test");
        product=new Product(1251,true);
    }


    @Test
    void getAllProductsInPeriod() {
        List<Product> temp = new ArrayList<>();
        assertEquals(temp,productService.getAllProductsInPeriod(LocalDate.of(2030,10,10),LocalDate.of(2035,5,12)));
    }

    @Test
    void getAllProductsByTypeInPeriod() {
        List<Product> temp = new ArrayList<>();
        assertEquals(temp,productService.getAllProductsInPeriod(LocalDate.of(2030,10,10),LocalDate.of(2035,5,12)));
    }

    @Test
    void getAllProductsByStatInPeriod() {
        List<Product> temp = new ArrayList<>();
        assertEquals(temp,productService.getAllProductsInPeriod(LocalDate.of(2030,10,10),LocalDate.of(2035,5,12)));
    }


    @Test
    void listViewToEntity() {
        ProductListViewModel temp = new  ProductListViewModel(1111,"testing");
        Assertions.assertNull(productService.listViewToEntity(temp));
    }

    @Test
    void getProductById() {
        product= productRepository.getById(1);
        assertEquals(product,productRepository.getById(1));

    }

    @Test
    void changeStatus() {
        product= productRepository.getById(1);
        if(!product.isProdStatus()) {
            productService.changeStatus(product);
            assertTrue(product.isProdStatus());
        }
        else
        {
            productService.changeStatus(product);
            assertFalse(product.isProdStatus());
        }
    }

    @Test
    void getAllProducts() {
        ObservableList<ProductListViewModel> products=productService.getAllProducts();
        assertEquals(products,productService.getAllProducts());
    }

}
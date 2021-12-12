package bg.tu_varna.sit.inventorymanagement.business.services;

import bg.tu_varna.sit.inventorymanagement.data.entities.Product;
import bg.tu_varna.sit.inventorymanagement.data.repositories.ProductRepository;
import bg.tu_varna.sit.inventorymanagement.presentation.models.ProductListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {
    private final ProductRepository repositoryProduct = ProductRepository.getInstance();

    public static ProductService getInstance(){
        return ProductService.ProductServiceHolder.INSTANCE;
    }

    public ObservableList<ProductListViewModel> getAllProductsInPeriod(LocalDate myFromDate, LocalDate myToDate) {
        List<Product> products = repositoryProduct.getAll();
        List<Product> productsInPeriod = new ArrayList<>();
        for(Product p: products){
            if(p.getExploatationStart().isAfter(myFromDate) && p.getExploatationStart().isBefore(myToDate) && (!p.isDiscarded()) )
            {
                productsInPeriod.add(p);
            }
        }
        return FXCollections.observableList(
                productsInPeriod.stream().map(p -> new ProductListViewModel(
                        p.getIdInventoryNumber(),p.getDescription(),p.getProdType(),p.isProdStatus(),p.getExploatationStart(),p.getProductValue(),p.getByMol(),p.getByAmortization(),p.getDiscardDate()
                )).collect(Collectors.toList()));
    }

    public ObservableList<ProductListViewModel> getAllProductsByTypeInPeriod(LocalDate myFromDate, LocalDate myToDate, boolean whatType) {
        List<Product> products = repositoryProduct.getAll();
        List<Product> productsInPeriod = new ArrayList<>();

            if(whatType)
            {for(Product p: products)
                {
                    if(p.getExploatationStart().isAfter(myFromDate) && p.getExploatationStart().isBefore(myToDate) && (!p.isDiscarded()) && p.getProdType().equals("ДМА") )
                    {
                         productsInPeriod.add(p);
                    }
                }
            }
            else
            {for(Product p: products)
                {
                     if (p.getExploatationStart().isAfter(myFromDate) && p.getExploatationStart().isBefore(myToDate) && (!p.isDiscarded()) && p.getProdType().equals("МА"))
                     {
                        productsInPeriod.add(p);
                     }
                }
            }

        return FXCollections.observableList(
                productsInPeriod.stream().map(p -> new ProductListViewModel(
                        p.getIdInventoryNumber(),p.getDescription(),p.getProdType(),p.isProdStatus(),p.getExploatationStart(),p.getProductValue(),p.getByMol(),p.getByAmortization(),p.getDiscardDate()
                )).collect(Collectors.toList()));
    }

    public ObservableList<ProductListViewModel> getAllProductsByStatInPeriod(LocalDate myFromDate, LocalDate myToDate, boolean isAvailable) {
        List<Product> products = repositoryProduct.getAll();
        List<Product> productsInPeriod = new ArrayList<>();

        if(isAvailable)
        {for(Product p: products)
        {
            if(p.getExploatationStart().isAfter(myFromDate) && p.getExploatationStart().isBefore(myToDate) && (!p.isDiscarded()) && p.isProdStatus())
            {
                productsInPeriod.add(p);
            }
        }
        }
        else
        {for(Product p: products)
        {
            if (p.getExploatationStart().isAfter(myFromDate) && p.getExploatationStart().isBefore(myToDate) && (!p.isDiscarded()) && (!p.isProdStatus()))
            {
                productsInPeriod.add(p);
            }
        }
        }

        return FXCollections.observableList(
                productsInPeriod.stream().map(p -> new ProductListViewModel(
                        p.getIdInventoryNumber(),p.getDescription(),p.getProdType(),p.isProdStatus(),p.getExploatationStart(),p.getProductValue(),p.getByMol(),p.getByAmortization(),p.getDiscardDate()
                )).collect(Collectors.toList()));

    }

    private static class ProductServiceHolder {
        public static final ProductService INSTANCE = new ProductService();
    }

    public void addTheProduct(ProductListViewModel p)
    {
         Product product=new Product(p.getDescription(),p.getProdType(),p.isProdStatus(),p.getDiscardDate(),p.getProductValue(),p.getExploatationStart(),p.isDiscarded(),p.getByCondition(),p.getByMol(),p.getByAmortization());
        repositoryProduct.save(product);

    }

    public Product listViewToEntity(ProductListViewModel p){
        Product temp = new Product(p.getIdInventoryNumber(),p.getDescription());
        List<Product> products = repositoryProduct.getAll();
        for (Product product: products) {
            if(product.equals(temp))
                return product;
        }
        return null;
    }

    public Product getProductById(int n)
    {
        Product product = repositoryProduct.getById(n);
        return product;
    }

    public void changeStatus(Product p){
        if(p.isProdStatus()==true)
            p.setProdStatus(false);
        else
            p.setProdStatus(true);
        repositoryProduct.update(p);
    }


    public ObservableList<ProductListViewModel> getAllProducts() {
        List<Product> products = repositoryProduct.getAll();

        return FXCollections.observableList(
                products.stream().map(p -> new ProductListViewModel(
                       p.getIdInventoryNumber(),p.getDescription()
                )).collect(Collectors.toList()));
    }

}

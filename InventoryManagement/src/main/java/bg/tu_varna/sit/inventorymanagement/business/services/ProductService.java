package bg.tu_varna.sit.inventorymanagement.business.services;

import bg.tu_varna.sit.inventorymanagement.data.entities.Product;
import bg.tu_varna.sit.inventorymanagement.data.repositories.ProductRepository;
import bg.tu_varna.sit.inventorymanagement.presentation.models.ProductListViewModel;

public class ProductService {
    private final ProductRepository repositoryProduct = ProductRepository.getInstance();

    public static ProductService getInstance(){
        return ProductService.ProductServiceHolder.INSTANCE;
    }

    private static class ProductServiceHolder {
        public static final ProductService INSTANCE = new ProductService();
    }

    public void addTheProduct(ProductListViewModel p)
    {
        Product product=new Product(p.getDescription(),p.getProdType(),p.isProdStatus(),p.getDiscardDate(),p.getProductValue(),p.getExploatationStart(),p.isDiscarded(),p.getByCondition(),p.getByMol(),p.getByAmortization());
        repositoryProduct.save(product);
    }


}

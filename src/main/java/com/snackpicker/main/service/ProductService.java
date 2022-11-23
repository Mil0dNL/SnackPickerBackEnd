package com.snackpicker.main.service;

import com.snackpicker.main.dto.ProductUpdateDTO;
import com.snackpicker.main.model.Product;
import com.snackpicker.main.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    public void deleteProduct(long id)
    {productRepository.deleteById(id);}

    public Product saveProduct(Product product)
    {return productRepository.save(product);}

    public List<Product> getAll()
    {return productRepository.findAll();}

    public Optional<Product> getById(long id)
    {return productRepository.findById(id);}

    public Product update(ProductUpdateDTO product)
    {
        Product _product = getById(product.id).get();
        _product.setName(product.name);
        _product.setBarcode(product.barcode);
        return productRepository.save(_product);
    }


}

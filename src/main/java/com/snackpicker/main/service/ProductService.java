package com.snackpicker.main.service;

import com.snackpicker.main.model.Product;
import com.snackpicker.main.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void deleteProduct(long id)
    {productRepository.deleteById(id);}

    public Product saveProduct(Product product)
    {return productRepository.save(product);}

    public List<Product> getAll()
    {return productRepository.findAll();}

    public Optional<Product> getById(long id)
    {return productRepository.findById(id);}


}

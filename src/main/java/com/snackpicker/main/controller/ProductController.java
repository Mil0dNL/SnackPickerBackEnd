package com.snackpicker.main.controller;

import com.snackpicker.main.dto.ProductUpdateDTO;
import com.snackpicker.main.model.Product;
import com.snackpicker.main.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAll()
    {
        try
        {
            return productService.getAll();
        }
        catch(Exception e)
        {return null;}
    }

    @PostMapping
    public String create(@RequestBody Product product)
    {
        try
        {
            productService.saveProduct(product);
            return "new product created";
        }
        catch(Exception e)
        {return "Error creating product";}
    }

    @PutMapping("/update")
    public Product update(@RequestBody ProductUpdateDTO product)
    {
        try
        {
            return productService.update(product);
        }
        catch(Exception e) {e.printStackTrace(); return null;}
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable(value="id") long id)
    {
        try
        {
            productService.deleteProduct(id);
        }
        catch(Exception e) {e.printStackTrace();}
    }


    @GetMapping("/{id}")
    public Product findById(@PathVariable(value = "id") long id)
    {
        try
        {
            return productService.getById(id).get();
        }
        catch(Exception e)
        {return null;}
    }

}

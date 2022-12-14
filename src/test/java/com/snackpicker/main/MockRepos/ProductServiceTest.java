package com.snackpicker.main.MockRepos;

import com.snackpicker.main.model.Product;
import com.snackpicker.main.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ProductServiceTest {

    private ProductService productService;

    String productName_1 = "Cookie";
    long productID_1 = 12;
    String productBarcode_1 = "54794613";

    String productName_2 = "Coffee";
    long productID_2 = 14;
    String productBarcode_2 = "12345678";


    //TODO: Mockito

/*

    @BeforeEach
    void setup() throws Exception
    {
        this.mockProductRepo = new MockProductRepo();

        List<Product> products = new ArrayList<Product>();

        Product product_1 = new Product();
        product_1.setName(productName_1);
        product_1.setBarcode(productBarcode_1);
        product_1.setId(productID_1);

        Product product_2 = new Product();
        product_2.setName(productName_2);
        product_2.setBarcode(productBarcode_2);
        product_2.setId(productID_2);

        products.add(product_1);
        products.add(product_2);

        mockProductRepo.setupDataBase(products);
        this.productService = new ProductService(mockProductRepo);

    }

    @Test
    void findProductByIdTest(){
        Product product = productService.getById(productID_1).get();

        Assertions.assertNotNull(product);
        Assertions.assertEquals(productID_1, product.getId());
        Assertions.assertEquals(productBarcode_1, product.getBarcode());
        Assertions.assertEquals(productName_1, product.getName());
    }

*/

}

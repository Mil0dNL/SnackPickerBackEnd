package com.snackpicker.main.MockRepos;

import com.snackpicker.main.model.Product;
import com.snackpicker.main.model.SnackUser;
import com.snackpicker.main.repository.ProductRepository;
import com.snackpicker.main.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.mockito.Mock;
import org.mockito.junit.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Mock private ProductRepository productRepository;

    private ProductService productService;

    List<Product> productList;

    @BeforeEach void setup()
    {
        this.productService = new ProductService(productRepository);
    }

    @Test
    void TestGetAll()
    {
        //setup mocks
        productList = new ArrayList<>();

        Product p1 = new Product();
        p1.setId((long)1);
        p1.setName("Lotus");
        p1.setBarcode("12345678");
        productList.add(p1);

        Product p2 = new Product();
        p2.setId((long)1);
        p2.setName("Oreo");
        p2.setBarcode("45678901");
        productList.add(p2);

        //setup mockito
        Mockito.when(productRepository.findAll()).thenReturn(productList);

        //assert
        Assertions.assertEquals(2, productService.getAll().size());
    }

    @Test
    void TestGetById()
    {
        Product p1 = new Product();
        p1.setId((long)1);
        p1.setName("Lotus");
        p1.setBarcode("12345678");

        Product p2 = new Product();
        p2.setId((long)2);
        p2.setName("Oreo");
        p2.setBarcode("45678901");

        //setup mockito
        Mockito.when(productRepository.findById((long)1)).thenReturn(Optional.ofNullable(p1));
        Mockito.when(productRepository.findById((long)2)).thenReturn(Optional.ofNullable(p2));

        //assert
        Assertions.assertEquals(1, productService.getById((long)1).get().getId());
        Assertions.assertEquals(2, productService.getById((long)2).get().getId());

        Assertions.assertEquals("Lotus", productService.getById((long)1).get().getName());
        Assertions.assertEquals("Oreo", productService.getById((long)2).get().getName());

        Assertions.assertEquals("12345678", productService.getById((long)1).get().getBarcode());
        Assertions.assertEquals("45678901", productService.getById((long)2).get().getBarcode());

    }

    @Test
    void TestSave()
    {
        //setup mocks
        Product p1 = new Product();
        p1.setId((long)1);
        p1.setName("Lotus");
        p1.setBarcode("12345678");

        Mockito.when(productRepository.save(p1)).thenReturn(p1);

        Product savedProduct = productService.saveProduct(p1);

        Assertions.assertEquals(1, savedProduct.getId());
        Assertions.assertEquals("Lotus", savedProduct.getName());
        Assertions.assertEquals("12345678", savedProduct.getBarcode());
    }


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

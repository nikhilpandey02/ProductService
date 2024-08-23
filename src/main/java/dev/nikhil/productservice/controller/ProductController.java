package dev.nikhil.productservice.controller;

import dev.nikhil.productservice.model.Product;
import dev.nikhil.productservice.services.FakeStoreProductService;
import dev.nikhil.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long productId){

        if(productId<1 || productId>20)
        {

            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
       Product product= productService.getProductById(productId);
        return new ResponseEntity<>(product,HttpStatusCode.valueOf(200));

    }
}

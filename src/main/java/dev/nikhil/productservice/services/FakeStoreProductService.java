package dev.nikhil.productservice.services;

import dev.nikhil.productservice.dtos.FakeStoreProductDto;
import dev.nikhil.productservice.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
@Service
public class FakeStoreProductService implements ProductService{
    @Override
  //  @GetMapping("/products/{id}")
    public Product getProductById(long id) {

        String url="https://fakestoreapi.com/products/"+id;
        RestTemplate restTemplate=new RestTemplate();
       FakeStoreProductDto fakeStoreProductDto=  restTemplate.getForObject(url, FakeStoreProductDto.class);

       return convertfakeStoreProductDtoToProduct(fakeStoreProductDto);
    }
    public Product convertfakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto)
    {
        Product product=new Product();
        product.setName(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setCategory(fakeStoreProductDto.getCategory());
        return  product;
    }
}

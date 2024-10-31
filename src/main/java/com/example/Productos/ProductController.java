// ProductController.java
package com.example.Productos;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(@Qualifier("productServiceProxy") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public Optional<Product> getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }
}

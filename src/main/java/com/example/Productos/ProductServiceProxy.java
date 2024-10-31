// ProductServiceProxy.java
package com.example.Productos;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Primary // Indica que este bean es el predeterminado para ProductService
public class ProductServiceProxy implements ProductService {
    private final ProductService productService;
    private final Map<String, Product> cache = new HashMap<>();

    public ProductServiceProxy(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Optional<Product> getProductById(String id) {
        if (cache.containsKey(id)) {
            System.out.println("Producto encontrado en caché: " + id);
            return Optional.of(cache.get(id));
        }
        System.out.println("Producto no encontrado en caché, llamando a ProductService");
        Optional<Product> product = productService.getProductById(id);
        product.ifPresent(value -> cache.put(id, value));
        return product;
    }
}

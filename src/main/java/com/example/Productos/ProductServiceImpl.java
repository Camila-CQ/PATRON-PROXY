// ProductServiceImpl.java
package com.example.Productos;

import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Optional<Product> getProductById(String id) {
        try {
            Thread.sleep(1000); // Simula una operación de procesamiento costosa
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Optional.of(new Product(id, "Producto " + id, "Descripción del producto " + id));
    }
}

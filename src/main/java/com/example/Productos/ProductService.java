// ProductService.java
package com.example.Productos;

import java.util.Optional;

public interface ProductService {
    Optional<Product> getProductById(String id);
}

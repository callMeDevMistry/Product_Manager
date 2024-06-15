package com.productManager.demo.Repository;

import com.productManager.demo.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

    public Product findByName(String name);
}

package com.productManager.demo.Service;

import com.productManager.demo.Model.Product;
import com.productManager.demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void save(Product p){
        productRepository.save(p);
    }

    public void saveAll(List<Product> p){
        productRepository.saveAll(p);
    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public boolean exist(Product p){
        return productRepository.existsById(p.getId());
    }

    public Product get(Product p){
        return productRepository.findById(p.getId()).get();
    }

    public Product getById(int p){
        return productRepository.findById((long) p).get();
    }

    public Product getByName(String p){
        return productRepository.findByName(p);
    }

    public void deleteAllProducts(){
        productRepository.deleteAll();
    }
    public void deleteProduct(Product product){
        productRepository.delete(product);
    }

    public void deleteByName(String name) {
        Product product = productRepository.findByName(name);
        productRepository.delete(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void updateProduct(Product product, Long id) {
        productRepository.deleteById(id);
        product.setId(id);
        productRepository.save(product);
    }
}

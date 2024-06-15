package com.productManager.demo.Controller;

import com.productManager.demo.Model.Product;
import com.productManager.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> products(){
        return productService.getAll();
    }

    @GetMapping("/product/{id}")
    public Product product(@RequestParam("id") int name){
        return productService.getById(name);
    }

    @GetMapping("/product/{name}")
    public Product productByName(@RequestParam("name") String name){
        return productService.getByName(name);
    }

    @PostMapping("/addProduct")
    public void AddProduct(@RequestBody Product product ){
        productService.save(product);
    }

    @PostMapping("/addAllProduct")
    public void AddAllProduct( @RequestBody List<Product> product ){
        productService.saveAll(product);
    }

    @DeleteMapping("/deleteAllProduct")
    public void deleteAllProduct(){
        productService.deleteAllProducts();
    }

    @DeleteMapping("/deleteProduct/{name}")
    public void deleteProduct(@PathVariable("name") String name ){
        productService.deleteByName(name);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable("id") Long id ){
        productService.deleteById(id);
    }

    @PostMapping("/updateProduct/{id}")
    public void updateProduct(@RequestBody Product product,
                              @PathVariable Long id){
        productService.updateProduct(product,id);
    }
}

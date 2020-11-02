package org.example.controller;

import org.example.dto.ProductDto;
import org.example.exception.ProductNotFoundException;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;
    ResponseEntity responseEntity;

    @GetMapping("/products")
    public ResponseEntity<Page<ProductDto>> getProducts(@RequestParam(required = false, defaultValue = "0") Integer pageNr,
                                                        @RequestParam(required = false, defaultValue = "20") Integer pageSize) {
        return new ResponseEntity<>(productService.get(pageNr, pageSize), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        try {
            responseEntity = new ResponseEntity(productService.getProductById(id), HttpStatus.OK);
        } catch (ProductNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        try {
            responseEntity = new ResponseEntity(productService.saveProduct(productDto), HttpStatus.OK);
        } catch (ProductNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @PutMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductDto> editProduct(@RequestBody ProductDto productDto) {
        try {
            responseEntity = new ResponseEntity(productService.saveProduct(productDto), HttpStatus.OK);
        } catch (ProductNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @DeleteMapping("/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductDto> deleteProduct(@PathVariable Long id) {
        try {
            responseEntity = new ResponseEntity(productService.deleteProduct(id), HttpStatus.OK);
        } catch (ProductNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
}

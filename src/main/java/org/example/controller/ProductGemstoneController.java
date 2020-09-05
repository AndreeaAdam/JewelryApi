package org.example.controller;

import org.example.dto.ProductGemstoneDto;
import org.example.exception.ProductGemstoneNotFoundException;
import org.example.service.ProductGemstoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductGemstoneController {
    @Autowired
    private ProductGemstoneService productGemstoneService;
    ResponseEntity responseEntity;

    @GetMapping("/product-gemstones")
    public List<ProductGemstoneDto> readProductGemstones() {
        List<ProductGemstoneDto> productGemstoneDtos = productGemstoneService.getAllProductGemstones();
        return productGemstoneDtos;
    }

    @GetMapping("/product-gemstones/{id}")
    public ResponseEntity<ProductGemstoneDto> getProductGemstoneById(@PathVariable Long id) {
        try {
            responseEntity = new ResponseEntity(productGemstoneService.getGemstoneById(id), HttpStatus.OK);
        } catch (ProductGemstoneNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @PostMapping("/product-gemstones")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductGemstoneDto> addProductGemstone(@RequestBody ProductGemstoneDto productGemstoneDto) {
        try {
            responseEntity = new ResponseEntity(productGemstoneService.saveProductGemstone(productGemstoneDto), HttpStatus.OK);
        } catch (ProductGemstoneNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @PutMapping("/product-gemstones")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductGemstoneDto> editProductGemstone(@RequestBody ProductGemstoneDto productGemstoneDto) {
        try {
            responseEntity = new ResponseEntity(productGemstoneService.saveProductGemstone(productGemstoneDto), HttpStatus.OK);
        } catch (ProductGemstoneNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @DeleteMapping("/product-gemstones/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductGemstoneDto> deleteProductGemstone(@PathVariable Long id) {
        try {
            responseEntity = new ResponseEntity(productGemstoneService.deleteProductGemstone(id), HttpStatus.OK);
        } catch (ProductGemstoneNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

}

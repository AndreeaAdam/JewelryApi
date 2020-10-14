package org.example.controller;

import org.example.dto.ProductMaterialDto;
import org.example.exception.ProductMaterialNotFoundException;
import org.example.service.ProductMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductMaterialController {
    @Autowired
    private ProductMaterialService productMaterialService;
    ResponseEntity responseEntity;

    @GetMapping("product-materials")
    public ResponseEntity<List<ProductMaterialDto>> readProductMaterials() {
        return new ResponseEntity<>(productMaterialService.getAllProductMaterials(), HttpStatus.OK);
    }

    @GetMapping("product-materials/{id}")
    public ResponseEntity<ProductMaterialDto> getProductMaterial(@PathVariable Long id) {
        try {
            responseEntity = new ResponseEntity(productMaterialService.getProductMaterialById(id), HttpStatus.OK);
        } catch (ProductMaterialNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @PostMapping("product-materials")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductMaterialDto> addProductMaterial(@RequestBody ProductMaterialDto productMaterialDto) {
        try {
            responseEntity = new ResponseEntity(productMaterialService.saveProductMaterial(productMaterialDto), HttpStatus.OK);
        } catch (ProductMaterialNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @PutMapping("product-materials")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductMaterialDto> editProductMaterial(@RequestBody ProductMaterialDto productMaterialDto) {
        try {
            responseEntity = new ResponseEntity(productMaterialService.saveProductMaterial(productMaterialDto), HttpStatus.OK);
        } catch (ProductMaterialNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @DeleteMapping("product-materials/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductMaterialDto> deleteProductMaterial(@PathVariable Long id) {
        try {
            responseEntity = new ResponseEntity(productMaterialService.deleteProductMaterial(id), HttpStatus.OK);
        } catch (ProductMaterialNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

}

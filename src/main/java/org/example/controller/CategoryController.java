package org.example.controller;

import org.example.dto.CategoryDto;
import org.example.exception.CategoryNotFoundException;
import org.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<CategoryDto> readCategory() {
        List<CategoryDto> categoryDtos = categoryService.getAllCategories();
        return categoryDtos;
    }

    @GetMapping("categories/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id) {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity(categoryService.getCategoryById(id), HttpStatus.OK);
        } catch (CategoryNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @PutMapping("/categories")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CategoryDto> editCategory(@RequestBody CategoryDto categoryDto) {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity(categoryService.saveCategory(categoryDto), HttpStatus.OK);
        } catch (CategoryNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @PostMapping("/categories")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto) {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity(categoryService.saveCategory(categoryDto), HttpStatus.OK);
        } catch (CategoryNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<CategoryDto> deleteCategory(@PathVariable Long id) {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<>(categoryService.deleteCategory(id), HttpStatus.OK);
        } catch (CategoryNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
}

package org.example.service;

import org.example.dto.CategoryDto;
import org.example.exception.CategoryNotFoundException;
import org.example.mapper.CategoryMapper;
import org.example.model.Category;
import org.example.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper mapper;

    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories
                .stream()
                .map(category -> mapper.categoryToDto(category))
                .collect(Collectors.toList());
    }

    public CategoryDto getCategoryById(Long id) throws CategoryNotFoundException {
        Category category = categoryRepository.findById(id).orElse(null);
        CategoryDto result = null;
        if (category != null) {
            result = mapper.categoryToDto(category);
        } else{
            throw new CategoryNotFoundException();
        }
        return result;
    }

    public CategoryDto saveCategory(CategoryDto categoryDto) throws CategoryNotFoundException {
        if (categoryDto.getId() != null && categoryDto.getId() > 0
                && !categoryRepository.existsById(categoryDto.getId())) {
            throw new CategoryNotFoundException();
        }
        Category category = mapper.categoryDtoToModel(categoryDto);
        category = categoryRepository.save(category);
        return mapper.categoryToDto(category);

    }

    public CategoryDto deleteCategory(Long id) throws CategoryNotFoundException {
        CategoryDto categoryDto = getCategoryById(id);
        categoryRepository.delete(mapper.categoryDtoToModel(categoryDto));
        return categoryDto;
    }
}

package org.example.service;

import org.example.dto.ProductDto;
import org.example.exception.ProductNotFoundException;
import org.example.mapper.ProductMapper;
import org.example.model.Product;
import org.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper mapper;

    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
    public Page<ProductDto> get(Integer pageNr, Integer pageSize){
        Pageable pageable = PageRequest.of(pageNr, pageSize);
        Page<Product> productPage = getAllProducts(pageable); // todo: not null ???

        List<ProductDto> productDtoList = productPage.stream()
                .map(product -> mapper.productToDto(product))
                .collect(Collectors.toList());

        return new PageImpl<>(productDtoList, pageable, productPage.getTotalElements());
    }


    public ProductDto getProductById(Long id) throws ProductNotFoundException {
        Product product = productRepository.findById(id).orElse(null);
        ProductDto productDto;
        if (product != null) {
            productDto = mapper.productToDto(product);
        } else{
            throw new ProductNotFoundException();
        }
        return productDto;
    }

    public ProductDto saveProduct(ProductDto productDto) throws ProductNotFoundException {
        if (productDto.getId() != null && productDto.getId() > 0
                && !productRepository.existsById(productDto.getId())) {
            throw new ProductNotFoundException();
        }
        Product product = mapper.productDtoToModel(productDto);
        product = productRepository.save(product);
        return mapper.productToDto(product);
    }

    public ProductDto deleteProduct(Long id) throws ProductNotFoundException {
        ProductDto productDto = getProductById(id);
        productRepository.delete(mapper.productDtoToModel(productDto));
        return productDto;
    }
}

package org.example.service;

import org.example.dto.ProductGemstoneDto;
import org.example.exception.ProductGemstoneNotFoundException;
import org.example.mapper.ProductGemstoneMapper;
import org.example.model.ProductGemstone;
import org.example.repository.ProductGemstoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductGemstoneService {
    @Autowired
    private ProductGemstoneRepository productGemstoneRepository;
    @Autowired
    private ProductGemstoneMapper mapper;

    public List<ProductGemstoneDto> getAllProductGemstones() {
        List<ProductGemstone> productGemstones = productGemstoneRepository.findAll();
        return productGemstones
                .stream()
                .map(productGemstone -> mapper.productGemstoneToDto(productGemstone))
                .collect(Collectors.toList());
    }

    public ProductGemstoneDto getGemstoneById(Long id) throws ProductGemstoneNotFoundException {
        ProductGemstone productGemstone = productGemstoneRepository.findById(id).orElse(null);
        ProductGemstoneDto productGemstoneDto = null;
        if (productGemstone != null) {
            productGemstoneDto = mapper.productGemstoneToDto(productGemstone);
        } else {
            throw new ProductGemstoneNotFoundException();
        }
        return productGemstoneDto;
    }

    public ProductGemstoneDto saveProductGemstone(ProductGemstoneDto productGemstoneDto) throws ProductGemstoneNotFoundException {
        if (productGemstoneDto.getId() != null && productGemstoneDto.getId() > 0
                && !productGemstoneRepository.existsById(productGemstoneDto.getId())) {
            throw new ProductGemstoneNotFoundException();
        }
        ProductGemstone productGemstone = mapper.productGemstoneDtoToModel(productGemstoneDto);
        productGemstone = productGemstoneRepository.save(productGemstone);
        return mapper.productGemstoneToDto(productGemstone);
    }

    public ProductGemstoneDto deleteProductGemstone(Long id) throws ProductGemstoneNotFoundException {
        ProductGemstoneDto productGemstoneDto = getGemstoneById(id);
        productGemstoneRepository.delete(mapper.productGemstoneDtoToModel(productGemstoneDto));
        return productGemstoneDto;
    }
}

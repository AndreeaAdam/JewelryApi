package org.example.service;

import org.example.dto.ProductMaterialDto;
import org.example.exception.ProductMaterialNotFoundException;
import org.example.mapper.ProductMaterialMapper;
import org.example.model.ProductMaterial;
import org.example.repository.ProductMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMaterialService {
    @Autowired
    private ProductMaterialRepository productMaterialRepository;
    @Autowired
    private ProductMaterialMapper mapper;

    public List<ProductMaterialDto> getAllProductMaterials() {
        List<ProductMaterial> productMaterials = productMaterialRepository.findAll();
        return productMaterials
                .stream()
                .map(productMaterial -> mapper.productMaterialToDto(productMaterial))
                .collect(Collectors.toList());
    }

    public ProductMaterialDto getProductMaterialById(Long id) {
        ProductMaterial productMaterial = productMaterialRepository.findById(id).orElse(null);
        ProductMaterialDto productMaterialDto = null;
        if (productMaterial != null) {
            productMaterialDto = mapper.productMaterialToDto(productMaterial);
        }
        return productMaterialDto;
    }

    public ProductMaterialDto saveProductMaterial(ProductMaterialDto productMaterialDto) throws ProductMaterialNotFoundException {
        if (productMaterialDto.getId() != null && productMaterialDto.getId() > 0
                && productMaterialRepository.existsById(productMaterialDto.getId())) {
            throw new ProductMaterialNotFoundException();
        }
        ProductMaterial productMaterial = mapper.productMaterialDtoToModel(productMaterialDto);
        productMaterial = productMaterialRepository.save(productMaterial);
        return mapper.productMaterialToDto(productMaterial);
    }

    public void deleteProductMaterial(Long id) {
        ProductMaterialDto productMaterialDto = getProductMaterialById(id);
        productMaterialRepository.delete(mapper.productMaterialDtoToModel(productMaterialDto));
        productMaterialRepository.deleteById(id);
    }
}

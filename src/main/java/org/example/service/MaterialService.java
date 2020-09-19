package org.example.service;

import org.example.dto.MaterialDto;
import org.example.exception.MaterialNotFoundException;
import org.example.mapper.MaterialMapper;
import org.example.model.Material;
import org.example.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MaterialService {
    @Autowired
    private MaterialRepository materialRepository;
    @Autowired
    private MaterialMapper mapper;

    public List<MaterialDto> getAllMaterials() {
        List<Material> materials = materialRepository.findAll();
        return materials
                .stream()
                .map(material -> mapper.materialToDto(material))
                .collect(Collectors.toList());
    }

    public MaterialDto getMaterialById(Long id) throws MaterialNotFoundException {
        Material material = materialRepository.findById(id).orElse(null);
        MaterialDto materialDto = null;
        if (material != null) {
            materialDto = mapper.materialToDto(material);
        } else {
            throw new MaterialNotFoundException();
        }
        return materialDto;
    }

    public MaterialDto saveMaterial(MaterialDto materialDto) throws MaterialNotFoundException {
        if (materialDto.getId() != null && materialDto.getId() > 0
                && !materialRepository.existsById(materialDto.getId())) {
            throw new MaterialNotFoundException();
        }
        Material material = mapper.materialDtoToModel(materialDto);
        material = materialRepository.save(material);
        return mapper.materialToDto(material);
    }

    public MaterialDto deleteMaterial(Long id) throws MaterialNotFoundException {
        MaterialDto materialDto = getMaterialById(id);
        materialRepository.delete(mapper.materialDtoToModel(materialDto));
        return materialDto;

    }
}

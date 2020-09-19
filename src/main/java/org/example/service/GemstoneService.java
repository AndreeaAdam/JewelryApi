package org.example.service;

import org.example.dto.GemstoneDto;
import org.example.exception.GemstoneNotFoundException;
import org.example.mapper.GemstoneMapper;
import org.example.model.Gemstone;
import org.example.repository.GemstoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GemstoneService {
    @Autowired
    private GemstoneRepository gemstoneRepository;
    @Autowired
    private GemstoneMapper mapper;

    public List<GemstoneDto> getAllGemstones() {
        List<Gemstone> gemstones = gemstoneRepository.findAll();
        return gemstones
                .stream()
                .map(gemstone -> mapper.gemstoneToDto(gemstone))
                .collect(Collectors.toList());
    }

    public GemstoneDto getGemstoneById(Long id) throws GemstoneNotFoundException {
        Gemstone gemstone = gemstoneRepository.findById(id).orElse(null);
        GemstoneDto result = null;
        if (gemstone != null) {
            result = mapper.gemstoneToDto(gemstone);
        } else {
            throw new GemstoneNotFoundException();
        }
        return result;
    }

    public GemstoneDto saveGemstone(GemstoneDto gemstoneDto) throws GemstoneNotFoundException {
        if (gemstoneDto.getId() != null && gemstoneDto.getId() > 0
                && !gemstoneRepository.existsById(gemstoneDto.getId())) {
            throw new GemstoneNotFoundException();
        }
        Gemstone gemstone = mapper.gemstoneDtoToModel(gemstoneDto);
        gemstone = gemstoneRepository.save(gemstone);
        return mapper.gemstoneToDto(gemstone);
    }

    public GemstoneDto deleteGemstone(Long id) throws GemstoneNotFoundException {
        GemstoneDto gemstoneDto = getGemstoneById(id);
        gemstoneRepository.delete(mapper.gemstoneDtoToModel(gemstoneDto));
        return gemstoneDto;
    }
}

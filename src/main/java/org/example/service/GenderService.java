package org.example.service;

import org.example.dto.GenderDto;
import org.example.exception.GenderNotFoundException;
import org.example.mapper.GenderMapper;
import org.example.model.Gender;
import org.example.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenderService {
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private GenderMapper mapper;

    public List<GenderDto> getAllGenders() {
        List<Gender> genders = genderRepository.findAll();
        return genders
                .stream()
                .map(gender -> mapper.genderToDto(gender))
                .collect(Collectors.toList());
    }

    public GenderDto getGenderById(Long id) throws GenderNotFoundException {
        Gender gender = genderRepository.findById(id).orElse(null);
        GenderDto genderDto = null;
        if (gender != null) {
            genderDto = mapper.genderToDto(gender);
        } else{
            throw new GenderNotFoundException();
        }
        return genderDto;
    }

    public GenderDto saveGender(GenderDto genderDto) throws GenderNotFoundException {
        if (genderDto.getId() != null && genderDto.getId() > 0
                && genderRepository.existsById(genderDto.getId())) {
            throw new GenderNotFoundException();
        }
        Gender gender = mapper.genderDtoToModel(genderDto);
        gender = genderRepository.save(gender);
        return mapper.genderToDto(gender);
    }

    public GenderDto deleteGender(Long id) throws GenderNotFoundException {
        GenderDto genderDto = getGenderById(id);
        genderRepository.delete(mapper.genderDtoToModel(genderDto));
        return genderDto;

    }
}

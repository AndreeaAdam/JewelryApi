package org.example.controller;

import org.example.dto.GemstoneDto;
import org.example.dto.GenderDto;
import org.example.exception.GenderNotFoundException;
import org.example.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GenderController {
    @Autowired
    private GenderService genderService;
    ResponseEntity responseEntity;

    @GetMapping("/genders")
    public List<GenderDto> readGenders() {
        List<GenderDto> genderDtos = genderService.getAllGenders();
        return genderDtos;
    }

    @GetMapping("/genders/{id}")
    public ResponseEntity<GenderDto> getGenderById(@PathVariable Long id) {
        try {
            responseEntity = new ResponseEntity(genderService.getGenderById(id), HttpStatus.OK);
        } catch (GenderNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @PostMapping("/genders")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<GenderDto> addGender(@RequestBody GenderDto genderDto) {
        try {
            responseEntity = new ResponseEntity(genderService.saveGender(genderDto), HttpStatus.OK);
        } catch (GenderNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @PutMapping("/genders")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<GenderDto> editGender(@RequestBody GenderDto genderDto) {
        try {
            responseEntity = new ResponseEntity(genderService.saveGender(genderDto), HttpStatus.OK);
        } catch (GenderNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @DeleteMapping("/genders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<GenderDto> deleteGender(@PathVariable Long id) {
        try {
            responseEntity = new ResponseEntity(genderService.deleteGender(id), HttpStatus.OK);
        } catch (GenderNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
}

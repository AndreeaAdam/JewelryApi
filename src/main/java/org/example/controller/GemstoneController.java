package org.example.controller;

import org.example.dto.GemstoneDto;
import org.example.exception.GemstoneNotFoundException;
import org.example.service.GemstoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GemstoneController {
    @Autowired
    private GemstoneService gemstoneService;
    ResponseEntity responseEntity;

    @GetMapping("/gemstones")
    public ResponseEntity<List<GemstoneDto>> readGemstones() {
        return new ResponseEntity<>(gemstoneService.getAllGemstones(), HttpStatus.OK);
    }

    @GetMapping("/gemstones/{id}")
    public ResponseEntity<GemstoneDto> getGemstoneById(@PathVariable Long id) {
        try {
            responseEntity = new ResponseEntity(gemstoneService.getGemstoneById(id), HttpStatus.OK);
        } catch (GemstoneNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @PostMapping("/gemstones")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<GemstoneDto> addGemstone(@RequestBody GemstoneDto gemstoneDto) {
        try {
            responseEntity = new ResponseEntity(gemstoneService.saveGemstone(gemstoneDto), HttpStatus.OK);
        } catch (GemstoneNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @PutMapping("/gemstones")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<GemstoneDto> editGemstone(@RequestBody GemstoneDto gemstoneDto) {
        try {
            responseEntity = new ResponseEntity(gemstoneService.saveGemstone(gemstoneDto), HttpStatus.OK);
        } catch (GemstoneNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @DeleteMapping("/gemstones/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<GemstoneDto> deleteGemstone(@PathVariable Long id) {
        try {
            responseEntity = new ResponseEntity(gemstoneService.deleteGemstone(id), HttpStatus.OK);
        } catch (GemstoneNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
}

package org.example.controller;

import org.example.dto.MaterialDto;
import org.example.exception.MaterialNotFoundException;
import org.example.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MaterialController {
    @Autowired
    private MaterialService materialService;
    ResponseEntity responseEntity;

    @GetMapping("/materials")
    public List<MaterialDto> readMaterials() {
        List<MaterialDto> materialDtos = materialService.getAllMaterials();
        return materialDtos;
    }

    @GetMapping("/materials/{id}")
    public ResponseEntity<MaterialDto> getMaterialById(@PathVariable Long id) {
        try {
            responseEntity = new ResponseEntity(materialService.getMaterialById(id), HttpStatus.OK);
        } catch (MaterialNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @PostMapping("/materials")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MaterialDto> addMaterial(@RequestBody MaterialDto materialDto) {
        try {
            responseEntity = new ResponseEntity(materialService.saveMaterial(materialDto), HttpStatus.OK);
        } catch (MaterialNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @PutMapping("/materials")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MaterialDto> editMaterial(@RequestBody MaterialDto materialDto) {
        try {
            responseEntity = new ResponseEntity(materialService.saveMaterial(materialDto), HttpStatus.OK);
        } catch (MaterialNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @DeleteMapping("/materials/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MaterialDto> deleteMaterial(@PathVariable Long id) {
        try {
            responseEntity = new ResponseEntity(materialService.deleteMaterial(id), HttpStatus.OK);
        } catch (MaterialNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
}

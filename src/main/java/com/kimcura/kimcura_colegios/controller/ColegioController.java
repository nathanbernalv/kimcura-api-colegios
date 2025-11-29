package com.kimcura.kimcura_colegios.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kimcura.kimcura_colegios.dto.ColegioDTO;
import com.kimcura.kimcura_colegios.entity.ColegioEntity;
import com.kimcura.kimcura_colegios.service.ColegioService;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/colegios")
public class ColegioController {

    private final ColegioService colegioService;

    public ColegioController(ColegioService colegioService) {
        this.colegioService = colegioService;
    }

    @GetMapping
    public List<ColegioDTO> getColegios() {
        return colegioService.getAllColegios();
    }
    
    @GetMapping("{id}")
    public ColegioDTO getColegioById(@RequestParam UUID id) {
        return colegioService.getColegioById(id);
    }
    
    @PutMapping
    public ColegioDTO setColecio(@RequestBody ColegioEntity colegio) {
        return colegioService.createColegio(colegio);
    }

    @PutMapping("{id}")
    public ColegioDTO updateColegioById(@PathVariable UUID id, @RequestBody ColegioEntity colegio) {
        return colegioService.updateColegioById(id, colegio);
    }

    @DeleteMapping("{id}")
    public Boolean deleteColegioById(@PathVariable UUID id) {
        return colegioService.removeColegioById(id);    
    }

}

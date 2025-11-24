package com.kimcura.kimcura_colegios.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kimcura.kimcura_colegios.model.ColegioModel;
import com.kimcura.kimcura_colegios.service.ColegioService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/colegios")
public class ColegioController {

    private final ColegioService colegioService;

    public ColegioController(ColegioService colegioService) {
        this.colegioService = colegioService;
    }

    @GetMapping
    public List<ColegioModel> getColegios() {
        return colegioService.getAllColegios();
    }
    

}

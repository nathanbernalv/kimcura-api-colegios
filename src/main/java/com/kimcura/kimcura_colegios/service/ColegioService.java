package com.kimcura.kimcura_colegios.service;

import java.util.List;
import java.util.UUID;

import com.kimcura.kimcura_colegios.dto.ColegioDTO;
import com.kimcura.kimcura_colegios.entity.ColegioEntity;

public interface ColegioService {

    ColegioDTO createColegio(ColegioEntity colegioModel);
    ColegioDTO getColegioById(UUID id);
    List<ColegioDTO> getAllColegios();
    Boolean removeColegioById(UUID id);
    ColegioDTO updateColegioById(UUID id, ColegioEntity colegio);

}

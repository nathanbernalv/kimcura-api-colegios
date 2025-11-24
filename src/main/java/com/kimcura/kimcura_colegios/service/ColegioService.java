package com.kimcura.kimcura_colegios.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.kimcura.kimcura_colegios.model.ColegioModel;

public interface ColegioService {

    ColegioModel createColegio(ColegioModel colegioModel);
    Optional<ColegioModel> getColegioById(UUID id);
    List<ColegioModel> getAllColegios();
    Boolean removeColegioById(UUID id);
    ColegioModel updateColegioById(UUID id, ColegioModel colegio);

}

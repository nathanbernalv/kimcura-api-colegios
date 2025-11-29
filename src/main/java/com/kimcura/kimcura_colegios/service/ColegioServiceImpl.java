package com.kimcura.kimcura_colegios.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kimcura.kimcura_colegios.dto.ColegioDTO;
import com.kimcura.kimcura_colegios.entity.ColegioEntity;
import com.kimcura.kimcura_colegios.repository.ColegioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ColegioServiceImpl implements ColegioService {

    private final ColegioRepository colegioRepository;

    public ColegioServiceImpl(ColegioRepository colegioRepository) {
        this.colegioRepository = colegioRepository;
    }

    @Override
    public ColegioDTO createColegio(ColegioEntity colegio) {
        if (colegio.equals(null)) {
            return null;
        }
        ColegioEntity colegioEntity = colegioRepository.save(colegio);
        if (colegioEntity.equals(null)) {
            return null;
        }
        return new ColegioDTO(colegioEntity.getId(), colegioEntity.getName(), colegioEntity.getAddress());
    }
    
    @Override
    public ColegioDTO getColegioById(UUID id) {
        ColegioEntity colegioEntity = colegioRepository.getColegiopById(id);
        if (colegioEntity.equals(null)) {
            return null;
        }
        return new ColegioDTO(colegioEntity.getId(), colegioEntity.getName(), colegioEntity.getAddress());
    }

    @Override
    public List<ColegioDTO> getAllColegios() {
        List<ColegioEntity> colegioList = colegioRepository.findAll();
        return colegioList.stream()
            .map(colegio -> new ColegioDTO(colegio.getId(), colegio.getName(), colegio.getAddress()))
            .collect(Collectors.toList());
    }

    @Override
    public Boolean removeColegioById(UUID id) {
        colegioRepository.deleteColegiopById(id);
        ColegioEntity colegio = colegioRepository.getColegiopById(id);
        if (colegio.equals(null)) {
            return false;
        }
        return true;
    }

    @Override
    public ColegioDTO updateColegioById(UUID id, ColegioEntity colegio) {
        if (colegio.equals(null)) {
            return null;
        }
        colegioRepository.save(colegio);
        ColegioEntity colegioEntity = colegioRepository.getColegiopById(id);
        if (colegioEntity.equals(null)) {
            return null;
        }
        return new ColegioDTO(colegioEntity.getId(), colegioEntity.getName(), colegioEntity.getAddress());
        
    }

}

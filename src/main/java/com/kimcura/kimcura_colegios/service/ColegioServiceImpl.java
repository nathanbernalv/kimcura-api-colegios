package com.kimcura.kimcura_colegios.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.kimcura.kimcura_colegios.model.ColegioModel;
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
    public ColegioModel createColegio(ColegioModel colegio) {
        return colegioRepository.save(colegio);
    }
    
    @Override
    public Optional<ColegioModel> getColegioById(UUID id) {
        return colegioRepository.findById(id);
    }

    @Override
    public List<ColegioModel> getAllColegios() {
        return colegioRepository.findAll();
    }

    @Override
    public Boolean removeColegioById(UUID id) {
        return colegioRepository.findById(id).map(colegio -> {
            colegioRepository.deleteById(id);
            return true;
        }).orElse(false);   
    }

    @Override
    public ColegioModel updateColegioById(UUID id, ColegioModel colegio) {
        return colegioRepository.findById(id).map(existingColegio -> {
            existingColegio.setName(colegio.getName());
            existingColegio.setAddress(colegio.getAddress());
            existingColegio.setUpdatedAt(colegio.getUpdatedAt());
            return colegioRepository.save(existingColegio);
        }).orElse(null);
    }

}

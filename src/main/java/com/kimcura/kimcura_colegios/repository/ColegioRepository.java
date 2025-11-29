package com.kimcura.kimcura_colegios.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kimcura.kimcura_colegios.entity.ColegioEntity;

import jakarta.transaction.Transactional;

@Repository
public interface ColegioRepository extends JpaRepository<ColegioEntity, UUID> {

    @Modifying
    @Transactional
    @Query("SELECT c FROM ColegioEntity c WHERE c.id = ?1") 
    ColegioEntity getColegiopById(UUID id);

    @Modifying
    @Transactional
    @Query("DELETE FROM ColegioEntity c WHERE c.id = ?1") 
    void deleteColegiopById(UUID id);

}

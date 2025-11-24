package com.kimcura.kimcura_colegios.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.kimcura.kimcura_colegios.model.ColegioModel;

import jakarta.transaction.Transactional;

@Repository
public interface ColegioRepository extends JpaRepository<ColegioModel, UUID> {

    @Modifying
    @Transactional
    @Query("SELECT c FROM ColegioModel c WHERE c.id = ?1") 
    Optional<ColegioModel> getColegiopById(UUID id);

    @Modifying
    @Transactional
    @Query("DELETE FROM ColegioModel c WHERE c.id = ?1") 
    void deleteColegiopById(UUID id);

}

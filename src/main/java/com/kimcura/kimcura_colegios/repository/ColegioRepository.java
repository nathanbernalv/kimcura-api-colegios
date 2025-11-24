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
    @Query("SELECT u FROM ColegioModel u WHERE u.id = ?1") 
    Optional<ColegioModel> getColegopById(UUID id);


}

package com.POO.Sistema_De_Bar.repository;

import com.POO.Sistema_De_Bar.model.ComandaModel;
import com.POO.Sistema_De_Bar.model.StatusComanda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ComandaRepository extends JpaRepository<ComandaModel, UUID> {
    Optional<ComandaModel> findByMesaIdAndStatus(UUID mesaId, StatusComanda status);
}

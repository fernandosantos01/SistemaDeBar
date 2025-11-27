package com.POO.Sistema_De_Bar.repository;

import com.POO.Sistema_De_Bar.model.MesaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MesaRepository extends JpaRepository<MesaModel, UUID> {
    Optional<MesaModel> findByNumero(Integer numero);
}

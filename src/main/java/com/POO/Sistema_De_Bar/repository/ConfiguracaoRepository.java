package com.POO.Sistema_De_Bar.repository;

import com.POO.Sistema_De_Bar.model.ConfiguracaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfiguracaoRepository extends JpaRepository<ConfiguracaoModel, Long> {
}

package com.teste.pratico.repositories;

import com.teste.pratico.entities.Solicitante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitanteRepository extends JpaRepository<Solicitante, Long> {
}
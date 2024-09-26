package com.teste.pratico.repositories;

import com.teste.pratico.entities.Vagas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface VagasRepository extends JpaRepository<Vagas, Long> {

    @Query("SELECT SUM(v.quantidade) FROM Vagas v WHERE v.inicio >= :inicio AND v.fim <= :fim")
    Long countTotalVagasNoIntervalo(@Param("inicio") Date inicio, @Param("fim") Date fim);

}
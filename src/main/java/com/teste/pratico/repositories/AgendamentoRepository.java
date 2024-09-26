package com.teste.pratico.repositories;

import com.teste.pratico.entities.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    @Query("SELECT solc.id, COUNT(a.id) as totalAgendamentos " +
            "FROM Agendamento a " +
            "JOIN a.solicitante solc " + // use o atributo da entidade, não a coluna
            "WHERE a.data BETWEEN :inicio AND :fim " +
            "AND solc.id = :solicitanteId " +
            "GROUP BY solc.id") // agrupe pelos IDs do solicitante
    List<Object[]> findTotalAgendamentosSolicitante(@Param("inicio") Date inicio,
                                                    @Param("fim") Date fim,
                                                    @Param("solicitanteId") Long solicitanteId);
}

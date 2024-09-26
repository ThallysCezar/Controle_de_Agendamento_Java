package com.teste.pratico.services;

import com.teste.pratico.dtos.AgendamentoDTO;
import com.teste.pratico.dtos.TotalAgendamentosPorSolicDTO;
import com.teste.pratico.entities.Agendamento;
import com.teste.pratico.exceptions.agendamentos.AgendamentoException;
import com.teste.pratico.exceptions.vagas.VagasNotFoundException;
import com.teste.pratico.mappers.AgendamentoMapper;
import com.teste.pratico.repositories.AgendamentoRepository;
import com.teste.pratico.repositories.VagasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    private final VagasRepository vagasRepository;

    private final AgendamentoMapper agendamentoMapper;

    // Fazer para colocar os parametros corretos -> parametros:
    // Data de inicio, data do fim e data solicitante
    public List<AgendamentoDTO> findAll() {
        List<Agendamento> agendamentos = agendamentoRepository.findAll();
        if (agendamentos.isEmpty()) {
            throw new VagasNotFoundException("Nenhum agendamento encontrado");
        }
        return agendamentoMapper.toListDTO(agendamentos);
    }

    public AgendamentoDTO save(AgendamentoDTO dto) {
        try {
            if (dto.getData() == null || dto.getNumero() == null || dto.getMotivo() == null || dto.getSolicitanteId() == null) {
                throw new AgendamentoException("Data do agendamento, Número do agendamento, Motivação para o agendamento e pessoa que solicitou o agendamento.");
            }
            return agendamentoMapper.toDTO(agendamentoRepository.save(agendamentoMapper.toEntity(dto)));
        } catch (Exception exception) {
            throw new AgendamentoException("Erro ao salvar agendamento: " + exception.getMessage());
        }
    }

    public TotalAgendamentosPorSolicDTO getTotalAgendamentosPorSolicitante(Long solicitanteId, Date inicio, Date fim) {
        List<Object[]> results = agendamentoRepository.findTotalAgendamentosSolicitante(inicio, fim, solicitanteId);

        if (results.isEmpty()) {
            throw new VagasNotFoundException("Nenhum agendamento encontrado");
        }

        // Exemplo simples pegando o primeiro resultado
        Object[] result = results.get(0);
        Long totalAgendamentos = (Long) result[1];

        // Buscar o total de vagas a partir do solicitante ou outro critério em VagasRepository
        Long totalVagas = vagasRepository.countTotalVagasNoIntervalo(inicio, fim);

        if (totalVagas == null || totalVagas == 0) {
            throw new IllegalArgumentException("Nenhuma vaga disponível foi encontrada no período especificado");
        }

        // Calcular percentual do total agendado em relação à quantidade de vagas
        Long percentual = (totalAgendamentos * 100) / totalVagas;

        // Retornar o DTO com o total de agendamentos e percentual calculado
        return new TotalAgendamentosPorSolicDTO(
                solicitanteId,
                totalAgendamentos,
                percentual
        );
    }

}
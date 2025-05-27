package com.lucasballonecker.cadastro_jogadores.service;

import com.lucasballonecker.cadastro_jogadores.model.enums.GrupoCodinome;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CodinomeService {
    private final CodinomeRepositoryFactory codinomeRepositoryFactory;

    public String gerarCodinome(GrupoCodinome grupoCodinome, List<String> codinomesEmUso) throws Exception {
        List<String> codinomesDisponiveis = listarCodinomesDisponiveis(grupoCodinome, codinomesEmUso);
        if (codinomesDisponiveis.isEmpty()) {
            throw new Exception("Não há codinomes disponíveis para este grupo: " + grupoCodinome.getNome());
        }
        return sortearCodinome(codinomesDisponiveis);
    }

    private List<String> listarCodinomesDisponiveis(GrupoCodinome grupoCodinome, List<String> codinomesEmUso) {
        List<String> codinomes = buscarCodinomes(grupoCodinome);
        List<String> codinomesDisponiveis = codinomes
                .stream()
                .filter(codinome -> !codinomesEmUso.contains(codinome))
                .toList();

        return codinomesDisponiveis;
    }

    private List<String> buscarCodinomes(GrupoCodinome grupoCodinome) {
        var codinomeRepository = codinomeRepositoryFactory.create(grupoCodinome);
    }
}

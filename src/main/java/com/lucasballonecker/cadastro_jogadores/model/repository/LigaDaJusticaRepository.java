package com.lucasballonecker.cadastro_jogadores.model.repository;

import com.lucasballonecker.cadastro_jogadores.service.CodinomeRepository;

import java.util.List;

public class LigaDaJusticaRepository implements CodinomeRepository {
    @Override
    public List<String> buscarCodinomes() {
        return List.of();
    }
}

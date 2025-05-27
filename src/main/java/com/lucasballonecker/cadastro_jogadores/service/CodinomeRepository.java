package com.lucasballonecker.cadastro_jogadores.service;

import java.util.List;

public interface CodinomeRepository {
    List<String> buscarCodinomes() throws Exception;
}

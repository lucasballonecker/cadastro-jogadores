package com.lucasballonecker.cadastro_jogadores.service;

import com.lucasballonecker.cadastro_jogadores.web.CodinomeDTO;

import java.util.List;

public interface CodinomeRepository {
    CodinomeDTO buscarCodinomes() throws Exception;
}

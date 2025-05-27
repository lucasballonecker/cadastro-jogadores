package com.lucasballonecker.cadastro_jogadores.service;

import com.lucasballonecker.cadastro_jogadores.model.enums.GrupoCodinome;
import com.lucasballonecker.cadastro_jogadores.model.repository.LigaDaJusticaRepository;
import com.lucasballonecker.cadastro_jogadores.model.repository.VingadoresRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CodinomeRepositoryFactory {
    private final LigaDaJusticaRepository ligaDaJusticaRepository;
    private final VingadoresRepository vingadoresRepository;

    public CodinomeRepository create(GrupoCodinome grupoCodinome) {
        return switch (grupoCodinome) {
            case A_LIGA_DA_JUSTICA -> ligaDaJusticaRepository;
            case OS_VINGADORES -> vingadoresRepository;
        };
    }
}


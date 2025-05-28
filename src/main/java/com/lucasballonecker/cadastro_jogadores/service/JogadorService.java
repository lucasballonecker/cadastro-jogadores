package com.lucasballonecker.cadastro_jogadores.service;

import com.lucasballonecker.cadastro_jogadores.model.Jogador;
import com.lucasballonecker.cadastro_jogadores.model.enums.GrupoCodinome;
import com.lucasballonecker.cadastro_jogadores.model.repository.JogadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JogadorService {
    private final JogadorRepository jogadorRepository;
    private final CodinomeService codinomeService;

    public void registrarJogador(Jogador jogador) throws Exception {
        List<String> codinomesEmUso = listarCodinomesEmUsoPorGrupo(jogador.getGrupoCodinome());
        String novoCodinome = codinomeService.gerarCodinome(jogador.getGrupoCodinome(), codinomesEmUso);
        jogador.setCodinome(novoCodinome);
        jogadorRepository.salvar(jogador);
    }

    private List<String> listarCodinomesEmUsoPorGrupo(GrupoCodinome grupoCodinome) {
        return jogadorRepository.listarCodinomesEmUsoPorGrupo(grupoCodinome);
    }
}

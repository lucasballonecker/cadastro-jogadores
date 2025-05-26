package com.lucasballonecker.cadastro_jogadores.model.repository;

import com.lucasballonecker.cadastro_jogadores.model.Jogador;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JogadorRepository {
    private final JdbcClient jdbcClient;

    public void salvar(Jogador jogador) {
        jdbcClient.sql("""
                INSERT INTO JOGADORES (nome, email, telefone, codinome, grupo_codinome)
                VALUES (:nome, :email, :telefone, :codinome, :grupo_codinome)
                """)
                .param("nome", jogador.getNome())
                .param("email", jogador.getEmail())
                .param("telefone", jogador.getTelefone())
                .param("codinome", jogador.getCodinome())
                .param("grupo_codinome", jogador.getGrupoCodinome())
                .update();
    }
}

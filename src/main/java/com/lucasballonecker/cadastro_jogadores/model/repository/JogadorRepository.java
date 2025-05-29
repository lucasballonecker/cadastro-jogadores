package com.lucasballonecker.cadastro_jogadores.model.repository;

import com.lucasballonecker.cadastro_jogadores.model.Jogador;
import com.lucasballonecker.cadastro_jogadores.model.enums.GrupoCodinome;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

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
                .param("grupo_codinome", jogador.getGrupoCodinome().name())
                .update();
    }

    public List<String> listarCodinomesEmUsoPorGrupo(GrupoCodinome grupoCodinome) {
        return jdbcClient.sql("SELECT distinct(codinome) FROM JOGADORES WHERE grupo_codinome = :grupo_codinome")
                .param("grupo_codinome", grupoCodinome.name())
                .query(String.class)
                .list();
    }

    public List<Jogador> listarTodosOsJogadores() {
        return jdbcClient.sql("SELECT * FROM JOGADORES ORDER BY lower(nome), id")
                .query(Jogador.class)
                .list();
    }
}

package com.lucasballonecker.cadastro_jogadores.model;

import com.lucasballonecker.cadastro_jogadores.model.enums.GrupoCodinome;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Jogador {
    private String nome;
    private String email;
    private String telefone;
    private String codinome;
    private GrupoCodinome grupoCodinome;
}

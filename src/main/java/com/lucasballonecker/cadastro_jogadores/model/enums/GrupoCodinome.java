package com.lucasballonecker.cadastro_jogadores.model.enums;

import lombok.Getter;

@Getter
public enum GrupoCodinome {
    OS_VINGADORES("Vingadores",
            "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json"),
    A_LIGA_DA_JUSTICA("Liga da Justiça",
            "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml");

    GrupoCodinome(String nome, String url) {
        this.nome = nome;
        this.url = url;
    }

    private final String nome;
    private final String url;
}

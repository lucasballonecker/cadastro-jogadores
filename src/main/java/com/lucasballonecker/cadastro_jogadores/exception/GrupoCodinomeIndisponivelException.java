package com.lucasballonecker.cadastro_jogadores.exception;

public class GrupoCodinomeIndisponivelException extends IllegalArgumentException {
    public GrupoCodinomeIndisponivelException() {
        super("Não há codinomes disponíveis para este grupo.");
    }
}

package com.lucasballonecker.cadastro_jogadores.model.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucasballonecker.cadastro_jogadores.model.enums.GrupoCodinome;
import com.lucasballonecker.cadastro_jogadores.service.CodinomeRepository;
import com.lucasballonecker.cadastro_jogadores.web.VingadoresDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;

import java.util.List;

@Repository
public class VingadoresRepository implements CodinomeRepository {
    @Override
    public List<String> buscarCodinomes() throws Exception {
        String codinomes = RestClient
                .builder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN_VALUE)
                .baseUrl(GrupoCodinome.OS_VINGADORES.getUrl())
                .build()
                .get()
                .retrieve()
                .body(String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        VingadoresDTO vingadores = objectMapper.readValue(codinomes, VingadoresDTO.class);

        return vingadores.getCodinomes();


    }
}

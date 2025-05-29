package com.lucasballonecker.cadastro_jogadores.model.repository;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.lucasballonecker.cadastro_jogadores.model.enums.GrupoCodinome;
import com.lucasballonecker.cadastro_jogadores.service.CodinomeRepository;
import com.lucasballonecker.cadastro_jogadores.web.CodinomeDTO;
import com.lucasballonecker.cadastro_jogadores.web.LigaDaJusticaDTO;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;

import java.util.List;

@Repository
public class LigaDaJusticaRepository implements CodinomeRepository {
    @Override
    public CodinomeDTO buscarCodinomes() throws Exception {
        String codinomes = RestClient
                .builder()
                .baseUrl(GrupoCodinome.A_LIGA_DA_JUSTICA.getUrl())
                .build()
                .get()
                .retrieve()
                .body(String.class);

        XmlMapper xmlMapper = new XmlMapper();
        LigaDaJusticaDTO ligaDaJustica = xmlMapper.readValue(codinomes, LigaDaJusticaDTO.class);
        return ligaDaJustica;
    }
}

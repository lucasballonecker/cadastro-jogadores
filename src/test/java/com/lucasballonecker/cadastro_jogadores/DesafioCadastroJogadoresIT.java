package com.lucasballonecker.cadastro_jogadores;

import com.lucasballonecker.cadastro_jogadores.model.Jogador;
import com.lucasballonecker.cadastro_jogadores.model.enums.GrupoCodinome;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static java.lang.reflect.Array.get;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class DesafioCadastroJogadoresIT {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void cadastrarListarJogadorComSucesso() throws Exception {
        var jogador = new Jogador("teste", "test@test.com",
                "123456789", null, GrupoCodinome.OS_VINGADORES);

        mockMvc.perform(post("/cadastro-jogador")
                        .param("nome", jogador.getNome())
                        .param("email", jogador.getEmail())
                        .param("telefone", jogador.getTelefone())
                        .param("grupoCodinome", jogador.getGrupoCodinome().name()))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/listagem-jogadores"));

        mockMvc.perform(get("/listagem-jogadores"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("listagem-jogadores"))
                .andExpect(model().attribute("jogadores", hasSize(1)))
                .andExpect(model().attribute("jogadores", contains(allOf(
                        hasToString(containsString(jogador.getNome())),
                        hasToString(containsString(jogador.getEmail())),
                        hasToString(containsString(jogador.getTelefone())),
                        hasToString(containsString(jogador.getGrupoCodinome().getNome()))
                ))));
    }

}

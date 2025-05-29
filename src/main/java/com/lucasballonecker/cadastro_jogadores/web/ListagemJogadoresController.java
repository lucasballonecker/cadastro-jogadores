package com.lucasballonecker.cadastro_jogadores.web;

import com.lucasballonecker.cadastro_jogadores.service.JogadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/listagem-jogadores")
@RequiredArgsConstructor
public class ListagemJogadoresController {
    private final JogadorService jogadorService;

    @GetMapping
    public String listagemDeJogadores(Model model) {
        model.addAttribute("jogadores", jogadorService.listarTodosOsJogadores());
        return "listagem-jogadores";
    }
}

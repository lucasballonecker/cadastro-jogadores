package com.lucasballonecker.cadastro_jogadores.web;

import com.lucasballonecker.cadastro_jogadores.model.Jogador;
import com.lucasballonecker.cadastro_jogadores.model.enums.GrupoCodinome;
import com.lucasballonecker.cadastro_jogadores.service.JogadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cadastro-jogador")
@RequiredArgsConstructor
public class CadastroJogadorController {
    private final JogadorService jogadorService;

    @GetMapping
    public String paginaCadastroJogador(Model model) {
        model.addAttribute("grupoCodinome", GrupoCodinome.values());
        return "cadastro_jogador";
    }



    @PostMapping
    public String cadastrarJogador(@ModelAttribute Jogador jogador) {
        try {
            jogadorService.registrarJogador(jogador);
            return "redirect:/cadastro-jogador";
        } catch (Exception e) {
            return "redirect:/cadastro-jogador";
        }
    }

}

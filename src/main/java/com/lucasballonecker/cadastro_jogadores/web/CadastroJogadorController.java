package com.lucasballonecker.cadastro_jogadores.web;

import com.lucasballonecker.cadastro_jogadores.exception.GrupoCodinomeIndisponivelException;
import com.lucasballonecker.cadastro_jogadores.model.Jogador;
import com.lucasballonecker.cadastro_jogadores.model.enums.GrupoCodinome;
import com.lucasballonecker.cadastro_jogadores.service.JogadorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        return getViewAndModel(model, new Jogador());
    }

    @PostMapping
    public String cadastrarJogador(@ModelAttribute @Valid Jogador jogador, BindingResult result, Model model) throws Exception {
        if (result.hasErrors()) {
            return getViewAndModel(model, jogador);
        }
        try {
            jogadorService.registrarJogador(jogador);
            return "redirect:/listagem-jogadores";
        }catch (GrupoCodinomeIndisponivelException e){
            result.rejectValue("grupoCodinome","grupoCodinomeIndisponivel", e.getMessage());
            return getViewAndModel(model, jogador);
        }
    }

    private String getViewAndModel(Model model, Jogador jogador) {
        model.addAttribute("jogador", jogador);
        model.addAttribute("grupoCodinome", GrupoCodinome.values());
        return "cadastro_jogador";
    }


}

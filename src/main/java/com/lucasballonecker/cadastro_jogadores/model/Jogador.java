package com.lucasballonecker.cadastro_jogadores.model;

import com.lucasballonecker.cadastro_jogadores.model.enums.GrupoCodinome;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Validated
public class Jogador {
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    private String telefone;
    private String codinome;
    @NotNull
    private GrupoCodinome grupoCodinome;

    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", grupoCodinome='" + (grupoCodinome != null ? grupoCodinome.getNome() : "") + '\'' +
                '}';
    }
}

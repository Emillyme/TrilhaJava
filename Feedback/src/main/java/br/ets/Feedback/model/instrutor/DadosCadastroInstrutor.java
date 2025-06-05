package br.ets.Feedback.model.instrutor;

import br.ets.Feedback.model.informacoes.DadosInformacoes;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroInstrutor(@NotBlank String nome,
                                     @NotBlank @Email String email,
                                     @NotBlank @Pattern(regexp = "^\\d{8}") String edv,
                                     @NotNull Curso curso,
                                     @NotNull @Valid DadosInformacoes dadosInformacoes,
                                     @NotNull Boolean ferias){
}

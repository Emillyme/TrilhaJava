package br.ets.Feedback.model.aprendiz;

import br.ets.Feedback.model.informacoes.DadosInformacoes;
import br.ets.Feedback.model.instrutor.Curso;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroAprendiz(@NotBlank String nome,
                                     @NotBlank @Email String email,
                                     @NotBlank @Pattern(regexp = "^\\d{8}") String edv,
                                    @NotBlank String turma,
                                    @NotNull Curso curso
                                    ){
}

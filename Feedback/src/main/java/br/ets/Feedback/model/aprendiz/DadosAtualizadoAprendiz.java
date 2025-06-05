package br.ets.Feedback.model.aprendiz;

import br.ets.Feedback.model.informacoes.DadosInformacoes;
import br.ets.Feedback.model.instrutor.Curso;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizadoAprendiz(@NotNull int id,
                                       String nome,
                                       @Email String email,
                                       @Pattern(regexp = "^\\d{8}$") String edv,
                                        String turma,
                                        Curso curso){

}

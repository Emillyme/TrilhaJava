package br.ets.Feedback.model.aprendiz;

import br.ets.Feedback.model.instrutor.Curso;
import br.ets.Feedback.model.instrutor.DadosAtualizadoInstrutor;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tbaprendizes")

public class Aprendiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private String edv;
    private String turma;
    @Enumerated(EnumType.STRING)
    private Curso curso;

    public Aprendiz(DadosCadastroAprendiz dadosCadastroAprendiz){
        this.nome = dadosCadastroAprendiz.nome();
        this.edv = dadosCadastroAprendiz.edv();
        this.curso = dadosCadastroAprendiz.curso();
        this.email = dadosCadastroAprendiz.email();
        this.turma = dadosCadastroAprendiz.turma();
    }

    public void atualizar(DadosAtualizadoAprendiz dadosAtualizadoAprendiz){
        if(dadosAtualizadoAprendiz.nome() != null){
            this.nome = dadosAtualizadoAprendiz.nome();
        }
        if(dadosAtualizadoAprendiz.edv() != null){
            this.edv = dadosAtualizadoAprendiz.edv();
        }
        if(dadosAtualizadoAprendiz.turma() != null){
            this.turma = dadosAtualizadoAprendiz.turma();
        }
        if(dadosAtualizadoAprendiz.email() != null){
            this.email = dadosAtualizadoAprendiz.email();
        }
        if(dadosAtualizadoAprendiz.curso() != null){
            this.curso = dadosAtualizadoAprendiz.curso();
        }
    }

    public void excluir(){

    }
}

package br.ets.Feedback.model.instrutor;

import br.ets.Feedback.model.informacoes.Informacoes;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tbinstrutores")
public class Instrutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private String edv;
    @Enumerated(EnumType.STRING)
    private Curso curso;

    @Embedded
    private Informacoes informacoes;

    private Boolean ativo;

    private Boolean ferias;

    public Instrutor(DadosCadastroInstrutor dadosCadastroInstrutor){
        this.nome = dadosCadastroInstrutor.nome();
        this.email = dadosCadastroInstrutor.email();
        this.edv = dadosCadastroInstrutor.edv();
        this.curso = dadosCadastroInstrutor.curso();
        this.informacoes = new Informacoes(dadosCadastroInstrutor.dadosInformacoes());
        this.ferias = dadosCadastroInstrutor.ferias();
        this.ativo=true;
    }

    public void atualizar(DadosAtualizadoInstrutor dadosAtualizadoInstrutor){
        if(dadosAtualizadoInstrutor.nome() != null){
            this.nome = dadosAtualizadoInstrutor.nome();
        }
        if (dadosAtualizadoInstrutor.email() != null) {
            this.email = dadosAtualizadoInstrutor.email();
        }
        if (dadosAtualizadoInstrutor.edv() != null) {
            this.edv = dadosAtualizadoInstrutor.edv();
        }
        if (dadosAtualizadoInstrutor.curso() != null) {
            this.curso = dadosAtualizadoInstrutor.curso();
        }
        if (dadosAtualizadoInstrutor.ferias() != null) {
            this.ferias = dadosAtualizadoInstrutor.ferias();
        }
        if (dadosAtualizadoInstrutor.informacoes() != null){
            this.informacoes.atualizar(dadosAtualizadoInstrutor.informacoes());
        }
    }
    public void excluir(){
        this.ativo = false;
    }
}

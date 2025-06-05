package br.ets.Feedback.model.instrutor;

import br.ets.Feedback.model.informacoes.Informacoes;

public record DadosInformacoesCompletasDoInstrutor(
        int id,
        String nome,
        String email,
        String edv,
        Curso curso,
        Boolean ferias,
        Boolean ativo,
        Informacoes informacoes) {

    public DadosInformacoesCompletasDoInstrutor(Instrutor instrutor){
            this(instrutor.getId(),
                instrutor.getNome(),
                instrutor.getEmail(),
                instrutor.getEdv(),
                instrutor.getCurso(),
                instrutor.getFerias(),
                instrutor.getAtivo(),
                instrutor.getInformacoes());
    }

}

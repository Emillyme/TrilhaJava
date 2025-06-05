package br.ets.Feedback.model.aprendiz;

import br.ets.Feedback.model.instrutor.Curso;

public record DadosListagemAprendiz(String nome,
                                    String email,
                                    String edv,
                                    String turma,
                                    Curso curso) {
    public DadosListagemAprendiz(Aprendiz aprendiz){
        this(aprendiz.getNome(),
            aprendiz.getEmail(),
            aprendiz.getEdv(),
            aprendiz.getTurma(),
            aprendiz.getCurso());
    }
}

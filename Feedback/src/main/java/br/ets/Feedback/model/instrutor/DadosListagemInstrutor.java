package br.ets.Feedback.model.instrutor;

public record DadosListagemInstrutor(String nome,
                                     String email,
                                     String edv,
                                     Boolean ferias,
                                     Curso curso) {
    public DadosListagemInstrutor(Instrutor instrutor){
        this(instrutor.getNome(),
                instrutor.getEmail(),
                instrutor.getEdv(),
                instrutor.getFerias(),
                instrutor.getCurso());
    }
}

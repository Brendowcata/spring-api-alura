package br.com.w0dn3r.javaspring.controller.form;

public class TopicoForm {

    private String titulo;
    private String mensagem;
    private String nomeCurso;

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }
}

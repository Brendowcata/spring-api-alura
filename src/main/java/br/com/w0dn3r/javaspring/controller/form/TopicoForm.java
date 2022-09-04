package br.com.w0dn3r.javaspring.controller.form;

import br.com.w0dn3r.javaspring.modelo.Curso;
import br.com.w0dn3r.javaspring.modelo.Topico;
import br.com.w0dn3r.javaspring.repositories.CursoRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TopicoForm {

    @NotNull
    @NotEmpty
    private String titulo;
    @NotNull
    @NotEmpty
    private String mensagem;
    @NotNull
    @NotEmpty
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

    public Topico converter(CursoRepository repository) {
        Curso curso = repository.pesquisandoCurso(nomeCurso);
        return new Topico(titulo, mensagem, curso);
    }
}

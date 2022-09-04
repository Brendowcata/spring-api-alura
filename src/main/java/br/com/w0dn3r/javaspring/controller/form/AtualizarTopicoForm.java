package br.com.w0dn3r.javaspring.controller.form;

import br.com.w0dn3r.javaspring.modelo.Topico;
import br.com.w0dn3r.javaspring.repositories.TopicoRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizarTopicoForm {

    @NotNull
    @NotEmpty
    private String titulo;
    @NotNull
    @NotEmpty
    private String mensagem;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Topico atulizar(Long id, TopicoRepository topicoRepository) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.setTitulo(this.titulo);
        topico.setMensagem(this.mensagem);

        return topico;
    }
}

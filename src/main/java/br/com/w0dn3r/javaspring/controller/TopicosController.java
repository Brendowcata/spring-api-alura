package br.com.w0dn3r.javaspring.controller;

import br.com.w0dn3r.javaspring.controller.form.TopicoForm;
import br.com.w0dn3r.javaspring.dto.TopicoDTO;
import br.com.w0dn3r.javaspring.modelo.Topico;
import br.com.w0dn3r.javaspring.repositories.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @GetMapping
    public List<TopicoDTO> lista(String nomeCurso){
        if(nomeCurso == null){
            List<Topico> topicos = topicoRepository.findAll();
            return TopicoDTO.converter(topicos);
        }
        List<Topico> topicos = topicoRepository.pesquisandoCurso(nomeCurso);
        return TopicoDTO.converter(topicos);
    }
    @PostMapping
    public void cadastrar(TopicoForm topicoForm){

    }
}

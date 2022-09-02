package br.com.w0dn3r.javaspring.controller;

import br.com.w0dn3r.javaspring.dto.TopicoDTO;
import br.com.w0dn3r.javaspring.modelo.Curso;
import br.com.w0dn3r.javaspring.modelo.Topico;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicosController {

    @RequestMapping("/topicos")
    public List<TopicoDTO> lista(){
        Topico topic = new Topico("Teste", "Teste", new Curso("Curso 1", "Programming"));

        return TopicoDTO.converter(Arrays.asList(topic, topic, topic));
    }
}

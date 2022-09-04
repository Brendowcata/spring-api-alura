package br.com.w0dn3r.javaspring.controller;

import br.com.w0dn3r.javaspring.controller.form.AtualizarTopicoForm;
import br.com.w0dn3r.javaspring.controller.form.TopicoForm;
import br.com.w0dn3r.javaspring.dto.DetalhesDoTopicoDTO;
import br.com.w0dn3r.javaspring.dto.TopicoDTO;
import br.com.w0dn3r.javaspring.modelo.Topico;
import br.com.w0dn3r.javaspring.repositories.CursoRepository;
import br.com.w0dn3r.javaspring.repositories.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private CursoRepository cursoRepository;

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
    @Transactional
    public ResponseEntity<TopicoDTO> cadastrar(@RequestBody @Valid TopicoForm topicoForm, UriComponentsBuilder uriComponentsBuilder){
        Topico topico = topicoForm.converter(cursoRepository);
        topicoRepository.save(topico);

        URI uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDTO(topico));
    }
   @GetMapping("/{id}")
    public ResponseEntity<DetalhesDoTopicoDTO> detalhar(@PathVariable Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        if (topico.isPresent()){
            return ResponseEntity.ok(new DetalhesDoTopicoDTO(topico.get()));
        }

       return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarTopicoForm form) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (optionalTopico.isPresent()){
            Topico topico = form.atulizar(id, topicoRepository);
            return ResponseEntity.ok(new TopicoDTO(topico));
        }

        return ResponseEntity.notFound().build();



    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity remover(@PathVariable Long id) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (optionalTopico.isPresent()){
            topicoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}

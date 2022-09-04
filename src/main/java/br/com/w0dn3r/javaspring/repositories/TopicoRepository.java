package br.com.w0dn3r.javaspring.repositories;

import br.com.w0dn3r.javaspring.modelo.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    @Query(" SELECT t FROM Topico as t " +
            " INNER JOIN Curso as c " +
            " ON c.id = t.curso " +
            " WHERE c.nome LIKE %:nomeCurso%")
    Page<Topico> pesquisandoCurso(@Param("nomeCurso") String nomeCurso, Pageable paginacao);
}

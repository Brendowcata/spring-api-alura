package br.com.w0dn3r.javaspring.repositories;

import br.com.w0dn3r.javaspring.modelo.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    @Query("SELECT t FROM Topico as t\n" +
            "INNER JOIN Curso as c\n" +
            "ON c.id = t.curso\n" +
            "WHERE c.nome LIKE %:nomeCurso%")
    List<Topico> pesquisandoCurso(@Param("nomeCurso") String nomeCurso);
}

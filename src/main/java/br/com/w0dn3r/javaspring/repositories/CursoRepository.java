package br.com.w0dn3r.javaspring.repositories;

import br.com.w0dn3r.javaspring.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Query("SELECT c FROM Curso as c\n" +
            "WHERE c.nome LIKE %:nomeCurso%")
    Curso pesquisandoCurso(@Param("nomeCurso") String nomeCurso);

}

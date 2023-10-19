package br.com.spolador.forum.repository;

import br.com.spolador.forum.modelo.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    //JPA executa toda a logica de pesquisa seguindo o seu padrão de nomenclatura de metodos
    List<Topico> findByCurso_Nome(String nomeCurso); // Curso (entidade) -> nome é o atributo dentro dessa entidade /
    // o _ impede ambiguidade. Por exemplo, caso em Topico tenha um atributo cursoNome


    //abaixo, segue um metodo com o msm objetivo acima, porém, sem o padrão de nomenclatura
    //nesse caso, é necessário construir toda a query jpql para informar a JPA o que esse método deve executar no db
    @Query("SELECT t FROM Topico t WHERE t.curso.nome = :nomeCurso")
    List<Topico> carregarPorNomeDoCurso(@Param("nomeCurso") String nomeCurso);
}

package br.com.spolador.forum.controller.form;

import br.com.spolador.forum.modelo.Curso;
import br.com.spolador.forum.modelo.Topico;
import br.com.spolador.forum.repository.CursoRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


//classe auxiliar para o metodo cadastrar (topico). Abaixo, segue os atributos necessários para o cadastro (post) de um topico
public class TopicoForm {

    @NotNull @NotEmpty @Length(min = 3)
    private String titulo;

    @NotNull @NotEmpty @Length(min = 5)
    private String mensagem;

    @NotNull @NotEmpty
    private String nomeCurso;

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    //recebe um repository da classe/entidade Curso e converte um form para um topico
    public Topico converter(CursoRepository cursoRepository) {
        Curso curso = cursoRepository.findByNome(nomeCurso);
        return new Topico(titulo, mensagem, curso);
    }
}

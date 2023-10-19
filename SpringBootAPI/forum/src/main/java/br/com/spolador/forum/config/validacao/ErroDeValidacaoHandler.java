package br.com.spolador.forum.config.validacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErroDeValidacaoHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST) // apesar do erro, sera devolvido um codigo de erro 400
    @ExceptionHandler(MethodArgumentNotValidException.class) // qualquer endpoint que tiver essa exceção, o metodo handle() sera executado
    public List<ErrorDeFormularioDto> handle(MethodArgumentNotValidException exception){ // devolve uma lista com cada um dos erros
        List<ErrorDeFormularioDto> dto = new ArrayList<>();

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErrorDeFormularioDto erro = new ErrorDeFormularioDto(e.getField(), mensagem);
            dto.add(erro);
        });
        return dto;
    }
}

package br.com.spolador.forum.config.validacao;

public class ErrorDeFormularioDto {
    private String campo;
    private String mensagem;

    public ErrorDeFormularioDto(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }
}

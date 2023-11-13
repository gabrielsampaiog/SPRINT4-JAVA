package br.com.bikeinsure.exception;

/**
 * Exceção lançada quando informações inválidas são encontradas.
 * Pode ser utilizada para indicar problemas nos dados fornecidos pelo usuário.
 */
public class BadInfoException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Construtor padrão que aceita uma mensagem de erro.
     *
     * @param message Mensagem de erro explicativa.
     */
    public BadInfoException(String message) {
        super(message);
    }

    /**
     * Construtor que aceita uma mensagem de erro e uma causa específica.
     *
     * @param message Mensagem de erro explicativa.
     * @param cause   Causa específica da exceção.
     */
    public BadInfoException(String message, Throwable cause) {
        super(message, cause);
    }
}

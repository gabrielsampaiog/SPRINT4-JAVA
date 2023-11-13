package br.com.bikeinsure.exception;

/**
 * Exceção lançada quando um identificador específico não é encontrado.
 * Pode ser utilizada para indicar que uma entidade esperada não existe no sistema.
 */
public class IdNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Construtor padrão que aceita uma mensagem de erro.
     *
     * @param message Mensagem de erro explicativa.
     */
    public IdNotFoundException(String message) {
        super(message);
    }

    /**
     * Construtor que aceita uma mensagem de erro e uma causa específica.
     *
     * @param message Mensagem de erro explicativa.
     * @param cause   Causa específica da exceção.
     */
    public IdNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

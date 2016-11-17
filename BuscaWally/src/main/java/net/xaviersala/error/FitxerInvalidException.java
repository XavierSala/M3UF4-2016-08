package net.xaviersala.error;

/**
 * Excepció generada quan es passa un fitxer que no compleix
 * amb les especificacions: Hi ha més d'un Wally en el fitxer
 *
 * @author xavier
 *
 */
public class FitxerInvalidException extends Exception {

    /**
     * ID
     */
    private static final long serialVersionUID = -2648049950795102483L;

    public FitxerInvalidException(String missatge) {
        super(missatge);
    }
}

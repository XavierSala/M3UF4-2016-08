package net.xaviersala.busca;

/**
 * Classe per emmagatzemar els resultats obtinguts.
 * @author xavier
 *
 */
public class Resultat {

    private int fila;
    private int columna;

    /**
     * Emmagatzema el resultat.
     *
     * @param fila fila en la que hi ha el resultat
     * @param columna columna on hi ha el resultat
     */
    public Resultat(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    /**
     * Conversió a text del resultat.
     */
    @Override
    public String toString() {
        return "fila " + fila + ", columna " + columna;
    }
}

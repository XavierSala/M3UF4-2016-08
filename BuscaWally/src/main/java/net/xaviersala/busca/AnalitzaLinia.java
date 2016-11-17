package net.xaviersala.busca;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalitzaLinia {

    String busco;
    Pattern pattern;

    /**
     * Cerca la paraula especificada en una línia.
     *
     * @param busco
     *            paraula a cercar
     */
    public AnalitzaLinia(String busco) {
        this.busco = busco;
        pattern = Pattern.compile("(([\\s|\\\\.|\\\\,]" + busco + ")|^" + busco + ")([\\s|\\\\.|\\\\,]|$)");
    }

    /**
     * Busca en Wally a la línia que s'hi especifica.
     *
     * @param linia
     *            Línia a analitzar
     * @return En quina columna hi ha en Wally o -1 si no hi és
     */
    public int busca(String linia) {

        Matcher matcher = pattern.matcher(linia);
        if (matcher.find()) {
            return linia.indexOf(busco, matcher.start());
        }

        //
        // (linia.matches(".*(([\\s|\\\\.|\\\\,]Wally)|Wally)[\\s|\\\\.|\\\\,].*"))
        //

        return -1;
    }

}

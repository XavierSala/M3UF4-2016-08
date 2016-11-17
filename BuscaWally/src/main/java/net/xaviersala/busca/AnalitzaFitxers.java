package net.xaviersala.busca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.xaviersala.error.FitxerInvalidException;

/**
 * Analitza un fitxer per trobar-hi en Wally ...
 *
 * Delega la feina en el fitxer d'anàlisi de línies.
 *
 * @author xavier
 *
 */
public class AnalitzaFitxers {


    String queBusco;
    AnalitzaLinia analitzaLinia;

    /**
     * Determina quina és la cadena a cercar.
     * @param queBusco Cadena a cercar
     */
    public AnalitzaFitxers(AnalitzaLinia analitzaLinia) {
        this.analitzaLinia = analitzaLinia;
    }

    /**
     * Analitza el fitxer per trobar-hi la cadena que es demana.
     * @param fitxer Fitxer a analitzar
     * @throws FitxerInvalidException Missatges d'error
     */
    public String processaFitxer(String fitxer) throws FitxerInvalidException {
        String linea;
        int columna = -1;

        List<Resultat> resultats = new ArrayList<>();



        try (BufferedReader br = new BufferedReader(new FileReader(fitxer))) {
            int numLinia = 0;
            while ((linea = br.readLine()) != null) {
                if ((columna = analitzaLinia.busca(linea)) != -1) {
                    resultats.add(new Resultat(numLinia, columna));
                }
                numLinia++;
            }
        } catch (IOException e) {
            throw new FitxerInvalidException("FITXER NO TROBAT");
        }

        if (resultats.isEmpty()) {
            return "No hi és";
        }
        if (resultats.size() > 1) {
            throw new FitxerInvalidException("FITXER INCORRECTE");
        }
        return " " + resultats.get(0);
    }



}

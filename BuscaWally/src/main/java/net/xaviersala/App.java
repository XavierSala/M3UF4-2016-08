package net.xaviersala;

import java.io.File;
import java.io.FilenameFilter;
import net.xaviersala.busca.AnalitzaFitxers;
import net.xaviersala.busca.AnalitzaLinia;
import net.xaviersala.error.FitxerInvalidException;

/**
 * Programa que busca en Wally en els fitxers.
 *
 */
public class App {

    public static void main(String[] args) {

        final String nom = "Wally";

        final String[] fitxerNoExistent = { "noexistent.txt" };
        String[] fitxersDelDirectori = buscaElsFitxersDelDirectori();

        System.out.println("------- Cercant en " + nom + " ------- ");
        AnalitzaFitxers analitzaFitxer = new AnalitzaFitxers(new AnalitzaLinia(nom));

        analitzaElsFitxers(analitzaFitxer, fitxersDelDirectori);
        analitzaElsFitxers(analitzaFitxer, fitxerNoExistent);
    }

    /**
     * Localitza els fitxers *.txt del directori.
     *
     * @return Llista de fitxers del directori
     */
    private static String[] buscaElsFitxersDelDirectori() {
        return new File(".").list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        });
    }

    /**
     * Analitza la llista dels fitxers per veure si hi troba en Wally.
     *
     * @param analitzaFitxer
     * @param fitxers Llista de fitxers
     */
    private static void analitzaElsFitxers(AnalitzaFitxers analitzaFitxer, String[] fitxers) {
        for (String fitxer : fitxers) {
            System.out.print("Fitxer: " + fitxer);
            try {
                System.out.println(" --> " + analitzaFitxer.processaFitxer(fitxer));
            } catch (FitxerInvalidException e) {
                System.out.println(" --> " + e.getMessage());
            }
        }
    }
}

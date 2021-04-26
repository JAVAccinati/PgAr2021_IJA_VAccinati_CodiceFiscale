package it.unibs.pgar.codicefiscale;

import java.util.ArrayList;

public class ClasseMain {

    public static void main(String[] args) {

        ArrayList<Comune> comuni = LetturaComuni.esecuzioneLetturaComuni();
        ArrayList<Persona> persone = LetturaInputPersone.esecuzioneLetturaPersone(comuni);
        generazioneCodiciFiscali(persone);
        ArrayList<String> codiciFiscali = LetturaCodiciFiscali.esecuzioneLetturaCodiciFiscali();
        ScritturaCodiciPersone.esecuzioneScritturaCodiciPersone(persone, codiciFiscali, comuni);
    }

    public static void generazioneCodiciFiscali(ArrayList<Persona> persone) {
        for(int i = 0; i < persone.size(); i++) {
            persone.get(i).generaCodiceFiscale();
        }
    }

}

/*

verifica codici fiscali
confronto codici fiscali validi
conseguentemente salva quei codici
scrivi file Persone
scrivi file Codici

inserisci controlli inputPersone e codiciFiscali
javadoc e commenti

 */

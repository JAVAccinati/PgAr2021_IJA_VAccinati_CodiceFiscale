package it.unibs.pgar.codicefiscale;

import java.util.ArrayList;

public class ClasseMain {

    public static void main(String[] args) {

        ArrayList<Comune> comuni = LetturaComuni.esecuzioneLetturaComuni();
        ArrayList<Persona> persone = LetturaInputPersone.esecuzioneLetturaPersone(comuni);

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
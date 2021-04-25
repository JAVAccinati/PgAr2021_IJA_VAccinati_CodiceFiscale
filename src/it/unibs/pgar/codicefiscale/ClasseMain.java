package it.unibs.pgar.codicefiscale;

import java.util.ArrayList;

public class ClasseMain {

    public static void main(String[] args) {

        ArrayList<Comune> comuni = LetturaComuni.esecuzioneLetturaComuni();
        ArrayList<Persona> persone = LetturaInputPersone.esecuzioneLetturaPersone(comuni);

        Data data = new Data(2001, 05, 12);
        Comune comune = new Comune("BRESCIA", "B157");
        Persona persona = new Persona("SAMUELE", "PASINI", Sesso.M, comune, data);
        System.out.println(persona.generaCodiceFiscale());

        Data data2 = new Data(2001, 12, 07);
        Comune comune2 = new Comune("PALERMO", "G273");
        Persona persona2 = new Persona("ALESSIO", "RUSSO", Sesso.M, comune2, data2);
        System.out.println(persona2.generaCodiceFiscale());

    }

}

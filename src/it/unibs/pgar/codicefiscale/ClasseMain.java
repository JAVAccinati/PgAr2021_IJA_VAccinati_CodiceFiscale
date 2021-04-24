package it.unibs.pgar.codicefiscale;

public class ClasseMain {

    public static void main(String[] args) {

        Data data = new Data(12, 05, 01);
        Comune comune = new Comune("bh", "iffiu");

        Persona persona = new Persona("LU", "MEA", Sesso.M, comune, data);
        System.out.println(persona.generaCodiceFiscale());

    }

}

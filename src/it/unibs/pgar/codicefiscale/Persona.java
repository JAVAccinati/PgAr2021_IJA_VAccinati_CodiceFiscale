package it.unibs.pgar.codicefiscale;

public class Persona {

    private String nome;
    private String cognome;
    private Sesso sesso;
    private Comune comune;
    private Data dataDiNascita;

    public static final char[] VOCALI = "AEIOU".toCharArray();
    public static final char[] CONSONANTI = "BCDFGHJKLMNPQRSTVWXYZ".toCharArray();

    public Persona(String nome, String cognome, Sesso sesso, Comune comune, Data dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.sesso = sesso;
        this.comune = comune;
        this.dataDiNascita = dataDiNascita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }

    public Comune getComune() {
        return comune;
    }

    public void setComune(Comune comune) {
        this.comune = comune;
    }

    public Data getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Data dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String generaCodiceFiscale() {
        String cf = "";
        int nConsonanti = 0;

        //generazione lettere COGNOME

        char[] cognomeArray = cognome.toCharArray();

        for (int i = 0; i < cognomeArray.length; i++)
            for (int j = 0; j < CONSONANTI.length; j++)
                if (cognomeArray[i] == CONSONANTI[j])
                    nConsonanti++;

        if (nConsonanti < 3) {
            for (int i = 0; i < cognomeArray.length; i++)
                for (int j = 0; j < CONSONANTI.length; j++)
                    if (cognomeArray[i] == CONSONANTI[j])
                        cf += cognomeArray[i];

            for (int i = 0; i < cognomeArray.length; i++)
                for (int j = 0; j < VOCALI.length && cf.length() < 3; j++)
                    if (cognomeArray[i] == VOCALI[j])
                        cf += cognomeArray[i];

            while (cf.length() < 3)
                cf += "X";

        } else {
            for (int i = 0; i < cognomeArray.length; i++)
                for (int j = 0; j < CONSONANTI.length && cf.length() < 3; j++)
                    if (cognomeArray[i] == CONSONANTI[j])
                        cf += cognomeArray[i];
        }
        //generazione lettere NOME

        char[] nomeArray = nome.toCharArray();
        nConsonanti = 0;

        for (int i = 0; i < nomeArray.length; i++)
            for (int j = 0; j < CONSONANTI.length; j++)
                if (nomeArray[i] == CONSONANTI[j])
                    nConsonanti++;

        if (nConsonanti < 3) {
            for (int i = 0; i < nomeArray.length; i++)
                for (int j = 0; j < CONSONANTI.length; j++)
                    if (nomeArray[i] == CONSONANTI[j])
                        cf += nomeArray[i];

            for (int i = 0; i < nomeArray.length; i++)
                for (int j = 0; j < VOCALI.length && cf.length() < 6; j++)
                    if (nomeArray[i] == VOCALI[j])
                        cf += nomeArray[i];

            while (cf.length() < 6)
                cf += "X";
        } else if (nConsonanti == 3) {
            for (int i = 0; i < nomeArray.length; i++)
                for (int j = 0; j < CONSONANTI.length && cf.length() < 6; j++)
                    if (nomeArray[i] == CONSONANTI[j])
                        cf += nomeArray[i];
        } else {
            //usiamo temp per saltare la seconda consonante del nome
            String temp = "";
            for (int i = 0; i < nomeArray.length; i++)
                for (int j = 0; j < CONSONANTI.length && temp.length() < 4; j++)
                    if (nomeArray[i] == CONSONANTI[j])
                        temp += nomeArray[i];
            char[] tempArray = temp.toCharArray();
            cf += tempArray[0];
            cf += tempArray[2];
            cf += tempArray[3];
        }

        return cf;
    }

}

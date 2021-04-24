package it.unibs.pgar.codicefiscale;

public class Persona {

    private String nome;
    private String cognome;
    private Sesso sesso;
    private Comune comune;
    private Data dataDiNascita;

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

}

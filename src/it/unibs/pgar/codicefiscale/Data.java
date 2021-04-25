package it.unibs.pgar.codicefiscale;

public class Data {

    private int anno;
    private int mese;
    private int giorno;

    public Data(int anno, int mese, int giorno) {
        this.anno = anno;
        this.mese = mese;
        this.giorno = giorno;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getMese() {
        return mese;
    }

    public void setMese(int mese) {
        this.mese = mese;
    }

    public int getGiorno() {
        return giorno;
    }

    public void setGiorno(int giorno) {
        this.giorno = giorno;
    }

    public char[] creaArray(int numero) {
        Integer temp = numero;
        return temp.toString().toCharArray();
    }

    public static Data generaData(String dataData /*XD lol lmao rofl uwu*/) {
        char[] dataDataArray = dataData.toCharArray();

        int annoData = 0;
        int meseData = 0;
        int giornoData = 0;

        for(int i = 0; dataDataArray[i] != '-'; i ++) {
            annoData *= 10;
            annoData += dataDataArray[i] - '0';
        }

        for(int i = 5; dataDataArray[i] != '-'; i ++) {
            meseData *= 10;
            meseData += dataDataArray[i] - '0';
        }

        for(int i = 8; i < dataDataArray.length; i ++) {
            giornoData *= 10;
            giornoData += dataDataArray[i] - '0';
        }

        Data data = new Data(annoData, meseData, giornoData);

        return data;
    }

}

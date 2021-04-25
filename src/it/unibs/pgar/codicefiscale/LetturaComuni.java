package it.unibs.pgar.codicefiscale;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class LetturaComuni {

    public static ArrayList<Comune> esecuzioneLetturaComuni() {
        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;

        ArrayList<Comune> comuni = new ArrayList<Comune>();

        try {
            String path = new File("src/comuni.xml").getPath();
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader(path, new FileInputStream(path));

            int i = 0;

            String variabileDaAggiornare = "";

            String nome = "";
            String codice = "";

            while (xmlr.hasNext()) { // continua a leggere finché ha eventi a disposizione
                switch (xmlr.getEventType()) { // switch sul tipo di evento
                    //non utilizzato
                    case XMLStreamConstants.START_DOCUMENT: // inizio del documento: stampa che inizia il documento
                        /*System.out.println("Start Read Doc " + path);*/
                        break;

                    case XMLStreamConstants.START_ELEMENT: // inizio di un elemento: stampa il nome del tag e i suoi attributi
                        variabileDaAggiornare = xmlr.getLocalName();

                        /*System.out.println("Tag " + xmlr.getLocalName());
                        for (int i = 0; i < xmlr.getAttributeCount(); i++)
                            System.out.printf(" => attributo %s->%s%n", xmlr.getAttributeLocalName(i), xmlr.getAttributeValue(i));*/
                        break;

                    //non utilizzato
                    case XMLStreamConstants.END_ELEMENT: // fine di un elemento: stampa il nome del tag chiuso
                        //System.out.println("END-Tag " + xmlr.getLocalName());
                        break;

                    //non utilizzato
                    case XMLStreamConstants.COMMENT:
                        System.out.println("// commento " + xmlr.getText());
                        break; // commento: ne stampa il contenuto

                    case XMLStreamConstants.CHARACTERS: // content all’interno di un elemento: stampa il testo
                        if (xmlr.getText().trim().length() > 0) { // controlla se il testo non contiene solo spazi
                            if (variabileDaAggiornare.equals("nome"))
                                nome = xmlr.getText();
                            else if (variabileDaAggiornare.equals("codice"))
                                codice = xmlr.getText();
                        }
                        break;
                }

                if(!nome.equals("") && !codice.equals("")) {
                    comuni.add(i, new Comune(nome, codice));
                    nome = "";
                    codice = "";
                    i ++;
                }

                xmlr.next();
            }

        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader:");
            System.out.println(e.getMessage());
        }

        return comuni;

    }

}

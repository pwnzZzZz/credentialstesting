package at.itkolleg.credentials;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.List;


/**
 * Hier werden die Zusatzfunktionen für
 * den Decorator eingebaut
 */
public class DecoratorHash extends Decorator{


    /**
     * Übergibt der Mutterklasse Decorator den
     * benötigten CsvExporter
     * @param csvExporter Exporter-Objekt das zu verschönern ist
     */
    public DecoratorHash(CsvExporter csvExporter) {
        super(csvExporter);
    }


    /**
     * Beim export wird die CredentialsList an
     * die Mutterklasse übergeben
     * @param credentialsList Login Liste
     */
    @Override
    public void export(List<Credentials> credentialsList) {
        String tempPWD = "";

        for(Credentials c : credentialsList){
            c.setPwd(Hashing.sha256()
                    .hashString(c.getPwd(), StandardCharsets.UTF_8)
                    .toString());
        }

        super.export(credentialsList);
    }
}

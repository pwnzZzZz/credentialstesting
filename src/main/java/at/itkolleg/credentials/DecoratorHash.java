package at.itkolleg.credentials;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.List;


/**
 * Hier wird ein konkreter Decorator zum
 * hashen von Passwörtern erstellt
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
     * Beim export wird die CredentialsList durchlaufen
     * und bei jedem Benutzer wird das Passwort gehasht
     * @param credentialsList veränderte CredentialsList
     */
    @Override
    public void export(List<Credentials> credentialsList) {
        for(Credentials c : credentialsList){
            c.setPwd(Hashing.sha256()
                    .hashString(c.getPwd(), StandardCharsets.UTF_8)
                    .toString());
        }
        super.export(credentialsList);
    }
}

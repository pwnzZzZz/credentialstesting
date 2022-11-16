package at.itkolleg.credentials;

import java.util.List;



public class DecoratorHash extends Decorator{


    public DecoratorHash(CsvExporter csvExporter) {
        super(csvExporter);
    }

    @Override
    public void export(List<Credentials> credentialsList) {
        super.export(credentialsList);
    }
}

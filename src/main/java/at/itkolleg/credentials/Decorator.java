package at.itkolleg.credentials;

import java.util.List;

/**
 * Der Decorator "erweitert" eine Klasse um zusätzliche Funktionalitäten.
 * Die Decoratorklasse hält eine Referenz zum CSV-Exporter.
 */
public abstract class Decorator implements ExportCredentials {
    private CsvExporter csvExporter;

    /**
     * Ein neuer Exporter wird erstellt
     * und beim Erstellen zugewiesen
     * @param csvExporter Exporter Objekt
     */
    public Decorator(CsvExporter csvExporter) {
        this.csvExporter = csvExporter;
    }

    /**
     * Die Liste wird mit dem csvExporter exportiert
     * @param credentialsList Login Liste
     */
    public void export(List<Credentials> credentialsList){
        csvExporter.export(credentialsList);
}


}
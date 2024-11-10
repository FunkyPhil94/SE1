package org.hbrs.se1.ws24.exercises.uebung3;

import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceStrategyStream;

public class Main {

    public static void main(String[] args) {
        // Referenz auf das Container-Objekt holen
        Container container = Container.getInstance();

        // Strategie für Stream-Strategy erzeugen und in den Container einsetzen
        container.setPersistenceStrategie( new PersistenceStrategyStream() );

        // Client zur Ein- und Ausgabe starten
        Client client = new Client();
        client.startClient();
    }
}

package org.hbrs.se1.ws24.exercises.uebung4.prototype;

import org.hbrs.se1.ws24.exercises.uebung3.ContainerException;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceStrategyStream;

import java.util.Scanner;

public class Client {

    private static final Container <UserStory> container = Container.getInstance();
    private static final PersistenceStrategyStream<UserStory> persistenceStrategy = new PersistenceStrategyStream<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final String FILE_PATH = "src/org/hbrs/se1/ws24/exercises/uebung4/UserStories.ser";

    private static void printHelp() {
        System.out.println("Verfügbare Befehle:");
        System.out.println("enter - neue User Story");
        System.out.println("store - Speichert die User Stories");
        System.out.println("load - Lädt User Stories aus einer Datei");
        System.out.println("dump - nach Priorität sortierte Ausgabe der User Stories");
        System.out.println("dump <filter> <wert> - Ausgabe der User Stories, gefiltert nach einem bestimmten Kriterium");
        System.out.println("exit - Verlassen");
        System.out.println("help - zeigt mögliche Befehle");
    }

    private static Integer readInteger (String eingabe) {
        while (true) {
            try {
                System.out.println(eingabe + ": ");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ungültiges Format bei der Eingabe");
            }
        }
    }

    private static String readString (String eingabe) {
        System.out.println(eingabe + ": ");
        return scanner.nextLine().trim();
    }

    private static Integer readKeyFigures (String eingabe, int min, int max) {
        int value = readInteger(eingabe);
        if (value < min && value > max) {
            System.out.println("Gib eine zahl zwischen " + min + " und " + max + " ein");
        }
        return value;
    }

    private static void initializePersistence() {
        persistenceStrategy.setLOCATION(FILE_PATH);
        container.setPersistenceStrategyUserStroies(persistenceStrategy);
        System.out.println("Willkommen zum User Story Management System. Geben Sie 'help' für eine Liste der Befehle ein.");
    }

    private static void createUserStory() throws ContainerException, org.hbrs.se1.ws24.exercises.uebung4.prototype.ContainerException {
        String project = readString("Project");
        String acceptance = readString("Acceptanzkriterium");
        String titel = readString("Titel");
        Integer id = readInteger("ID");
        Integer value = readKeyFigures("Mehrwert von 1 bis 5 ( 1 = niedrig, 5 = hoch", 1, 5);
        Integer risk = readKeyFigures("Risiko von 1 bis 5 ( 1 = niedrig, 5 = hoch", 1, 5);
        Integer effort = readKeyFigures("Aufwand von 1 bis 5 ( 1 = niedrig, 5 = hoch", 1, 5);
        Integer penalty = readKeyFigures("Strafe von 1 bis 5 ( 1 = niedrig, 5 = hoch", 1, 5);

        UserStory userStory = new UserStory(project,acceptance,titel,id,value,risk,effort,penalty);
        container.addItems(userStory);
        System.out.println("neue User Story hinzugefügt");
    }

    private static void userCommands() {
        System.out.println("> ");
        String eingabe = scanner.nextLine();
        String [] teile = eingabe.split(" ", 3);
        String befehle = teile[0];
        try {
            switch (befehle) {
                case "enter" -> createUserStory();
                case "store" -> container.store();
                case "load" -> container.load();
                case "dump" -> {
                    if (teile.length > 2) UserStoryView.dump(container.getItemList(), teile[1], teile[2]);
                    else UserStoryView.dump(container.getItemList());
                }
                case "exit" -> {
                    System.out.println("Ciao Kakao");
                }
                case "help" -> printHelp();
                default -> System.out.println("Geben Sie 'help' für Hilfe ein");
                }
            } catch (Exception e) {
            System.out.println("Fehler: " + e.getMessage());
        }
    }

    public static void main (String[] args) {
        initializePersistence();
        userCommands();
    }

}

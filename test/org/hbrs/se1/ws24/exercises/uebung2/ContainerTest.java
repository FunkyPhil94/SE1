package org.hbrs.se1.ws24.exercises.uebung2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    private Container container;
    private Member memberNr1;
    private Member memberNr2;

    @BeforeEach
    void setUp() {
        container = new Container();
        memberNr1 = new ConcreteMember(1);
        memberNr2 = new ConcreteMember(2);
    }

    @AfterEach
    void tearDown() {
        container = null;
        memberNr1 = null;
        memberNr2 = null;
    }

    @Test
    void testAddMemberAndSize() throws ContainerException {
        // Größe testen beim hinzufügen von Objekten
        assertEquals(0, container.size(), "Falsche Größe!");
        container.addMember(memberNr1);
        assertEquals(1, container.size(), "Falsche Größe!");
        container.addMember(memberNr2);
        assertEquals(2, container.size(), "Falsche Größe!");

        // Testen, ob ein bereits hinzugefügter Member eine ContainerException auswirft
        assertThrows(ContainerException.class, () -> container.addMember(memberNr1), "Exception Klasse wird nicht aufgerufen");
        assertThrows(ContainerException.class, () -> container.addMember(memberNr2), "Exception Klasse wird nicht aufgerufen");

    }

    @Test
    void testDeleteMember() throws ContainerException {
        // Testen, ob leere Liste erkannt wird
        assertEquals(0, container.size(), "Falsche Größe!");
        assertEquals("Keine Member vorhanden!", container.deleteMember(1), "Keine Fehlermeldung beim löschen in einer leeren Liste");

        // Testen, ob fehlerhaft leere Liste erkannt wird
        container.addMember(memberNr1);
        assertEquals(1, container.size(), "Falsche Größe!");
        assertNotEquals("Keine Member vorhanden!", container.deleteMember(1), "Fehlerhafte Ausgabe, dass die Liste leer ist, obwohl Liste nicht leer ist");
        assertEquals(0, container.size(), "Falsche Größe!");

        // Testen, ob nicht vorhandende ID erkannt wird
        container.addMember(memberNr1);
        assertEquals(1, container.size(), "Falsche Größe!");
        assertEquals("Kein Member mit der ID vorhanden!", container.deleteMember(100), "Nicht vorhandende ID wird als vorhanden erkannt");
        assertEquals(1, container.size(), "Falsche Größe!");

        // Testen, ob ordungsgemäß gelöscht wird
        assertEquals("Member mit der ID " + memberNr1.getID() + " wurde entfernt: " + memberNr1.toString(), container.deleteMember(1), "Falsche Ausgabe beim erfolgreichen Löschen eines Members");
        assertEquals(0, container.size(), "Falsche Größe!");
    }

}
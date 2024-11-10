package org.hbrs.se1.ws24.exercises.uebung2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    private Container container = null;

    @BeforeEach
    void setUp() {
        container = new Container();
    }
    @Test
    void AddAndDeleteMember() {

            Member m1 = new ConcreteMember(1);
            Member m2 = new ConcreteMember(2);

            assertEquals(0, container.size(),"Container nicht leer");

            try {
                container.addMember(m1);
            } catch (ContainerException e) {
                e.printStackTrace();
            }

            assertEquals(1, container.size(),
                    "m1 konnte nicht hinzugefügt werden");

            try {
                container.addMember(m2);
            } catch (ContainerException e) {
                e.printStackTrace();
            }

            assertEquals(2, container.size(),
                    "m2 konnte nicht hinzugefügt werden");

            assertThrows(ContainerException.class, () -> {
                container.addMember(m2);
            });

            assertEquals(2, container.size(),
                    "Nicht mehr 2 im Container");

            String result = container.deleteMember(99);

            assertEquals(2, container.size(),
                "Nicht mehr 2 im Container");

            assertEquals("Keine Member mit der ID vorhanden", result);

            container.dump();

            container.deleteMember(1);
            assertEquals(1, container.size(),
                "Nicht mehr 1 im Container");

            container.deleteMember(2);
            assertEquals(0, container.size(),
                "Nicht mehr 0 im Container");
    }
}
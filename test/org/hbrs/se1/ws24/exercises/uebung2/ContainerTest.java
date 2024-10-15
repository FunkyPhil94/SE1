package org.hbrs.se1.ws24.exercises.uebung2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    Container container;
    Member memberNr1;
    Member memberNr2;

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
    void addMemberTest() {
        container.addMember(memberNr1);
        assertEquals(1, container.size(), "Größe stimmt nicht");

        container.addMember(memberNr2);
        assertEquals(2, container.size(), "Größe Stimmt nicht");

        assertThrows(ContainerException.class, () -> container.addMember(memberNr1));
        assertEquals(2, container.size(), "Größe Stimmt nicht");

    }

    @Test
    void deleteMemberTest() {
        container.addMember(memberNr1);
        container.addMember(memberNr2);

        container.dump();

        assertEquals(2, container.size(), "Größe stimmt nicht!");

        container.deleteMember(1);
        assertEquals(1, container.size(), "Größe stimmt nicht!");

        container.deleteMember(1);
        assertEquals(1, container.size(), "Größe stimmt nicht!");

        container.deleteMember(2);
        assertEquals(0, container.size(), "Größte stimmt nicht");
    }

}
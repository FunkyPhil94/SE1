package org.hbrs.se1.ws24.exercises.uebung3;

import org.hbrs.se1.ws24.exercises.uebung2.ConcreteMember;
import org.hbrs.se1.ws24.exercises.uebung2.ContainerException;
import org.hbrs.se1.ws24.exercises.uebung2.Member;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceStrategyMongoDB;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceStrategyStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContainerTest {

    private Container<Member> container;

    private Member member;

    @BeforeEach
    public void setUp() {
        container = Container.getInstance();
        member = new ConcreteMember(1);
    }

    @AfterEach
    public void setDown() {
        container = null;
        member = null;
    }

    @Test
    public void testNullPersistence() throws ContainerException {
        PersistenceStrategyStream<Member> strategyStream = null;
        container.setPersistenceStrategyStream(strategyStream);
        container.addMember(member);
        assertThrows(PersistenceException.class, () -> container.store());
        assertThrows(PersistenceException.class, () -> container.load());
        container.deleteMember(1);
    }

    @Test
    public void usingMongoDBPersistenceStrategy() throws ContainerException {
        container.addMember(member);
        container.setPersistenceStrategyStream(new PersistenceStrategyMongoDB<>());
        assertThrows(UnsupportedOperationException.class, () -> container.store());
        assertThrows(UnsupportedOperationException.class, () -> container.load());
        container.deleteMember(1);
    }

    @Test
    public void wrongDirectory() {
        PersistenceStrategyStream<Member> strategyStream = new PersistenceStrategyStream<>();
        strategyStream.setLocation("/");
        container.setPersistenceStrategyStream(strategyStream);
        assertThrows(PersistenceException.class, () -> container.store());
        assertThrows(PersistenceException.class, () -> container.load());
    }

    @Test
    public void roundTripTest() throws ContainerException {
        PersistenceStrategyStream<Member> strategyStream = new PersistenceStrategyStream<>();
        strategyStream.setLocation("test/org/hbrs/se1/ws24/exercises/uebung3/objects.ser");
        container.setPersistenceStrategyStream(strategyStream);
        container.addMember(member);
        assertEquals(1, container.size());

        assertDoesNotThrow(() -> container.store());

        container.deleteMember(1);
        assertEquals(0, container.size());

        assertDoesNotThrow(() -> container.load());
        assertEquals(1, container.size());
    }

}

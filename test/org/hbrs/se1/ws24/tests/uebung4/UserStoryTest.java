package org.hbrs.se1.ws24.tests.uebung4;

import org.hbrs.se1.ws24.exercises.uebung4.prototype.UserStory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserStoryTest {

    UserStory userStory = new UserStory("Test Projekt", "Test Akzeptanz", "Test Titel", 1, 4, 2, 2, 4);

    @Test
    void testGetterMethods() {
        assertEquals(1, userStory.getId());
        assertEquals("Test Titel", userStory.getTitel());
        assertEquals("Test Akzeptanz", userStory.getAcceptance());
        assertEquals("Test Projekt", userStory.getProject());
        assertEquals(2.0, userStory.getPriority());
    }
}
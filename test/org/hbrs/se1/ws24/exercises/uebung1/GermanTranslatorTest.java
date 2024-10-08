package org.hbrs.se1.ws24.exercises.uebung1;

import org.hbrs.se1.ws24.exercises.uebung1.control.Factory;
import org.hbrs.se1.ws24.exercises.uebung1.control.Translator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GermanTranslatorTest {

    Translator translator;

    @BeforeEach
    public void create() {
        translator = Factory.createGermanTranslator();
    }

    @Test
    public void lower() {
        assertNotEquals("null", translator.translateNumber(0));
    }

    @Test
    public void higher() {
        assertNotEquals("elf",translator.translateNumber(11));
    }

    @Test
    public void inRange() {
        assertEquals("vier",translator.translateNumber(4));
    }

}
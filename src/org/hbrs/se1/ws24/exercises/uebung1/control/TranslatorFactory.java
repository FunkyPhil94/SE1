package org.hbrs.se1.ws24.exercises.uebung1.control;

import org.hbrs.se1.ws24.solutions.uebung1.control.GermanTranslator;
import org.hbrs.se1.ws24.solutions.uebung1.control.Translator;

public class TranslatorFactory {

    public static Translator createGermanTranslator() {

        GermanTranslator translator = new GermanTranslator();
        translator.setDate("11-11-2024");
        return translator;
    }


}

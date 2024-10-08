package org.hbrs.se1.ws24.exercises.uebung1.control;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Factory {

    public static GermanTranslator createGermanTranslator() {

        GermanTranslator translator = new GermanTranslator();

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("LLL/yyyy");

        translator.setDate((date.format(dateTimeFormatter)));
        translator.printInfo();
        return translator;
    }


}

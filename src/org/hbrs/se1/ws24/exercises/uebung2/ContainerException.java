package org.hbrs.se1.ws24.exercises.uebung2;

public class ContainerException extends Exception {

    private Integer id;

    public ContainerException (String id) {
        super ("Das Member-Objekt mit der ID " + id + " ist bereits vorhanden!");
    }

}

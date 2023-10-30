package org.lessons.java;

import java.util.Date;

public class Concerto extends Evento{
    public Concerto(String titolo, Date data, int postiTotali) throws IllegalArgumentException {
        super(titolo, data, postiTotali);
    }
}

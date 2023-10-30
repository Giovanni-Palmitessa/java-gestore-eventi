package org.lessons.java;

import java.util.ArrayList;
import java.util.List;

public class ProgrammEventi {
    //Attributi
    private String titolo;
    private List<Evento> listaEventi;

    //Costruttore

    public ProgrammEventi(String titolo) {
        this.titolo = titolo;
        this.listaEventi = new ArrayList<>();
    }
}

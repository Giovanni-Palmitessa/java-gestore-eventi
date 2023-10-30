package org.lessons.java;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    //Metodi
    //aggiungere evento a lista Eventi
    public void aggiungiEvento(Evento evento) {
        listaEventi.add(evento);
    }
    // ritornare eventi di una determinata data
    public List<Evento> eventiData(Date data) {
        List<Evento> eventiData = new ArrayList<>();
        for (Evento evento : listaEventi) {
            if (evento.getData().equals(data)) {
                eventiData.add(evento);
            }
        }
        return eventiData;
    }
    // contare eventi presenti nella lista
    public int numeroEventi() {
        return listaEventi.size();
    }

    //svuotare tutti gli eventi presenti nella lista
    public void svuotaEventi() {
        listaEventi.clear();
    }

    // ritornare una stringa che mostra il titolo del programma e tutti gli eventi ordinati per data
    // To Add
}

package org.lessons.java;

import java.util.Date;

public class Evento {
    //COSTANTI DI CLASSI
    public final static int MAX_POSTI = 3000;

    //Attributi
    private String titolo;
    private Date data;
    private int postiPrenotati;

    //Costruttore
    public Evento(String titolo, Date data) throws IllegalArgumentException {
        //controllo se data è valida
        if (data.before(new Date())) {
            throw new IllegalArgumentException("La data dell'evento non può essere nel passato");
        }
        this.titolo = titolo;
        this.data = data;
        this.postiPrenotati = 0;
    }
    //Getter e Setter

    public String getTitolo() {
        return titolo;
    }

    public Date getData() {
        return data;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }
}

package org.lessons.java;

import java.util.Date;

public class Evento {
    //Attributi
    private String titolo;
    private Date data;
    private int postiTotali;
    private int postiPrenotati;

    //Costruttore
    public Evento(String titolo, Date data, int postiTotali) throws IllegalArgumentException {
        //controllo se data è valida
        if (data.before(new Date())) {
            throw new IllegalArgumentException("La data dell'evento non può essere nel passato!");
        }

        //controllo che i posti Totali siano numero positivo valido
        if (postiTotali <= 0) {
            throw new IllegalArgumentException("Il numero dei posti totali deve essere maggiore di 0!");
        }
        this.titolo = titolo;
        this.data = data;
        this.postiTotali = postiTotali;
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

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setData(Date data) {
        this.data = data;
    }
}

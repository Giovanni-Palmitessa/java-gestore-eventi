package org.lessons.java;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Date;

public class Concerto extends Evento{
    //attributi
    private LocalTime ora;
    private BigDecimal prezzo;

    //Costruttore
    public Concerto(String titolo, Date data, int postiTotali, LocalTime ora, BigDecimal prezzo) throws IllegalArgumentException {
        super(titolo, data, postiTotali);
        this.ora = ora;
        this.prezzo = prezzo;
    }
}

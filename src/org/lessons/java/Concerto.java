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

    //Getter e Setter

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }
}

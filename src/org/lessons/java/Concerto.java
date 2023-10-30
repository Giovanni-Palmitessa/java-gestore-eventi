package org.lessons.java;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

    //Metodi
    public String getDataFormattata() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return getData().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate().format(dateTimeFormatter);
    }

    public String getOraFormattata() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return ora.format(dateTimeFormatter);
    }

    public String getPrezzoFormattato() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00€");
        return decimalFormat.format(prezzo);
    }

    //toString
    @Override
    public String toString() {
        return getDataFormattata() + " - " + getOraFormattata() + " - " + getTitolo() + " - " + getPrezzoFormattato();
    }
}

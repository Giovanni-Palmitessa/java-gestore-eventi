package org.lessons.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Istanzio lo scanner
        Scanner scan = new Scanner(System.in);

        //Chiedo all'utente di aggiungere un nuovo Evento
        System.out.println("Gestore di Eventi, Benvenuto! Aggiungi un nuovo evento!");
        //titolo
        System.out.println("Inserisci il titolo dell'Evento: ");
        String titolo = scan.nextLine();
        //data
        System.out.println("Inserisci la data dell'Evento: (formato: yyyy-mm-dd)");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date data = null;
        //controllo se la data inserita è corretta
        try {
            data = dateFormat.parse(scan.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        // posti Totali
        System.out.println("Inserisci il numero di posti totali:");
        int postiTotali = scan.nextInt();

        //creo il nuovo evento
        Evento evento = new Evento(titolo, data, postiTotali);

        //Chiudo lo scanner
        scan.close();
    }
}

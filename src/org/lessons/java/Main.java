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
        // posti Totali
        int postiTotali = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Inserisci il numero di posti totali:");
            String postiTotaliInput = scan.nextLine();

            if (postiTotaliInput.isEmpty()) {
                System.out.println("Errore: Devi inserire un numero valido di posti totali!");
            } else {
                try {
                    postiTotali = Integer.parseInt(postiTotaliInput);
                    validInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("Errore: Il numero di posti totali deve essere un numero valido!");
                }
            }
        }
        //data
        Date data = null;
        validInput = false;

        //controllo se la data è valida
        while (!validInput) {
            System.out.println("Inserisci la data dell'Evento (formato: yyyy-MM-dd):");
            String dataString = scan.nextLine();

            //controllo se utente mette stringa vuota
            if (dataString.isEmpty()) {
                System.out.println("Errore: Devi inserire una data valida!");
            } else {
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    data = dateFormat.parse(dataString);
                    validInput = true;
                } catch (java.text.ParseException e) {
                    System.out.println("Errore: Formato data non valido!");
                }
            }
        }

        // istanzio il nuovo evento
        Evento evento = null;
        try {
            evento = new Evento(titolo, data, postiTotali);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // dopo aver creato l'evento chiedo quanti posti vuole prenotare
        System.out.println("Quante prenotazioni vuoi fare?");
        int postiPrenotati = Integer.parseInt(scan.nextLine());

        //aggiungo le prenotazioni
        try {
            evento.prenota(postiPrenotati);
            System.out.println("Prenotazioni effettuate con successo!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        //Chiudo lo scanner
        scan.close();
    }
}

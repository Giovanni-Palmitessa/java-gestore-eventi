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
        try {
            System.out.println("Inserisci la data dell'Evento: (formato: yyyy-MM-dd)");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date data = dateFormat.parse(scan.nextLine());

            // Prova a creare l'oggetto Evento
            Evento evento = new Evento(titolo, data, postiTotali);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        //creo il nuovo evento
//        Evento evento = new Evento(titolo, data, postiTotali);

        //Chiudo lo scanner
        scan.close();
    }
}

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

            if (dataString.isEmpty()) {
                System.out.println("Errore: Devi inserire una data valida!");
            } else {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateFormat.setLenient(false);

                try {
                    Date parsedDate = dateFormat.parse(dataString);
                    if (parsedDate.before(new Date())) {
                        System.out.println("Errore: La data dell'evento non può essere nel passato!");
                    } else {
                        data = parsedDate;
                        validInput = true;
                    }
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

        // dopo aver creato l'evento chiedo se vuole prenotare un posto
        if (evento != null) {
            System.out.println("Vuoi prenotare un posto? (Sì/No)");
            String rispostaPrenotazione = scan.nextLine();
            // chiedo quanti posti vuoi prenotare
            if (rispostaPrenotazione.equalsIgnoreCase("Si")) {
                System.out.println("Quanti posti vuoi prenotare?");
                int postiPrenotati;

                try {
                    postiPrenotati = Integer.parseInt(scan.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Errore: Devi inserire un numero valido per le prenotazioni.");
                    return;
                }

                //aggiungo le prenotazioni
                try {
                    evento.prenota(postiPrenotati);
                    System.out.println("Prenotazioni effettuate con successo!Hai prenotato " + postiPrenotati + " posto/i.Sono disponibili ancora: " + (postiTotali - postiPrenotati) + " posto/i." );
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Nessuna prenotazione effettuata.");
            }

            // chiedo all'utente se vuole disdire un posto
            System.out.println("Vuoi disdire un posto? (Sì/No)");
            String rispostaDisdetta = scan.nextLine();
            // chiedo quanti posti vuoi disdire
            if (rispostaDisdetta.equalsIgnoreCase("Si")){
                System.out.println("Quanti posti vuoi disdire?");
                int postiDisdetti;

                try {
                    postiDisdetti = Integer.parseInt(scan.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Errore: Devi inserire un numero valido per le prenotazioni.");
                    return;
                }

                // aggiungo le disdette
                try {
                    evento.disdici(postiDisdetti);
                    System.out.println("Prenotazioni effettuate con successo!");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Nessuna disdetta effettuata.");
            }
        }


        //Chiudo lo scanner
        scan.close();
    }
}

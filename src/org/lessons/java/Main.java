package org.lessons.java;

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


        //Chiudo lo scanner
        scan.close();
    }
}

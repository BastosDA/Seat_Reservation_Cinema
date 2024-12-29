/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cinema.outils;

import static com.mycompany.cinema.Cinema.COLONNES;
import static com.mycompany.cinema.Cinema.RANGEES;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author André
 */
public class cinemaOutils {

    private static String fileName;
    public static void initialiserSalle(char[][] salle) {
        for (int i = 0; i < RANGEES; i++) {
            for (int j = 0; j < COLONNES; j++) {
                salle[i][j] = 'L';
            }
        }
    }

    
    public static void chargerReservations(char[][] salle) {
        int j;
        int i;
        File file = new File(fileName);
        if(file.exists()){
            try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
                for(i = 0; i < RANGEES; i++){
                    String line = reader.readLine();
                    for(j = 0; j < COLONNES; j++){
                        salle[i][j] = line.charAt(j);
                    }
                }
            }catch(IOException e){
                System.out.println("Erreur lors du chargement des réservations : " + e.getMessage());
            }
        }
    }
    public static void afficherSalle(char[][] salle) {
        for (int i = 0; i < RANGEES; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < COLONNES; j++) {
                System.out.print(salle[i][j] + " ");
            }
            System.out.println(); // Ajout du retour à la ligne
        }
    }

    public static void reserverPlaces(char[][] salle, Scanner sc) {
        System.out.print("Combien de places voulez-vous réserver ? ");
        int nbDePlaces = Integer.parseInt(sc.nextLine());

        if (nbDePlaces == 1) {
            boolean reserver;
            do {
                System.out.print("Rangée (1 à " + RANGEES + ") : ");
                int rangees = Integer.parseInt(sc.nextLine()) - 1;

                System.out.print("Colonne (1 à " + COLONNES + ") : ");
                int colonnes = Integer.parseInt(sc.nextLine()) - 1;

                if (salle[rangees][colonnes] == 'L') {
                    salle[rangees][colonnes] = 'R';
                    System.out.println("Place réservée avec succès.");
                    reserver = true;
                } else {
                    System.out.println("La place est déjà réservée.");
                    reserver = false;
                }
            } while (!reserver);
        } else {
            System.out.print("Choisir une rangée pour " + nbDePlaces + " places consécutives : ");
            int rangees = Integer.parseInt(sc.nextLine()) - 1;

            System.out.print("Numéro de la première colonne (1 à " + (COLONNES - nbDePlaces + 1) + ") : ");
            int debutColonne = Integer.parseInt(sc.nextLine()) - 1;

            boolean valide = true;
            for (int i = 0; i < nbDePlaces; i++) {
                if (salle[rangees][debutColonne + i] == 'R') {
                    valide = false;
                    break;
                }
            }

            if (valide) {
                for (int i = 0; i < nbDePlaces; i++) {
                    salle[rangees][debutColonne + i] = 'R';
                }
                System.out.println("Les places ont été réservées avec succès.");
            } else {
                System.out.println("Une ou plusieurs places dans le lot sont déjà réservées.");
            }
        }
    }


    public static void annulerReservation(char[][] salle, Scanner sc) {
        System.out.print("Combien de places voulez-vous annuler ? ");
        int nbDePlaces = Integer.parseInt(sc.nextLine());

        while (true) {
            System.out.print("Rangée (1 à " + RANGEES + ") : ");
            int rangees = Integer.parseInt(sc.nextLine()) - 1;

            System.out.print("Numéro de la première colonne (1 à " + (COLONNES - nbDePlaces + 1) + ") : ");
            int debutColonne = Integer.parseInt(sc.nextLine()) - 1;

            boolean valide = true;
            for (int i = 0; i < nbDePlaces; i++) {
                if (salle[rangees][debutColonne + i] == 'L') {
                    valide = false;
                    break;
                }
            }

            if (valide) {
                for (int i = 0; i < nbDePlaces; i++) {
                    salle[rangees][debutColonne + i] = 'L';
                }
                System.out.println("Les places ont été annulées avec succès.");
                break;
            } else {
                System.out.println("Une ou plusieurs places dans le lot ne sont pas réservées. Veuillez réessayer.");
            }
        }
    }


    public static void afficherStatistiques(char[][] salle) {
        int libres = 0, reservees = 0;

        for (int i = 0; i < RANGEES; i++) {
            for (int j = 0; j < COLONNES; j++) {
                if (salle[i][j] == 'L') {
                    libres++;
                } else if (salle[i][j] == 'R') {
                    reservees++;
                }
            }
        }

        System.out.println("Statistiques :");
        System.out.println("Places libres : " + libres);
        System.out.println("Places réservées : " + reservees);
    }

    public static void sauvegarderReservations(char[][] salle) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
      for (int i = 0; i < RANGEES; i++) {
        for (int j = 0; j < COLONNES; j++) {
          writer.write(salle[i][j]);
        }
      writer.newLine();
      }
    } catch (IOException e) {
      System.out.println("Erreur lors de la sauvegarde des réservations : " + e.getMessage());
    }
    }
}

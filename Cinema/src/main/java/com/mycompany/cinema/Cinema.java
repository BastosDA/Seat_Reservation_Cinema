package com.mycompany.cinema;

import com.mycompany.cinema.outils.cinemaOutils;
import static com.mycompany.cinema.outils.cinemaOutils.*;
import java.util.Scanner;

/**
 *
 * @author André
 */
public class Cinema {

    public static final int RANGEES = 5;
    public static final int COLONNES = 10;
    public static final String FILE_NAME = "reservations.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] salle = new char[RANGEES][COLONNES]; // 'L' pour Libre, 'R' pour Réservé
        
        try {
            // Initialisation de la salle
            initialiserSalle(salle);
            chargerReservations(salle);
        } catch (Exception e) {
            System.out.println("Erreur lors de l'initialisation ou du chargement des données : " + e.getMessage());
        }
        
        boolean continuer = true;
        while (continuer) {
            // Affichage de la salle
            System.out.println("\n--- État actuel de la salle ---");
            afficherSalle(salle);

            // Menu principal
            System.out.println("\nMenu : ");
            System.out.println("1. Réserver des places");
            System.out.println("2. Annuler une réservation");
            System.out.println("3. Afficher les statistiques");
            System.out.println("4. Quitter");
            System.out.print("Votre choix : ");

            try {
                int choix = Integer.parseInt(sc.nextLine());
                switch (choix) {
                    case 1:
                        reserverPlaces(salle, sc);
                        break;
                    case 2:
                        annulerReservation(salle, sc);
                        break;
                    case 3:
                        afficherStatistiques(salle);
                        break;
                    case 4:
                        continuer = false;
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez entrer un nombre entre 1 et 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
            }
        }

        // Sauvegarde des réservations
        try {
            sauvegarderReservations(salle);
            System.out.println("\nLes réservations ont été sauvegardées avec succès.");
        } catch (Exception e) {
            System.out.println("Erreur lors de la sauvegarde des réservations : " + e.getMessage());
        }

        System.out.println("Merci d'avoir utilisé notre système de réservation.");
        sc.close();
    }
}

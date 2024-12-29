/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cinema;

import com.mycompany.cinema.outils.cinemaOutils;
import static com.mycompany.cinema.outils.cinemaOutils.afficherSalle;
import static com.mycompany.cinema.outils.cinemaOutils.afficherStatistiques;
import static com.mycompany.cinema.outils.cinemaOutils.annulerReservation;
import static com.mycompany.cinema.outils.cinemaOutils.chargerReservations;
import static com.mycompany.cinema.outils.cinemaOutils.initialiserSalle;
import static com.mycompany.cinema.outils.cinemaOutils.reserverPlaces;
import static com.mycompany.cinema.outils.cinemaOutils.sauvegarderReservations;
import java.util.Scanner;

/**
 *
 * @author André
 */
public class Cinema {
    
    public static Scanner sc = new Scanner(System.in);
    public static final int RANGEES = 5;
    public static final int COLONNES = 10;
    static String fileName = "reservations.txt";
    
    public static void main(String[] args) {
        char[][] salle = new char[RANGEES][COLONNES]; // 'L' pour Libre, 'R' pour Réservé
        
        initialiserSalle(salle);
        chargerReservations(salle);
        
        boolean continuer = true;
        while (continuer) {
            afficherSalle(salle);
            System.out.println("Menu : ");
            System.out.println("1. Réserver des places");
            System.out.println("2. Annuler une réservation");
            System.out.println("3. Afficher les statistiques");
            System.out.println("4. Quitter");
            System.out.print("Choix : ");
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
                    System.out.println("Choix invalide.");
                break;
            }
        }
        sauvegarderReservations(salle);
        System.out.println("Merci d'avoir utilisé notre système de réservation.");
        sc.close();
        }
}
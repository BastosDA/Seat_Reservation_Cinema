/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cinema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import static javax.swing.text.html.HTML.Attribute.COLS;
import static javax.swing.text.html.HTML.Attribute.ROWS;

/**
 *
 * @author André
 */
public class Cinema {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // Le programme permet de définir la taille de la salle (nombre de rangées et de colonnes).
        int nbRangees;
        int nbColonnes;
        
        System.out.println("Définir la taille de la salle");
        System.out.print("Rangées : ");
        nbRangees = Integer.parseInt(sc.nextLine());
        System.out.print("Colonnes : ");
        nbColonnes = Integer.parseInt(sc.nextLine());
        
        char[][] salle = new char[nbRangees][nbColonnes];
        for (int i = 0; i < salle.length; i++) {
            for (int j = 0; j < salle[i].length; j++) {
                salle[i][j] = 'L'; // 'L' pour Libre
            }
        }
        
        // Affichage de l'état actuel de la salle (places libres, réservées).
        System.out.println("\nÉtat de la salle :");
        System.out.print("   "); // Espacement pour les indices des colonnes
        for (int j = 0; j < salle[0].length; j++) {
            System.out.print(j + " "); // Afficher les indices des colonnes
        }
        System.out.println();
        for (int i = 0; i < salle.length; i++) {
            System.out.print(i + " "); // Afficher les indices des rangées
            for (int j = 0; j < salle[i].length; j++) {
                System.out.print(salle[i][j] + " ");
            }
            System.out.println();
        }
        
        // Réservation de places :
        System.out.println("Réserver une place :");
        System.out.print("Rangée (0 à " + (nbRangees - 1) + ") : ");
        int rangee = Integer.parseInt(sc.nextLine());
        System.out.print("Colonne (0 à " + (nbColonnes - 1) + ") : ");
        int colonne = Integer.parseInt(sc.nextLine());
        
        if (salle[rangee][colonne] == 'L') {
            salle[rangee][colonne] = 'R';
            System.out.println("Place réservée avec succès.");
        } else {
            System.out.println("La place est déjà réservée.");
        }   
        /*
        System.out.println("\nÉtat de la salle :");
        System.out.print("   "); // Espacement pour les indices des colonnes
        for (int j = 0; j < salle[0].length; j++) {
            System.out.print(j + " "); // Afficher les indices des colonnes
        }
        System.out.println();
        for (int i = 0; i < salle.length; i++) {
            System.out.print(i + " "); // Afficher les indices des rangées
            for (int j = 0; j < salle[i].length; j++) {
                System.out.print(salle[i][j] + " ");
            }
            System.out.println();
        }*/
        
        // Individuelle ou par lots (places côte à côte sur la même rangée).
        
        // Vérification de la disponibilité des places avant réservation.
        
        // Sauvegarde de l'état des réservations dans un fichier texte.
        /*try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    writer.write(salle[i][j]);
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des réservations : " + e.getMessage());
        }
        
        // Restaurer l'état des réservations depuis un fichier
        File file = new File(fileName);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                for(int i = 0; i < ROWS; i++){
                    String line = reader.readLine();
                    for(int j = 0; j < COLS; j++){
                        salle[i][j] = line.charAt(j);
                    }
                }       
            } catch (IOException e) {
                System.out.println("Erreur lors du chargement des réservations : " + e.getMessage());
        }*/
        // Chargement des réservations précédentes depuis un fichier lors du démarrage.
        
        // Possibilité d’annuler une réservation.
        
        // Affichage des statistiques : nombre de places réservées, libres, etc.
    }
}

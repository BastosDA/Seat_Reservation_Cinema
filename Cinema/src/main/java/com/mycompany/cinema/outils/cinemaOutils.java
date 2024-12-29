/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cinema.outils;

import static com.mycompany.cinema.Cinema.COLONNES;
import static com.mycompany.cinema.Cinema.RANGEES;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author André
 */
public class cinemaOutils {

    private static String fileName;
    public  static void initialiserSalle(char[][] salle) {
        boolean pReserver;
        int j;
        int i;
        
        for(i = 0; i < RANGEES; i++){
            for(j = 0; i < COLONNES;j++){
                salle[COLONNES][RANGEES] = 'L';
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
        int j;
        int i;
        
        for(i = 0; i < RANGEES; i++){
            System.out.print(i + " ");
            for(j = 0; j < COLONNES; j++){
                System.out.print(salle[i][j] + " ");
            }
        }
    }
    public static void reserverPlaces(char[][] salle, Scanner sc) {
        
    }

    public static void annulerReservation(char[][] salle, Scanner sc) {
        
    }

    public static void afficherStatistiques(char[][] salle) {
        
    }

    public static void sauvegarderReservations(char[][] salle) {
        
    }
}

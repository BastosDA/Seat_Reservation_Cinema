# Seat_Reservation_Cinema
**Plinio Sacchetti / v1.0 / SalleDeCinémaJava.docx**  

## Cinéma : Réservation de places  

### 1. Description  
L’application permet de gérer la réservation de places dans une salle de cinéma. Les places sont numérotées, et les utilisateurs peuvent réserver des places individuellement ou par lots (places côte à côte sur la même rangée). L'état de la salle est affiché après chaque réservation, et les données sont sauvegardées dans des fichiers pour persister l’état des réservations.  

### 2. Fonctionnalités principales  
- Le programme permet de définir la taille de la salle (nombre de rangées et de colonnes).  
- Affichage de l'état actuel de la salle (places libres, réservées).  
- Réservation de places :  
  - Individuelle ou par lots (places côte à côte sur la même rangée).  
  - Vérification de la disponibilité des places avant réservation.  
- Sauvegarde de l'état des réservations dans un fichier texte.  
- Chargement des réservations précédentes depuis un fichier lors du démarrage.  
- Possibilité d’annuler une réservation.  
- Affichage des statistiques : nombre de places réservées, libres, etc.  

### 3. Détails techniques  
- Tableau 2D pour représenter la salle de cinéma, chaque cellule indique si une place est libre ou réservée.  
- Méthodes pour :  
  - Créer la salle avec des places numérotées.  
  - Vérifier la disponibilité des places.  
  - Gérer les réservations individuelles et par lots.  
  - Sauvegarder et charger l'état des réservations.  
  - Afficher l’état actuel de la salle.  

### 4. Plan du projet  
1. **Initialisation** : Définition de la taille de la salle (nombre de rangées et de colonnes) et initialisation de l’état des places (libres).  
2. **Affichage de la salle** : L’utilisateur peut visualiser l'état actuel de la salle.  
3. **Réservation** : L’utilisateur peut réserver une ou plusieurs places côte à côte dans une même rangée.  
4. **Vérification des places** : Le programme vérifie si les places demandées sont libres.  
5. **Sauvegarde/chargement des données** : Sauvegarde des réservations dans un fichier texte et chargement à l’ouverture de l’application.  
6. **Annulation de réservation** : L'utilisateur peut annuler une réservation donnée.  
7. **Statistiques** : Le programme affiche le nombre de places réservées et libres.  

# Projet BASE_AP  
**Plinio Sacchetti / v1.0 / SalleDeCinémaJava.docx**  

### 5. Délai  
Temps estimé : **4p**  
**Commencez par faire une analyse en FRS ou STRUCTOGRAMME**  

### 6. À disposition  
PC de l’école, sans connexion Internet  

# FRS
## Principal
CONSTANTES
  COLONNES <-- 40
  RANGEES <-- 15
VARIABLES
  continuer : Boolean
  salle : Liste d'entier 2D
  choix : entier

DEBUT
  salle <-- [COLONNES][RANGEES]

  initialiserSalle
  chargerReservation

  continuer <-- true
  TANT QUE continuer == true
    Afficher salle
    Afficher "Menu : "
    Afficher " 1. Réserver des places"
    Afficher " 2. Annuler une réservation"
    Afficher " 3. fficher les statistiques"
    Afficher " 4. Quitter"
    choix <-- Saisir
    SELON QUE choix
      1 : reserverPlaces

      2 : annulerReservation

      3 : afficherReservation

      4 : continuer <-- false

      Autre : Afficher "Choix invalide"
    FIN SELON QUE 
  FIN TANT QUE

  sauvegardeReservations
  Afficher "Merci d'avoir utilisé notre système de réservation."
FIN

## initialiserSalle
CONSTANTES 

VARIABLES
 j : entier
 i : entier

DEBUT
  POUR i  ALLANT DE 0 A COLONNES
    POUR j ALLANT DE 0 A RANGEES
      salle[i][j] <-- "L" 
    FIN POUR
  FIN POUR
FIN

## chargerReservations 
// Restaurer l'état des réservations depuis un fichier
  static void chargerReservations(char[][] salle) {
    File file = new File(fileName);
    if (file.exists()) {
      try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        for (int i = 0; i < ROWS; i++) {
          String line = reader.readLine();
          for (int j = 0; j < COLS; j++) {
            salle[i][j] = line.charAt(j);
          }
        }
      } catch (IOException e) {
        System.out.println("Erreur lors du chargement des réservations : " + e.getMessage());
      }
  }
## afficherSalle
CONSTANTES 

VARIABLES
 pReserver : Boolean
 j : entier
 i : entier

DEBUT
  POUR i  ALLANT DE 1 A COLONNES
    Afficher i, " "
    POUR j ALLANT DE 1 A RANGEES
      Afficher salle[i][j], " "
    FIN POUR
  FIN POUR
FIN

## reserverPlaces
CONSTANTES 
  COLONNES <-- 40
  RANGEES <-- 15

VARIABLES
 nbDePlaces : entier
 rangees : entier
 colonnes : entier
 reserver : Booleen

DEBUT
  Afficher "Combien de place voulez-vous ?"
  nbDePlaces <-- Saisir
  SI nbDePlaces == 1
    FAIRE
      Affiher "Reserver une place : 
      Afficher "Rangées (1 à", RANGEES ,")", " : "
      rangees <-- Saisir 
      Afficher "Colonnes (1 à", COLONNES ,")", " : "
      colonnes <-- Saisir
      SI (salle[RANGEES][COLONNES] = 'L')
        salle[RANGEES][COLONNES] <-- 'R'
        Afficher "Place réservée avec succès."
        reserver <-- true
      SINON
        Afficher "La place est déjà réservée"
        reserver <-- false
      FIN SI
    TANT QUE reserver = false
  SINON
    Afficher "Choisir une rangée pour ", nbDePlaces, " entre "
    rangees <-- Saisir 
    TANT QUE nbDePlaces > COLONNES

  FIN SI
FIN

## annulerReservation
CONSTANTES 
  COLONNES <-- 40
  RANGEES <-- 15

VARIABLES
  nbDePlaces : entier
  rangees : entier
  debutColonne : entier
  valide : booléen

DEBUT
  Afficher "Combien de places voulez-vous annuler ?"
  nbDePlaces <-- Saisir

  TANT QUE VRAI FAIRE
    Afficher "Rangée (1 à", RANGEES, ") : "
    rangees <-- Saisir

    Afficher "Numéro de la première colonne (1 à", COLONNES - nbDePlaces + 1, ") : "
    debutColonne <-- Saisir

    // Validation des places réservées
    valide <-- VRAI
    POUR i DE 0 A nbDePlaces - 1 FAIRE
      SI salle[rangees][debutColonne + i] = 'L' ALORS
        valide <-- FAUX
        QUITTER BOUCLE
      FIN SI
    FIN POUR

    SI valide = VRAI ALORS
      // Annulation des réservations
      POUR i DE 0 A nbDePlaces - 1 FAIRE
        salle[rangees][debutColonne + i] <-- 'L'
      FIN POUR
      Afficher "Les", nbDePlaces, "places ont été annulées avec succès."
      QUITTER la boucle
    SINON
      Afficher "Une ou plusieurs places dans le lot ne sont pas réservées. Veuillez entrer une position correcte."
    FIN SI
  FIN TANT QUE
FIN

## afficherReservation
CONSTANTES 

VARIABLES
 pReserver : Boolean
 j : entier
 i : entier

DEBUT
  i <-- 0
  j <-- 0
  POUR i  ALLANT DE 1 A COLONNES
    Afficher i, " "
    POUR j ALLANT DE 1 A RANGEES
      Afficher salle[i][j], " "
    FIN POUR
  FIN POUR
FIN

## sauvegardeReservations
// Sauvegarder l'état des réservations dans un fichier
  static void sauvegarderReservations(char[][] salle) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
      for (int i = 0; i < ROWS; i++) {
        for (int j = 0; j < COLS; j++) {
          writer.write(salle[i][j]);
        }
      writer.newLine();
      }
    } catch (IOException e) {
      System.out.println("Erreur lors de la sauvegarde des réservations : " + e.getMessage());
    }
  }











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




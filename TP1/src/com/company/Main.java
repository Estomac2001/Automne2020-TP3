/**
 * Objectif: Un jeu de nombre mystère consiste à trouver un nombre entre 1 et 99, sélectionné au hasard, selon un nombre d’essais limités à cinq.
 * @autor Thomas Laporte
 * Session A2020 - 06/10/2020
 */
package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        int nbAleatoire = rand.nextInt(99) + 1; //entier généré aléatoirement
        int nbJoueur; //Entier essayé par le joueur
        int nbEssai = 0; //Nombre d'essai
        int nbMin = 0; //Entier minimal (exclus)
        int nbMax = 100; //Entier maximal (exclus)

        System.out.println("Vous devez trouver un nombre généré aléatoirement entre 1 et 99 (inclusivement). Vous avez cinq essais.");

        do {
            nbEssai++;
            System.out.print("(" + nbEssai + "/5) " + nbMin + " < ? < " + nbMax + ": ");
            nbJoueur = scan.nextInt();

            if (nbJoueur < nbAleatoire)
                nbMin = nbJoueur;
            else
                nbMax = nbJoueur;

        } while(nbEssai < 5 && nbJoueur != nbAleatoire);

        if (nbJoueur == nbAleatoire)
            System.out.println("Félicitation, vous avez résussi à trouver le nombre aléatoire!");
        else
            System.out.println("Meilleure chance la prochaine fois! Le nombre était " + nbAleatoire + ".");

        scan.close();
    }
}
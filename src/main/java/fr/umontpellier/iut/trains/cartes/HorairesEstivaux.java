package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Bouton;
import fr.umontpellier.iut.trains.Joueur;

import java.util.ArrayList;
import java.util.List;

public class HorairesEstivaux extends CarteRouge {
    public HorairesEstivaux() {
        super("Horaires estivaux",3, 0);
    }

    @Override
    public void faireAction(Joueur joueur, Carte carteJouee) {
        List<String> listeChoix = new ArrayList<>();
        listeChoix.add("oui");
        listeChoix.add("non");
        List<Bouton> boutons = new ArrayList<>();
        boutons.add(new Bouton("Écarter la carte", "oui"));
        boutons.add(new Bouton("Ne rien faire", "non"));
        String choix = joueur.choisir("Voulez vous écarter la carte et recevoir 3¥ ou ne rien faire ?", listeChoix, boutons, false);
        if (choix.equals("oui")) {
            joueur.getJeu().log("Vous avez écarté la carte");
            joueur.addArgent(3);
            joueur.enleverCarteEnJeu(this);
            joueur.ecarteCarte(this);
        }
        else {
            joueur.getJeu().log("Vous avez choisi de ne rien faire");
        }
    }
}

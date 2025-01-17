package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

import java.util.ArrayList;
import java.util.List;

public class TrainPostal extends CarteRouge {
    public TrainPostal() {
        super("Train postal",4,1);
        addCategorie(CategoriesCarte.BLEU);
    }

    @Override
    public void faireAction(Joueur joueur, Carte carteJouee) {
        List<String> choix = new ArrayList<>();
        for (Carte carte : joueur.getMain()) {
            choix.add(carte.getNom());
        }
        String choisit = joueur.choisir("Choisissez une carte à défausser ou rien pour passer", choix, null, true);
        while(!choisit.isEmpty()) {
            joueur.defausserCarte(joueur.getMain().getCarte(choisit));
            choix.remove(choisit);
            joueur.getJeu().log("Vous avez défaussé "+ choisit);
            joueur.addArgent(1);
            choisit = joueur.choisir("Choisissez une carte à défausser ou rien pour passer", choix, null, true);
        }
    }
}

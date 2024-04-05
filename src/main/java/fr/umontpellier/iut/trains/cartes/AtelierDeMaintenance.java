package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

import java.util.ArrayList;
import java.util.List;

public class AtelierDeMaintenance extends CarteRouge {
    public AtelierDeMaintenance() {
        super("Atelier de maintenance", 5, 0);
    }

    @Override
    public void faireAction(Joueur joueur) {
        List<String> choix = new ArrayList<>();
        for (Carte carte : joueur.getMain()) {
            if (carte.getCategorie().contains(CategoriesCarte.BLEU)) choix.add(carte.getNom());
        }
        Carte train = joueur.getMain().getCarte(joueur.choisir("Choisissez votre carte Train", choix, null, false));
        if(train != null) {
            Carte carte = joueur.getJeu().prendreDansLaReserve(train.getNom());
            if (carte != null) {
                joueur.addCarteRecue(carte);
            }
        }
    }
}

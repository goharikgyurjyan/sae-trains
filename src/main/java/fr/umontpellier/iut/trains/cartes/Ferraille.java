package fr.umontpellier.iut.trains.cartes;

import fr.umontpellier.iut.trains.Joueur;

public class Ferraille extends Carte {
    public Ferraille() {
        super("Ferraille", 0);
        addCategorie(CategoriesCarte.GRIS);
    }

    @Override
    public void jouerCarte(Joueur Joueur) {}
}

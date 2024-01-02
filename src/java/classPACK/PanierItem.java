package classPACK;

import beans.Produit;


public class PanierItem {
    private Produit produit;
    private int quantite;

    public PanierItem(Produit produit) {
        this.produit = produit;
        this.quantite = 1; // Initialiser la quantité à 1 lors de l'ajout du produit au panier
    }

    public Produit getProduit() {
        return produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void incrementerQuantite() {
        this.quantite++;
    }

    public void decrementerQuantite() {
        if (quantite > 1) {
            this.quantite--;
        }
    }

    public double getMontant() {
        //return quantite * produit.getPrix();
        return 0;
        //return quantite * produit.getPrix();
    }
}

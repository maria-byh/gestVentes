package classPACK;

import beans.Produit;
import classPACK.PanierItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Panier implements Serializable {

    private List<PanierItem> panierItems;

    public Panier() {
        this.panierItems = new ArrayList<>();
    }

    public List<PanierItem> getPanierItems() {
        return panierItems;
    }

    public void ajouterProduit(Produit produit) {
        // Vérifier si le produit est déjà dans le panier
        boolean produitExiste = panierItems.stream().anyMatch(item -> item.getProduit().getLibelle() == produit.getLibelle());

        // Ajouter le produit uniquement s'il n'existe pas encore dans le panier
        if (!produitExiste) {
            PanierItem panierItem = new PanierItem(produit);
            panierItems.add(panierItem);
        }
    }

    public boolean contientProduit(Produit produit) {
        return panierItems.stream().anyMatch(item -> item.getProduit().getLibelle() == produit.getLibelle());
    }

    public void supprimerProduit(Produit produit) {
        panierItems.removeIf(item -> item.getProduit().getLibelle() == produit.getLibelle());
    }

    public void viderPanier() {
        panierItems.clear();
    }

    public double calculerMontantTotal() {
        double montantTotal = 0.0;

        for (PanierItem panierItem : panierItems) {
            montantTotal += panierItem.getMontant();
        }

        return montantTotal;
    }

    public void removeProduitById(String productId) {
        panierItems.removeIf(item -> item.getProduit().getLibelle() == productId);
    }
    // Dans la classe Panier

    public void updateQuantite(String productId, String operation) {
        PanierItem panierItem = getPanierItem(productId);

        if (panierItem != null) {
            if ("increment".equals(operation)) {
                panierItem.incrementerQuantite();
            } else if ("decrement".equals(operation)) {
                panierItem.decrementerQuantite();
                if (panierItem.getQuantite() <= 0) {
                    // Si la quantité est inférieure ou égale à zéro, supprimer le produit du panier
                    //supprimerProduit(panierItem.getProduit());
                }
            }
        }
    }

    public PanierItem getPanierItem(String productId) {
        for (PanierItem panierItem : panierItems) {
            if (panierItem.getProduit().getLibelle() == productId) {
                return panierItem;
            }
        }
        return null;
    }

}

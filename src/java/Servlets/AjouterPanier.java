package Servlets;

import beans.Produit;
import classPACK.Panier;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AjouterPanier")
public class AjouterPanier extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Produit produit = new Produit();
        // Récupérer l'ID du produit depuis la requête
        String productLabel = request.getParameter("productLabel");
        // Récupérer le produit correspondant à l'ID depuis la base de données (ou d'où vous le stockez)
        //ProduitDAO produitDAO = new ProduitDAO();
        //Produit produit = produitDAO.getProduitById(productId);
        
        if (produit != null) {
            // Récupérer la session
            HttpSession session = request.getSession();
            
            // Récupérer le panier depuis la session
            Panier panier = (Panier) session.getAttribute("panier");
            
            if (panier == null) {
                
                // Si le panier n'existe pas encore, le créer
                panier = new Panier();
                session.setAttribute("panier", panier);
            }
            
            // Ajouter le produit au panier
            panier.ajouterProduit(produit);
            
            
            
            // Mettre à jour la quantité totale dans la session
            int quantiteTotale = panier.getPanierItems().size();
            session.setAttribute("cmp", quantiteTotale);
        }
        // Rediriger vers la page du catalogue
        response.sendRedirect("/");
    }
}

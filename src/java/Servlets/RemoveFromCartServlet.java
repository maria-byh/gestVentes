package Servlets;


import classPACK.Panier;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RemoveFromCart")
public class RemoveFromCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer l'ID du produit à supprimer du panier
       int productId = Integer.parseInt(request.getParameter("productId"));

        // Récupérer le panier depuis la session
        HttpSession session = request.getSession();
        Panier panier = (Panier) session.getAttribute("panier");

        if (panier != null) {
            // Supprimer le produit du panier
          //  panier.removeProduitById(productId);
        }

        // Mettre à jour la session avec le panier modifié
        session.setAttribute("panier", panier);
    }
}

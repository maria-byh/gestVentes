package Servlets;

import classPACK.Panier;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ModifierQuantite")
public class ModifierQuantiteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Récupérer les paramètres de la requête
            int productId = Integer.parseInt(request.getParameter("productId"));
            String operation = request.getParameter("operation");

            // Récupérer la session
            HttpSession session = request.getSession();

            // Récupérer le panier depuis la session
            Panier panier = (Panier) session.getAttribute("panier");

            if (panier != null) {
                // Mettre à jour la quantité du produit dans le panier
                //panier.updateQuantite(productId, operation);
                session.setAttribute("panier", panier);

                // Répondre à la requête AJAX avec la nouvelle quantité et le montant total
                response.setContentType("application/json");
                PrintWriter out = response.getWriter();

                // String jsonResponse = gson.toJson(panier.getPanierItem(productId));
                //out.print(jsonResponse);
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}

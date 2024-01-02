package Servlets;

import classPACK.Panier;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/panier")
public class AfficherPanierServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérez le panier depuis la session
        HttpSession session = request.getSession();
        List<Panier> panier = (List<Panier>) session.getAttribute("panier");

        // Mettez le panier à disposition dans la requête pour la JSP
        request.setAttribute("panier", panier);

        // Redirigez vers la page JSP d'affichage du panier
        RequestDispatcher dispatcher = request.getRequestDispatcher("panier.jsp");
        dispatcher.forward(request, response);
    }
}

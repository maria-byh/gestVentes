package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if ("vendeur".equals(username) && "motdepasse".equals(password)) {
            // L'utilisateur est un vendeur, vous pouvez rediriger vers la page du vendeur
            response.sendRedirect("ajouterProduit.jsp");
        } else {
            
            request.setAttribute("erreurMessage", "Nom d'utilisateur ou mot de passe incorrect");

            // Vous pouvez rediriger vers la page d'accueil ou rester sur la page de login
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }

}

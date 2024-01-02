package Servlets;

import bdd.Noms;
import beans.Produit;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Noms tableNoms = new Noms();
        request.setAttribute("produits", tableNoms.recupererProduits());
        this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Produit produit = new Produit();
        produit.setLibelle(request.getParameter("libelle"));
        produit.setPhoto(request.getParameter("photo"));
        produit.setPrix(request.getParameter("prix"));
        produit.setQts(request.getParameter("qts"));
        
        Noms tableNoms = new Noms();
        tableNoms.ajouterProduit(produit);
        request.setAttribute("produits", tableNoms.recupererProduits());
        this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

}

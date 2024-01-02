package Servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet(name = "AjouterProduit", urlPatterns = {"/AjouterProduit"})
@MultipartConfig(maxFileSize = 1024 * 1024 * 5) 
public class AjouterProduit extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         // Récupérer les données du formulaire
        String libelle = request.getParameter("libelle");
        double prix = Double.parseDouble(request.getParameter("prix"));
        int qts = Integer.parseInt(request.getParameter("qts"));
        Part filePart = request.getPart("image");
        
        // Enregistrement de l'image dans le dossier 'images' dans le répertoire du projet
        String uploadPath = request.getServletContext().getRealPath("/images");
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();

        // Utilisez une méthode pour générer un nom de fichier unique pour éviter les collisions
        String fileName = generateUniqueFileName() + ".png"; // Utilisez l'extension du fichier appropriée
        String filePath = uploadPath + File.separator + fileName;
        filePart.write(filePath);

        // Enregistrement des données dans la base de données
        Connection conn = null;
        Statement stat = null;
        ResultSet reset = null;
        try {
            // Utilisez votre logique pour enregistrer le produit dans la base de données
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestventes", "", "");
            stat = conn.createStatement();
            String sql = "INSERT INTO produit (libelle, photo, prix, qts) VALUES (?, ?, ?, ?)";
            reset = stat.executeQuery(sql);
            
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, libelle);
                statement.setString(2, fileName); // Utilisez le nom de fichier, pas le chemin complet
                statement.setDouble(3, prix);
                statement.setInt(4, qts);
                statement.executeUpdate();
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Redirection vers la page du catalogue
        response.sendRedirect("/");
    
    
    }
    
    private String generateUniqueFileName() {
    return "product_" + System.currentTimeMillis();
}
   
}

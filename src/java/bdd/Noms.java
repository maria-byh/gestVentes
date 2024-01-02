package bdd;

import beans.Produit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class Noms {
    private Connection connexion;
    public List<Produit> recupererProduits(){
        List<Produit> produits = new ArrayList<Produit>();
        Statement statement = null;
        ResultSet resultat = null;
        
        loadDatabase();
        
        try {
            statement = connexion.createStatement();
            
            resultat = statement.executeQuery("SELECT libelle, photo, prix, qts FROM produit;");
           
            while(resultat.next()) {
                String libelle;
                libelle = resultat.getString("libelle");
                String photo;
                photo= resultat.getString("photo");
                String prix;
                prix = resultat.getString("prix");
                String qts;
                qts= resultat.getString("qts");
                
                Produit produit = new Produit();
                produit.setLibelle(libelle);
                produit.setPhoto(photo);
                produit.setPrix(prix);
                produit.setQts(qts);
                
                produits.add(produit);
            }
        } catch (SQLException e) {
            
        } finally {
            try {
                if(resultat != null) 
                    resultat.close();
                if(statement != null) 
                    statement.close();
                if(connexion != null) 
                    connexion.close();
            }catch (SQLException e) {
            
            }
        }
        
        return produits;
    }
    
    private void loadDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e) {
        }
        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestventes", "", "");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void ajouterProduit(Produit produit) {
        loadDatabase();
        
        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO produit(libelle, photo, prix, qts) VALUES(?,?,?,?);");
            preparedStatement.setString(1, produit.getLibelle());
            preparedStatement.setString(2, produit.getPhoto());
            preparedStatement.setString(3, produit.getPrix());
            preparedStatement.setString(4, produit.getQts());
            
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

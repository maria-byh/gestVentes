package beans;

public class Produit {
    private int id;
    private String libelle;
    private String photo;
    private String prix;
    private String qts;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getLibelle() {
        return libelle;
    }
    
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    public String getPhoto() {
        return photo;
    }
    
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    public String getPrix() {
        return prix;
    }
    
    public void setPrix(String prix) {
        this.prix = prix;
    }
    
    public String getQts() {
        return qts;
    }
    
    public void setQts(String qts) {
        this.qts = qts;
    }
}

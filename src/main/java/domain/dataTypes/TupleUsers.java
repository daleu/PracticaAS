package domain.dataTypes;


public class TupleUsers {

    private String username;
    private String nom;
    private String email;

    public TupleUsers (String username, String nom, String email){
        this.username = username;
        this.nom = nom;
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

}

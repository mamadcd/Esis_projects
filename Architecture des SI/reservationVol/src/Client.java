import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Classe représentant un client
class Client {
    private int idClient;
    private String nom;
    private String prenom;
    private String email;
    private Date dateNaissance;
    private List<Reservation> reservations;

    public Client(int idClient, String nom, String prenom, String email, Date dateNaissance) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateNaissance = dateNaissance;
        this.reservations = new ArrayList<>();
    }

    public int getIdClient() {
        return idClient;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void ajouterReservation(Reservation reservation) {
        reservations.add(reservation);
    }
}

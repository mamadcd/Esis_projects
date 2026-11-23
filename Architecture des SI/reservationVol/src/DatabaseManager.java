import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    private static final String URL = "jdbc:mysql://localhost:3306/reservationvol";
    private static final String USER = "root";
    private static final String PASSWORD = "";


    // Méthode pour établir une connexion
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Insérer une nouvelle compagnie aérienne
   public void ajouterCompagnieAerienne(Compagnie compagnie) throws SQLException {
        String sql = "INSERT INTO Compagnie (Nom, siegeSocial) VALUES (?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

           // pstmt.setInt(1, compagnie.getIdCompagnie());
            pstmt.setString(1, compagnie.getNom());
            pstmt.setString(2, compagnie.getSiegeSocial());
            pstmt.executeUpdate();
        }
   }

    // Insérer une nouvelle Vol Paris Tunis carthage

    // Méthode pour insérer un vol
    public void ajouterVol(int idCompagnie, int idAeroportDepart, int idAeroportArrivee, String dateHeureDepart, String dateHeureArrivee, boolean isRegulier) throws SQLException {
        String sql = "INSERT INTO Vol (ID_Compagnie, ID_AeroportDepart, ID_AeroportArrivee, DateHeureDepart, DateHeureArrivee, IsRegulier) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idCompagnie);
            pstmt.setInt(2, idAeroportDepart);
            pstmt.setInt(3, idAeroportArrivee);
            pstmt.setString(4, dateHeureDepart);
            pstmt.setString(5, dateHeureArrivee);
            pstmt.setBoolean(6, isRegulier);
            pstmt.executeUpdate();
        }
    }

    // Méthode pour obtenir l'ID d'une compagnie par son nom
    public int obtenirIdCompagnie(String nomCompagnie) throws SQLException {
        String sql = "SELECT ID_Compagnie FROM Compagnie WHERE Nom = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nomCompagnie);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("ID_Compagnie");
                }
            }
        }
        return -1; // Retourne -1 si non trouvé
    }

    // Méthode pour insérer un aéroport
    public void ajouterAeroport(String nom, String ville) throws SQLException {
        String sql = "INSERT INTO Aeroport (Nom, Ville) VALUES (?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nom);
            pstmt.setString(2, ville);
            pstmt.executeUpdate();
        }
    }

    // Méthode pour obtenir l'ID d'un aéroport par son nom
    public int obtenirIdAeroport(String nomAeroport) throws SQLException {
        String sql = "SELECT ID_Aeroport FROM Aeroport WHERE Nom = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nomAeroport);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("ID_Aeroport");
                }
            }
        }
        return -1; // Retourne -1 si non trouvé
    }

    // Exemple : Lire toutes les compagnies aériennes
    public List<Compagnie> lireCompagniesAeriennes() throws SQLException {
        List<Compagnie> compagnies = new ArrayList<>();
        String sql = "SELECT * FROM Compagnie";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Compagnie compagnie = new Compagnie(
                        //rs.getInt("ID_Compagnie"),
                        rs.getString("Nom"),
                        rs.getString("siegeSocial")
                );
                compagnies.add(compagnie);
            }
        }
        return compagnies;
    }

    public List<Vol> lireVols() throws SQLException {
        List<Vol> vols = new ArrayList<>();
        String sql = "SELECT * FROM Vol";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Vol vol = new Vol(
                        rs.getInt("ID_Compagnie"),
                        rs.getInt("ID_AeroportDepart"),
                        rs.getInt("ID_AeroportArrivee"),
                        rs.getString("DateHeureDepart"),
                        rs.getString("DateHeureArrivee"),
                        rs.getBoolean("IsRegulier")

                );
                vols.add(vol);
            }
        }
        return vols;
    }

}

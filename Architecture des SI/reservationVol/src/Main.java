import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public static void main(String[] args) throws SQLException {
    DatabaseManager dbManager = new DatabaseManager();
    try (Connection conn = dbManager.connect()) {
        if (conn != null) {
            System.out.println("Connexion réussie à la base de données!");
        }


        // Une compagnie dont le nom est TRANSAVIA et le siège social est "Paris"
        Compagnie compagnie = new Compagnie( "Transavia", "Paris");

        dbManager.ajouterCompagnieAerienne(compagnie);

        List<Compagnie> compagnies = dbManager.lireCompagniesAeriennes();
        for (Compagnie c : compagnies) {
            System.out.println(STR."\{c.getNom()} \{c.getSiegeSocial()}");
        }

        // Un vol régulier direct ‘’Paris ORLY → Tunis Carthage’’ le mardi à 10h00.

        // Insérer les aéroports
        dbManager.ajouterAeroport( "Paris ORLY", "Paris");
        dbManager.ajouterAeroport( "Tunis Carthage", "Tunis");

        // Obtenir les id
        int idCompagnie = dbManager.obtenirIdCompagnie("TRANSAVIA");
        int idAeroportDepart = dbManager.obtenirIdAeroport("Paris ORLY");
        int idAeroportArrivee = dbManager.obtenirIdAeroport("Tunis Carthage");

        // Insérer le vol en utilisant les id dans le contructeur

        dbManager.ajouterVol(idCompagnie, idAeroportDepart, idAeroportArrivee, "2025-04-08 10:00:00", "2025-04-08 12:00:00", true);

        // Aficher les vols
        List<Vol> vols = dbManager.lireVols();
        for (Vol vol : vols) {
            System.out.println(STR."\{vol.getIdCompangie()}\{vol.getDateHeureDepart()}\{vol.getDateHeureArrivee()}\{vol.getAeroportDepart()}\{vol.getAeroportArrivee()}\{vol.isRegulier()}");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
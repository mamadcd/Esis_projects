
class Aeroport {
    private int idAeroport;
    private String nom;
    private String ville;

    public Aeroport(String nom, String ville) {
        //this.idAeroport = idAeroport;
        this.nom = nom;
        this.ville = ville;
    }

    public int getIdAeroport() {
        return idAeroport;
    }

    public String getNom() {
        return nom;
    }

    public String getVille() {
        return ville;
    }
}

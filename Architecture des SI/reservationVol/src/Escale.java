import java.util.Date;

class Escale {
    private int idEscale;
    private Vol vol;
    private Aeroport aeroport;
    private Date heureArrivee;
    private Date heureDepart;

    public Escale(int idEscale, Vol vol, Aeroport aeroport, Date heureArrivee, Date heureDepart) {
        this.idEscale = idEscale;
        this.vol = vol;
        this.aeroport = aeroport;
        this.heureArrivee = heureArrivee;
        this.heureDepart = heureDepart;
    }

    public int getIdEscale() {
        return idEscale;
    }

    public Vol getVol() {
        return vol;
    }

    public Aeroport getAeroport() {
        return aeroport;
    }

    public Date getHeureArrivee() {
        return heureArrivee;
    }

    public Date getHeureDepart() {
        return heureDepart;
    }
}
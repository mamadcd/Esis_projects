import java.util.Date;

class Reservation {
    private int idReservation;
    private Vol vol;
    private Client client;
    private Passager passager;
    private String code;
    private Date date;
    private String etat;

    public Reservation(int idReservation, Vol vol, Client client, Passager passager, String code, Date date, String etat) {
        this.idReservation = idReservation;
        this.vol = vol;
        this.client = client;
        this.passager = passager;
        this.code = code;
        this.date = date;
        this.etat = etat;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public Vol getVol() {
        return vol;
    }

    public Client getClient() {
        return client;
    }

    public Passager getPassager() {
        return passager;
    }

    public String getCode() {
        return code;
    }

    public Date getDate() {
        return date;
    }

    public String getEtat() {
        return etat;
    }
}
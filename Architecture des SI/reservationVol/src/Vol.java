import java.util.Date;
import java.util.List;

class Vol {
    private int idVol;

    private String dateHeureDepart;
    private String dateHeureArrivee;
    private boolean isOuvert;
    private boolean isRegulier;
    private int aeroportDepart;
    private int aeroportArrivee;


    private int idCompangie;
    private List<Escale> escales;


    public Vol(int idCompagnie, int idAeroportDepart, int idAeroportArrivee, String dateHeureDepart, String dateHeureArrivee, boolean isRegulier) {
        this.idCompangie = idCompagnie;
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
        //this.isOuvert = isOuvert;
        this.isRegulier = isRegulier;
        this.aeroportDepart = idAeroportDepart;
        this.aeroportArrivee = idAeroportArrivee;
    }

    public int getIdVol() {
        return idVol;
    }

    public void setIdVol(int idVol) {
        this.idVol = idVol;
    }

    public int getIdCompangie() {
        return idCompangie;
    }

    public String getDateHeureDepart() {
        return dateHeureDepart;
    }

    public void setDateHeureDepart(String dateHeureDepart) {
        this.dateHeureDepart = dateHeureDepart;
    }

    public String getDateHeureArrivee() {
        return dateHeureArrivee;
    }

    public void setDateHeureArrivee(String dateHeureArrivee) {
        this.dateHeureArrivee = dateHeureArrivee;
    }

    public int getAeroportDepart() {
        return aeroportDepart;
    }

    public void setAeroportDepart(int aeroportDepart) {
        this.aeroportDepart = aeroportDepart;
    }

    public int getAeroportArrivee() {
        return aeroportArrivee;
    }

    public void setAeroportArrivee(int aeroportArrivee) {
        this.aeroportArrivee = aeroportArrivee;
    }


    public boolean isOuvert() {
        return isOuvert;
    }

    public void setOuvert(boolean ouvert) {
        isOuvert = ouvert;
    }

    public boolean isRegulier() {
        return isRegulier;
    }

    public void setRegulier(boolean regulier) {
        isRegulier = regulier;
    }



    public List<Escale> getEscales() {
        return escales;
    }

    public void setEscales(List<Escale> escales) {
        this.escales = escales;
    }

}
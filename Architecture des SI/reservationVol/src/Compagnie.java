import java.util.ArrayList;
import java.util.List;



    class Compagnie {
        private int idCompagnie;
        private String nom;
        private String siegeSocial;
        private List<Vol> vols;

        public Compagnie( String nom, String siegeSocial) {
            //this.idCompagnie = idCompagnie
            this.nom = nom;
            this.siegeSocial = siegeSocial;

        }

        public int getIdCompagnie() {
            return idCompagnie;
        }

        public String getNom() {
            return nom;
        }
        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getSiegeSocial() {
            return siegeSocial;
        }

        public List<Vol> getVols() {
            return vols;
        }

        public void ajouterVol(Vol vol) {
            vols.add(vol);
        }
    }




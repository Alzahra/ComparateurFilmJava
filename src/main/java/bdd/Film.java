package bdd;

import java.sql.Date;
import java.util.Arrays;

/**
 * Représente un film, contient ses différents caractèristiques.
 */
public class Film {
    private final int id;
    private String titre;
    private int duree;
    private float note;
    private float prix;
    private Date dateSortie;
    private String genre;
    private String synopsis;
    private String[] acteurs;

    public Film(int id, String titre, int duree, float note, float prix, Date dateSortie, String genre, String synopsis, String[] acteurs) {
        this.id = id;
        this.titre = titre;
        this.duree = duree;
        this.note = note;
        this.prix = prix;
        this.dateSortie = dateSortie;
        this.genre = genre;
        this.synopsis = synopsis;
        this.acteurs = acteurs;
    }

    public int getId() { return id; }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String[] getActeurs() {
        return acteurs;
    }

    public void setActeurs(String[] acteurs) {
        this.acteurs = acteurs;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Film) {
            return ((Film) obj).titre.equals(this.titre);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", duree=" + duree +
                ", note=" + note +
                ", prix=" + prix +
                ", dateSortie=" + dateSortie +
                ", genre='" + genre + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", acteurs=" + Arrays.toString(acteurs) +
                '}';
    }
}

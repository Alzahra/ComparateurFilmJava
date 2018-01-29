package bdd;

import java.util.Date;
import java.util.List;

public class Film {
    private String titre;
    private int duree;
    private float note;
    private float prix;
    private Date dateSortie;
    private String genre; // TODO : je sais plus si on a un seul genre par film ou plusieurs (du coup mettre une list)
    private String synopsis;
    private List<String> acteurs;

    public Film(String titre, int duree, float note, float prix, Date dateSortie, String genre, String synopsis, List<String> acteurs) {
        this.titre = titre;
        this.duree = duree;
        this.note = note;
        this.prix = prix;
        this.dateSortie = dateSortie;
        this.genre = genre;
        this.synopsis = synopsis;
        this.acteurs = acteurs;
    }

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

    public List<String> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<String> acteurs) {
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
        return titre;
    }
}

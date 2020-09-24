package DianaG.licenta.entities;

import java.util.ArrayList;
import java.util.List;

public class TvShow {
    private List<Season> episodes;
    private  boolean adult;
    private  String backdrop_path;
    private  Belongs_to_collection belongs_to_collection;
    private  long budget;
    private  double popularity;
    private  String poster_path;
    private  List<Production_company> production_companies;
    private List<Integer>genre_ids= new ArrayList<>();


    public TvShow(List<Season> episodes, boolean adult, String backdrop_path, Belongs_to_collection belongs_to_collection, long budget, double popularity, String poster_path, List<Production_company> production_companies, List<Integer> genre_ids) {
        this.episodes = episodes;
        this.adult = adult;
        this.backdrop_path = backdrop_path;
        this.belongs_to_collection = belongs_to_collection;
        this.budget = budget;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.production_companies = production_companies;
        this.genre_ids = genre_ids;
    }

    public List<Season> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Season> episodes) {
        this.episodes = episodes;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public Belongs_to_collection getBelongs_to_collection() {
        return belongs_to_collection;
    }

    public void setBelongs_to_collection(Belongs_to_collection belongs_to_collection) {
        this.belongs_to_collection = belongs_to_collection;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public List<Production_company> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(List<Production_company> production_companies) {
        this.production_companies = production_companies;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }
}

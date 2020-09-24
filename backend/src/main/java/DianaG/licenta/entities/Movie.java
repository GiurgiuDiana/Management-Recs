package DianaG.licenta.entities;


import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class Movie {
    private  boolean adult;
    private  String backdrop_path;
    private  Belongs_to_collection belongs_to_collection;
    private  long budget;
    private List<Genre> genres;
    private  String homepage;
    private  int id;
    private  String imdb_id;
    private  String original_language;
    private  String original_title;
    private  String overview;
    private  double popularity;
    private  String poster_path;
    private  List<Production_company> production_companies;
    private List< Production_country> production_countries;
    private  String release_date;
    private  long revenue;
    private  long runtime;
    private  List<Spoken_language> spoken_languages;
    private  String status;
    private  String tagline;
    private  String title;
    private  boolean video;
    private  double vote_average;
    private  int vote_count;

//    @JsonCreator
//    public Movie(@JsonProperty("adult") boolean adult, @JsonProperty("backdrop_path") String backdrop_path, @JsonProperty("belongs_to_collection") Belongs_to_collection belongs_to_collection, @JsonProperty("budget") long budget, @JsonProperty("genres")   List<Genre> genres, @JsonProperty("homepage") String homepage, @JsonProperty("id") int id, @JsonProperty("imdb_id") String imdb_id, @JsonProperty("original_language") String original_language, @JsonProperty("original_title") String original_title, @JsonProperty("overview") String overview, @JsonProperty("popularity") double popularity, @JsonProperty("poster_path") String poster_path, @JsonProperty("production_companies")List< Production_company> production_companies, @JsonProperty("production_countries") List< Production_country> production_countries, @JsonProperty("release_date") String release_date, @JsonProperty("revenue") long revenue, @JsonProperty("runtime") long runtime, @JsonProperty("spoken_languages") List<Spoken_language> spoken_languages, @JsonProperty("status") String status, @JsonProperty("tagline") String tagline, @JsonProperty("title") String title, @JsonProperty("video") boolean video, @JsonProperty("vote_average") double vote_average, @JsonProperty("vote_count") int vote_count) {
//        this.adult = adult;
//        this.backdrop_path = backdrop_path;
//        this.belongs_to_collection = belongs_to_collection;
//        this.budget = budget;
//        this.genres = genres;
//        this.homepage = homepage;
//        this.id = id;
//        this.imdb_id = imdb_id;
//        this.original_language = original_language;
//        this.original_title = original_title;
//        this.overview = overview;
//        this.popularity = popularity;
//        this.poster_path = poster_path;
//        this.production_companies = production_companies;
//        this.production_countries = production_countries;
//        this.release_date = release_date;
//        this.revenue = revenue;
//        this.runtime = runtime;
//        this.spoken_languages = spoken_languages;
//        this.status = status;
//        this.tagline = tagline;
//        this.title = title;
//        this.video = video;
//        this.vote_average = vote_average;
//        this.vote_count = vote_count;
//    }

    public Movie() {
    }

    public Movie(int id, String imdb_id, String original_title, String title, double vote_average) {
        this.id = id;
        this.imdb_id = imdb_id;
        this.original_title = original_title;
        this.title = title;
        this.vote_average = vote_average;
    }

    public Movie(boolean adult, String backdrop_path, Belongs_to_collection belongs_to_collection, long budget, List<Genre> genres, String homepage, int id, String imdb_id, String original_language, String original_title, String overview, double popularity, String poster_path, List<Production_company> production_companies, List< Production_country> production_countries, String release_date, long revenue, long runtime, List<Spoken_language>  spoken_languages, String status, String tagline, String title, boolean video, double vote_average, int vote_count) {
        this.adult = adult;
        this.backdrop_path = backdrop_path;
        this.belongs_to_collection = belongs_to_collection;
        this.budget = budget;
        this.genres = genres;
        this.homepage = homepage;
        this.id = id;
        this.imdb_id = imdb_id;
        this.original_language = original_language;
        this.original_title = original_title;
        this.overview = overview;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.production_companies = production_companies;
        this.production_countries = production_countries;
        this.release_date = release_date;
        this.revenue = revenue;
        this.runtime = runtime;
        this.spoken_languages = spoken_languages;
        this.status = status;
        this.tagline = tagline;
        this.title = title;
        this.video = video;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
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

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
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

    public List< Production_country>getProduction_countries() {
        return production_countries;
    }

    public void setProduction_countries(List< Production_country> production_countries) {
        this.production_countries = production_countries;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public long getRevenue() {
        return revenue;
    }

    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }

    public long getRuntime() {
        return runtime;
    }

    public void setRuntime(long runtime) {
        this.runtime = runtime;
    }

    public  List<Spoken_language>  getSpoken_languages() {
        return spoken_languages;
    }

    public void setSpoken_languages( List<Spoken_language>  spoken_languages) {
        this.spoken_languages = spoken_languages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public long getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }
}

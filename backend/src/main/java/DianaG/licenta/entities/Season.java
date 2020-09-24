package DianaG.licenta.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component

public class Season {

    private  String _id;
    private  String original_name;
    private List<Integer>genre_ids= new ArrayList<>();
    private long popularity;
    private  String air_date;
    private List<Episode> episodes;
    private List<Production_country> production_countryList;
    private  String name;
    private  String overview;
    private  long id;
    private  String poster_path;
    private  long season_number;
    private long vote_count;
    private long vote_average;


//
//    @JsonCreator
//    public Season(@JsonProperty("_id") String _id, @JsonProperty("air_date") String air_date, @JsonProperty("episodes") Episode[] episodes, @JsonProperty("name") String name, @JsonProperty("overview") String overview, @JsonProperty("id") long id, @JsonProperty("poster_path") String poster_path, @JsonProperty("season_number") long season_number){
//        this._id = _id;
//        this.air_date = air_date;
//        this.episodes = episodes;
//        this.name = name;
//        this.overview = overview;
//        this.id = id;
//        this.poster_path = poster_path;
//        this.season_number = season_number;
//    }


    public Season() {
    }

    public Season(String _id, String air_date,List<Episode> episodes, String name, String overview, long id, String poster_path, long season_number) {
        this._id = _id;
        this.air_date = air_date;
        this.episodes = episodes;
        this.name = name;
        this.overview = overview;
        this.id = id;
        this.poster_path = poster_path;
        this.season_number = season_number;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getAir_date() {
        return air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public long getSeason_number() {
        return season_number;
    }

    public void setSeason_number(long season_number) {
        this.season_number = season_number;
    }
}

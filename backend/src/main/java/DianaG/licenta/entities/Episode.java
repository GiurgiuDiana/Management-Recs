package DianaG.licenta.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class Episode {
    private String air_date;
    private Crew crew[];
    private long episode_number;
    private Guest_star guest_stars[];
    private String name;
    private String overview;
    private long id;
    private String production_code;
    private long season_number;
    private String still_path;
    private double vote_average;
    private long vote_count;

//    @JsonCreator
//    public Episode(@JsonProperty("air_date") String air_date, @JsonProperty("crew") Crew[] crew, @JsonProperty("episode_number") long episode_number, @JsonProperty("guest_stars") Guest_star[] guest_stars, @JsonProperty("name") String name, @JsonProperty("overview") String overview, @JsonProperty("id") long id, @JsonProperty("production_code") String production_code, @JsonProperty("season_number") long season_number, @JsonProperty("still_path") String still_path, @JsonProperty("vote_average") double vote_average, @JsonProperty("vote_count") long vote_count) {
//        this.air_date = air_date;
//        this.crew = crew;
//        this.episode_number = episode_number;
//        this.guest_stars = guest_stars;
//        this.name = name;
//        this.overview = overview;
//        this.id = id;
//        this.production_code = production_code;
//        this.season_number = season_number;
//        this.still_path = still_path;
//        this.vote_average = vote_average;
//        this.vote_count = vote_count;
//    }


    public Episode() {
    }

    public Episode(String air_date, Crew[] crew, long episode_number, Guest_star[] guest_stars, String name, String overview, long id, String production_code, long season_number, String still_path, double vote_average, long vote_count) {
        this.air_date = air_date;
        this.crew = crew;
        this.episode_number = episode_number;
        this.guest_stars = guest_stars;
        this.name = name;
        this.overview = overview;
        this.id = id;
        this.production_code = production_code;
        this.season_number = season_number;
        this.still_path = still_path;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }

    public String getAir_date() {
        return air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public Crew[] getCrew() {
        return crew;
    }

    public void setCrew(Crew[] crew) {
        this.crew = crew;
    }

    public long getEpisode_number() {
        return episode_number;
    }

    public void setEpisode_number(long episode_number) {
        this.episode_number = episode_number;
    }

    public Guest_star[] getGuest_stars() {
        return guest_stars;
    }

    public void setGuest_stars(Guest_star[] guest_stars) {
        this.guest_stars = guest_stars;
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

    public String getProduction_code() {
        return production_code;
    }

    public void setProduction_code(String production_code) {
        this.production_code = production_code;
    }

    public long getSeason_number() {
        return season_number;
    }

    public void setSeason_number(long season_number) {
        this.season_number = season_number;
    }

    public String getStill_path() {
        return still_path;
    }

    public void setStill_path(String still_path) {
        this.still_path = still_path;
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

    public void setVote_count(long vote_count) {
        this.vote_count = vote_count;
    }
}

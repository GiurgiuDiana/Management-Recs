package DianaG.licenta.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class Guest_star {
    private  long id;
    private  String name;
    private  String credit_id;
    private  String character;
    private  long order;
    private  long gender;
    private  String profile_path;

//    @JsonCreator
//    public Guest_star(@JsonProperty("id") long id, @JsonProperty("name") String name, @JsonProperty("credit_id") String credit_id, @JsonProperty("character") String character, @JsonProperty("order") long order, @JsonProperty("gender") long gender, @JsonProperty("profile_path") String profile_path){
//        this.id = id;
//        this.name = name;
//        this.credit_id = credit_id;
//        this.character = character;
//        this.order = order;
//        this.gender = gender;
//        this.profile_path = profile_path;
//    }


    public Guest_star() {
    }

    public Guest_star(long id, String name, String credit_id, String character, long order, long gender, String profile_path) {
        this.id = id;
        this.name = name;
        this.credit_id = credit_id;
        this.character = character;
        this.order = order;
        this.gender = gender;
        this.profile_path = profile_path;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCredit_id() {
        return credit_id;
    }

    public void setCredit_id(String credit_id) {
        this.credit_id = credit_id;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }

    public long getGender() {
        return gender;
    }

    public void setGender(long gender) {
        this.gender = gender;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }
}


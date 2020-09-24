package DianaG.licenta.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component

public class Production_country {
    private  String iso_3166_1;
    private  String name;

//    @JsonCreator
//    public Production_country(@JsonProperty("iso_3166_1") String iso_3166_1, @JsonProperty("name") String name){
//        this.iso_3166_1 = iso_3166_1;
//        this.name = name;
//    }


    public Production_country() {
    }

    public Production_country(String iso_3166_1, String name) {
        this.iso_3166_1 = iso_3166_1;
        this.name = name;
    }

    public String getIso_3166_1() {
        return iso_3166_1;
    }

    public void setIso_3166_1(String iso_3166_1) {
        this.iso_3166_1 = iso_3166_1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

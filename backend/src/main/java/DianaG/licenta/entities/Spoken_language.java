package DianaG.licenta.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component

public class Spoken_language {
    public  String iso_639_1;
    public  String name;

//    @JsonCreator
//    public Spoken_language(@JsonProperty("iso_639_1") String iso_639_1, @JsonProperty("name") String name){
//        this.iso_639_1 = iso_639_1;
//        this.name = name;
//    }

    public Spoken_language(String iso_639_1, String name) {
        this.iso_639_1 = iso_639_1;
        this.name = name;
    }

    public Spoken_language() {
    }

    public String getIso_639_1() {
        return iso_639_1;
    }

    public void setIso_639_1(String iso_639_1) {
        this.iso_639_1 = iso_639_1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

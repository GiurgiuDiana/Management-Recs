package DianaG.licenta.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component

public class Production_company {
    private  long id;
    private  String name;
    private  String origin_country;

//    @JsonCreator
//    public Production_company(@JsonProperty("id") long id, @JsonProperty("name") String name, @JsonProperty("origin_country") String origin_country){
//        this.id = id;
//        this.name = name;
//        this.origin_country = origin_country;
//    }

    public Production_company() {
    }

    public Production_company(long id, String name, String origin_country) {
        this.id = id;
        this.name = name;
        this.origin_country = origin_country;
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

    public String getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(String origin_country) {
        this.origin_country = origin_country;
    }
}


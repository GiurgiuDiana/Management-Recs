package DianaG.licenta.entities;

import org.springframework.stereotype.Component;

@Component
public class Review {
    private int id;
    private int rate;
    private int imdb_id;


    public Review(int id, int rate, int imdb_id) {
        this.id = id;
        this.rate = rate;
        this.imdb_id = imdb_id;
    }

    public Review() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(int imdb_id) {
        this.imdb_id = imdb_id;
    }
}

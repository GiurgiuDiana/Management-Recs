package DianaG.licenta.entities;

public class Rating {
    private int rating;
    private int id;
    private String username;
    private String movieID;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public Rating(int rating, int id, String username, String movieID) {
        this.rating = rating;
        this.id = id;
        this.username = username;
        this.movieID = movieID;
    }

    public Rating() {
    }
}

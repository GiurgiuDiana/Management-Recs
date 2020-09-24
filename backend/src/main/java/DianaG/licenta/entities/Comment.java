package DianaG.licenta.entities;

import org.springframework.stereotype.Component;

@Component

public class Comment {
    private String comment;
    private int id;
    private String username;
    private String movieID;

    public Comment() {
    }

    public Comment(String comment, int id, String username, String movieID) {
        this.comment = comment;
        this.id = id;
        this.username = username;
        this.movieID = movieID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
}

package DianaG.licenta.entities;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class UserRatings {
    private String username;
    private List<Rating> ratingsList= new ArrayList<>();

    public UserRatings() {
    }

    public UserRatings(String username, List<Rating> ratingsList) {
        this.username = username;
        this.ratingsList = ratingsList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Rating> getratingsList() {
        return ratingsList;
    }

    public void setratingsList(List<Rating> ratingsList) {
        this.ratingsList = ratingsList;
    }
    public void addRating(Rating fave)
    {
        this.ratingsList.add(fave);
    }
    public void deleteRating(Rating m) {
        for(int i=0; i<this.ratingsList.size(); i++)
        {
            Rating move= this.ratingsList.get(i);
            if(move.getId()==m.getId())
            {
                this.ratingsList.remove(move);
            }

        }//  this.favouritesMovies.remove(m);
    }
}

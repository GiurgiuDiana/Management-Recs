package DianaG.licenta.entities;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class User {

    private String firstName;
    private String lastName;
    private String age;
    private String email;
    private String password;
    //identities are defined by this, it has to be unique(it s like an id)
    private String username;//its the uid that we get from the auth session from register and the auth db( this part is done in frontend react)
    private String description;
    private String address;
    //movies like by the user
    private List<Movie> favouritesMovies=new ArrayList<>();
    //movies seen by the user
    private List<Movie>  watchedMovies=new ArrayList<>();
    //movies recomended to the user
    private List<Movie>  recomendationsMovies=new ArrayList<>();
    private List<UserComments> userComments=new ArrayList<>();
    private List<UserRatings> userReviews=new ArrayList<>();
    private List<TvShow>tv=new ArrayList<>();

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

//    public User(String firstName, String lastName, String age, String username, String description, String address) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
//        this.username = username;
//        this.description = description;
//        this.address = address;
//    }

    public User(String firstName, String lastName, String age, String email, String password, String username, String description, String address, List<Movie> favouritesMovies, List<Movie> watchedMovies, List<Movie> recomendationsMovies, List<UserComments> userComments, List<UserRatings> userReviews) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.username = username;
        this.description = description;
        this.address = address;
        this.favouritesMovies = favouritesMovies;
        this.watchedMovies = watchedMovies;
        this.recomendationsMovies = recomendationsMovies;
        this.userComments=userComments;
        this.userReviews=userReviews;
    }

    public User(String firstName, String lastName, String age, String email, String password, String username, String description, String address, List<Movie> favouritesMovies, List<Movie> watchedMovies, List<Movie> recomendationsMovies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.username = username;
        this.description = description;
        this.address = address;
        this.favouritesMovies = favouritesMovies;
        this.watchedMovies = watchedMovies;
        this.recomendationsMovies = recomendationsMovies;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Movie> getFavouritesMovies() {
        return favouritesMovies;
    }

    public void setFavouritesMovies(List<Movie> favouritesMovies) {
        this.favouritesMovies = favouritesMovies;
    }

    public List<Movie> getWatchedMovies() {
        return watchedMovies;
    }

    public void setWatchedMovies(List<Movie> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }

    public List<Movie> getRecomendationsMovies() {
        return recomendationsMovies;
    }

    public void setRecomendationsMovies(List<Movie> recomendationsMovies) {
        this.recomendationsMovies = recomendationsMovies;
    }

    public List<UserComments> getUserComments() {
        return userComments;
    }

    public void setUserComments(List<UserComments> userComments) {
        this.userComments = userComments;
    }

    public List<UserRatings> getUserReviews() {
        return userReviews;
    }

    public void setUserReviews(List<UserRatings> userReviews) {
        this.userReviews = userReviews;
    }

    public void addToFavourites(Movie fave)
    {
        this.favouritesMovies.add(fave);
    }
    public void cutFromFavourites(Movie m) {
        System.out.println(this.getFavouritesMovies().size()+"favourite");

       for(int i=0; i<this.favouritesMovies.size(); i++)
       {
           Movie move= this.favouritesMovies.get(i);
           if(move.getImdb_id().equalsIgnoreCase(m.getImdb_id()))
           {
               this.favouritesMovies.remove(move);
           }

       }//  this.favouritesMovies.remove(m);
        System.out.println(this.getFavouritesMovies().size()+"faveourite");
    }
    ///Watched list

    public void addToWatched(Movie fave)
    {
        this.watchedMovies.add(fave);
    }
    public void cutFromWatched(Movie m) {
        System.out.println(this.getWatchedMovies().size()+"all the watched movies");

        for(int i=0; i<this.watchedMovies.size(); i++)
        {
            Movie move= this.watchedMovies.get(i);
            if(move.getImdb_id().equalsIgnoreCase(m.getImdb_id()))
            {
                this.watchedMovies.remove(move);
            }

        }//  this.favouritesMovies.remove(m);
        System.out.println(this.getWatchedMovies().size()+"all the watched movies");
    }
    ////Recs lists
    public void addToRecomendations(Movie fave)
    {
        this.recomendationsMovies.add(fave);
    }
    public void cutFromRecomendations(Movie m) {
        System.out.println(this.getRecomendationsMovies().size()+"all the recs movies");

        for(int i=0; i<this.recomendationsMovies.size(); i++)
        {
            Movie move= this.recomendationsMovies.get(i);
            if(move.getImdb_id().equalsIgnoreCase(m.getImdb_id()))
            {
                this.recomendationsMovies.remove(move);
            }

        }//  this.favouritesMovies.remove(m);
        System.out.println(this.getRecomendationsMovies().size()+"all the recs movies");
    }
//    public void addToComments(Integer commentID)
//    {
//        this.userComments.add(commentID);
//    }
//    public void cutFromComments(Integer commentID) {
//        System.out.println(this.getUserComments().size()+"all the comments ");
//
////        for(int i=0; i<this.recomendationsMovies.size(); i++)
////        {
////            Movie move= this.recomendationsMovies.get(i);
////            if(move.getImdb_id().equalsIgnoreCase(comment.getImdb_id()))
////            {
////                this.recomendationsMovies.remove(move);
////            }
////
////        }//
//                this.userComments.remove(commentID);
//        System.out.println(this.getUserComments().size()+"all the comments");
//    }


}

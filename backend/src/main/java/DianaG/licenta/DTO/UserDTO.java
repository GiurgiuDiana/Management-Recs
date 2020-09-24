package DianaG.licenta.DTO;
import java.util.List;

import DianaG.licenta.entities.Movie;

public class UserDTO {

    private String firstName;
    private String lastName;
    private String age;
    //identities are defined by this, it has to be unique(it s like an id)
    private String username;
    private String description;
    private String address;
    //movies like by the user
    private List<Movie> favouritesMovies;
    //movies seen by the user
    private List<Movie>  watchedMovies;
    //movies recomended to the user
    private List<Movie>  recomendationsMovies;

    public UserDTO() {
    }

    public UserDTO(String username) {
        this.username = username;
    }

    public UserDTO(String firstName, String lastName, String age, String username, String description, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.username = username;
        this.description = description;
        this.address = address;
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
}

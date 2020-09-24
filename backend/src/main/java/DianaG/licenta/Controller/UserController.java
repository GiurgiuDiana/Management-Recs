package DianaG.licenta.Controller;

import DianaG.licenta.DTO.ApiResponse;
import DianaG.licenta.Services.FirebaseService;
import DianaG.licenta.entities.Movie;
import DianaG.licenta.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    FirebaseService firebaseService;
    @GetMapping("/getUserDetails")
    public User getExample(@RequestParam() String username) throws InterruptedException, ExecutionException {
        return firebaseService.getUserDetails(username);
    }

    @PostMapping("/createUser")
    public String postExample(@RequestBody User person) throws InterruptedException, ExecutionException {
        return firebaseService.saveUser(person);
    }

    @PutMapping("/updateUser")
    public String putExample(@RequestBody User person) throws InterruptedException, ExecutionException {
        return firebaseService.updateUserDetails(person);
    }

    @DeleteMapping("/deleteUser")
    public String deleteExample(@RequestParam String name) {
        return firebaseService.deleteUser(name);
    }

    @PostMapping("/wishlist")
    public String postWishlistUpdate(@RequestParam("username") String userId,@RequestParam("movieID") String movieId) throws InterruptedException, ExecutionException, IOException {
        System.out.println("username"+userId);
        System.out.println("mm"+movieId);
        return firebaseService.addWishlistObject(userId,movieId);
    }

    @GetMapping()
    public ApiResponse<List<User>> getUsers() throws InterruptedException, ExecutionException {
        return new ApiResponse<>(HttpStatus.OK.value(), "users: ",firebaseService.getUsers());
    }

    @PutMapping("/wishlist")
    public String postWishlistDelete(@RequestParam("username") String userId,@RequestParam("movieID") String movieId) throws InterruptedException, ExecutionException, IOException {
        System.out.println("username"+userId);
        System.out.println("mm"+movieId);
        return firebaseService.deleteWishlistObject(userId,movieId);
    }
    @PostMapping("/watchlist")
    public String postWatchlistUpdate(@RequestParam("username") String userId,@RequestParam("movieID") String movieId) throws InterruptedException, ExecutionException, IOException {
        System.out.println("username"+userId);
        System.out.println("mm"+movieId);
        return firebaseService.addWatchedObject(userId,movieId);
    }

    @PutMapping("/watchlist")
    public String postWatchlistDelete(@RequestParam("username") String userId,@RequestParam("movieID") String movieId) throws InterruptedException, ExecutionException, IOException {
        System.out.println("username"+userId);
        System.out.println("mm"+movieId);
        return firebaseService.deleteWatchedObject(userId,movieId);
    }


}

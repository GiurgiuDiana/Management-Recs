package DianaG.licenta.Controller;
import DianaG.licenta.DTO.ApiResponse;

import DianaG.licenta.Services.FirebaseService;
import DianaG.licenta.entities.Movie;
import DianaG.licenta.entities.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    FirebaseService firebaseService;
    @GetMapping("/getMovieDetails/{imdb_id}")
    public Movie getExample(@PathVariable() String imdb_id) throws InterruptedException, ExecutionException {
        return firebaseService.getMovieDetails(imdb_id);
    }


    @GetMapping()
    public ApiResponse<List<Movie>> getMovies() throws InterruptedException, ExecutionException {
        return new ApiResponse<>(HttpStatus.OK.value(), "movies: ",firebaseService.getMovies());
    }

    @PostMapping("/createMovie")
    public String postExample(@RequestBody Movie person) throws InterruptedException, ExecutionException {
        return firebaseService.saveMovie(person);
    }

    @PutMapping("/updateMovie")
    public String putExample(@RequestBody Movie person) throws InterruptedException, ExecutionException {
        return firebaseService.updateMovieDetails(person);
    }

    @DeleteMapping("/deleteMovie/{imdb_id}")
    public String deleteExample(@PathVariable() String imdb_id) {
        return firebaseService.deleteMovie(imdb_id);
    }

}

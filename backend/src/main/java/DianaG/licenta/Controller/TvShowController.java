package DianaG.licenta.Controller;

import DianaG.licenta.DTO.ApiResponse;
import DianaG.licenta.Services.FirebaseService;
import DianaG.licenta.entities.Movie;
import DianaG.licenta.entities.Season;
import DianaG.licenta.entities.TvShow;
import DianaG.licenta.entities.UserComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class TvShowController {
    @Autowired
    FirebaseService firebaseService;
    @GetMapping("/getCommentDetails/{imdb_id}")
    public Season getExample(@PathVariable() String imdb_id) throws InterruptedException, ExecutionException {
        return firebaseService.seasonpuppet(imdb_id);
    }


    @GetMapping()
    public ApiResponse<List<TvShow>> getMovies() throws InterruptedException, ExecutionException {
        return new ApiResponse<>(HttpStatus.OK.value(), "tv: ",firebaseService.getMovies());
    }

    @PostMapping("/createtv")
    public String postExample(@RequestBody Movie person) throws InterruptedException, ExecutionException {
        return firebaseService.saveMovie(person);
    }

    @PutMapping("/updatetv")
    public String putExample(@RequestBody Movie person) throws InterruptedException, ExecutionException {
        return firebaseService.updateMovieDetails(person);
    }

    @DeleteMapping("/deletetv/{imdb_id}")
    public String deleteExample(@PathVariable() String imdb_id) {
        return firebaseService.deleteMovie(imdb_id);
    }


}

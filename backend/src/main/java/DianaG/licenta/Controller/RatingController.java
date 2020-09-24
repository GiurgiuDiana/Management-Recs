package DianaG.licenta.Controller;

import DianaG.licenta.DTO.ApiResponse;
import DianaG.licenta.Services.FirebaseService;
import DianaG.licenta.entities.Comment;
import DianaG.licenta.entities.Rating;
import DianaG.licenta.entities.UserRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    FirebaseService firebaseService;
    @GetMapping("/getRatingDetails/{imdb_id}")
    public UserRatings getExample(@PathVariable() String imdb_id) throws InterruptedException, ExecutionException {
        return firebaseService.getRatingsDetails(imdb_id);
    }

    @GetMapping()
    public ApiResponse<List<UserRatings>> getRatings() throws InterruptedException, ExecutionException {
        return new ApiResponse<>(HttpStatus.OK.value(), "ratings: ",firebaseService.getRating());
    }

    @PostMapping("/createRating")
    public String postExample(@RequestBody Rating person) throws InterruptedException, ExecutionException {
        return firebaseService.saveRatings(person);
    }

    @PutMapping("/updateRating")
    public String putExample(@RequestBody Rating person) throws InterruptedException, ExecutionException {
        return firebaseService.updateRatingDetails(person);
    }

    @PutMapping("/deleteRating")
    public String deleteExample(@RequestBody() Rating imdb_id) throws ExecutionException, InterruptedException {
        return firebaseService.deleteRatings(imdb_id,imdb_id.getUsername());
    }
}

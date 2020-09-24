package DianaG.licenta.Controller;

import DianaG.licenta.DTO.ApiResponse;
import DianaG.licenta.Services.FirebaseService;
import DianaG.licenta.entities.Comment;
import DianaG.licenta.entities.Movie;
import DianaG.licenta.entities.UserComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    FirebaseService firebaseService;
    @GetMapping("/getCommentDetails/{imdb_id}")
    public UserComments getExample(@PathVariable() String imdb_id) throws InterruptedException, ExecutionException {
        return firebaseService.getCommentsDetails(imdb_id);
    }

    @GetMapping()
    public ApiResponse<List<UserComments>> getComments() throws InterruptedException, ExecutionException {
        return new ApiResponse<>(HttpStatus.OK.value(), "comments: ",firebaseService.getComments());
    }

    @PostMapping("/createComment")
    public String postExample(@RequestBody Comment person) throws InterruptedException, ExecutionException {

        return firebaseService.saveComments(person);
    }

    @PutMapping("/updateComment")
    public String putExample(@RequestBody Comment person) throws InterruptedException, ExecutionException {
        return firebaseService.updateCommentsDetails(person);
    }

    @PutMapping("/deleteComment")
    public String deleteExample(@RequestBody Comment person) throws ExecutionException, InterruptedException {
        return firebaseService.deleteComments(person, person.getUsername());
    }
}

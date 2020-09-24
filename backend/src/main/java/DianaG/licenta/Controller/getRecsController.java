package DianaG.licenta.Controller;

import DianaG.licenta.Services.FirebaseService;
import DianaG.licenta.entities.Movie;
import DianaG.licenta.entities.UserComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/recs")
public class getRecsController {
    @Autowired
    FirebaseService firebaseService;
    @GetMapping("/getRecsDetails")
    public ArrayList<Movie> getExample(@RequestParam() String user_id) throws InterruptedException, ExecutionException, URISyntaxException, IOException {
        return firebaseService.prepareDataforMovie(user_id);
    }
}

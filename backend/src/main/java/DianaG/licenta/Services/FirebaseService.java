package DianaG.licenta.Services;

import DianaG.licenta.entities.*;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.google.gson.Gson;
import com.uwetrottmann.tmdb2.Tmdb;
import com.uwetrottmann.tmdb2.services.MoviesService;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import retrofit2.Response;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
@Service
public class FirebaseService {
    String api_key="api_key=88251fade3433bfe286d74cc40d2ded2";
    final String SEARCH_MOVIE_NAME="https://api.themoviedb.org/3/search/movie?api_key=88251fade3433bfe286d74cc40d2ded2&query=";

    public String saveUser(User pers) throws ExecutionException, InterruptedException {
        Firestore dbFirestor= FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collestionsAPI=dbFirestor.collection("users").document(pers.getUsername()).set(pers);
        return collestionsAPI.get().getUpdateTime().toString();
    }

    public User getUserDetails(String name) throws ExecutionException, InterruptedException {
        Firestore dbFirestor = FirestoreClient.getFirestore();
        DocumentReference doc = dbFirestor.collection("users").document(name);
        ApiFuture<DocumentSnapshot> future = doc.get();
        //estra document snapshot
        DocumentSnapshot snap = future.get();
       // DocumentReference documentReference= snap.getReference();
        User pers = null;
        if (snap.exists()) {
            pers = snap.toObject(User.class);
           // pers.setRecomendationsMovies(documentReference(Movie.class));
            return pers;
        } else{return null;}

    }
//similar to save user if the name exists-> it updates the document if it doesn't exist it creates it
    public String updateUserDetails(User pers) throws ExecutionException, InterruptedException {
        Firestore dbFirestor= FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collestionsAPI=dbFirestor.collection("users").document(pers.getUsername()).set(pers);
        return collestionsAPI.get().getUpdateTime().toString();

    }
    public String deleteUser(String name)
    {
        Firestore dbFirestor= FirestoreClient.getFirestore();
        ApiFuture<WriteResult> wr= dbFirestor.collection("users").document(name).delete();
        return "Document with username "+name+ " has been deleted";
    }

////Movies


    public String saveMovie(Movie pers) throws ExecutionException, InterruptedException {
        Firestore dbFirestor= FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collestionsAPI=dbFirestor.collection("movies").document(pers.getImdb_id()).set(pers);
        return collestionsAPI.get().getUpdateTime().toString();
    }

    public Movie getMovieDetails(String name) throws ExecutionException, InterruptedException {
        Firestore dbFirestor = FirestoreClient.getFirestore();
        DocumentReference doc = dbFirestor.collection("movies").document(name);
        ApiFuture<DocumentSnapshot> future = doc.get();
        //estra document snapshot
        DocumentSnapshot snap = future.get();
        Movie pers = null;
        if (snap.exists()) {
            pers = snap.toObject(Movie.class);
            return pers;
        } else{return null;}
    }

    public Season seasonpuppet(String name) throws ExecutionException, InterruptedException {
        Firestore dbFirestor = FirestoreClient.getFirestore();
        DocumentReference doc = dbFirestor.collection("movies").document(name);
        ApiFuture<DocumentSnapshot> future = doc.get();
        //estra document snapshot
        DocumentSnapshot snap = future.get();
        Season pers = null;
        if (snap.exists()) {
          //  pers = snap.toObject(Movie.class);
            return pers;
        } else{return null;}
    }




    //similar to save user if the name exists-> it updates the document if it doesn't exist it creates it
    public String updateMovieDetails(Movie pers) throws ExecutionException, InterruptedException {
        Firestore dbFirestor= FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collestionsAPI=dbFirestor.collection("movies").document(pers.getImdb_id()).set(pers);
        return collestionsAPI.get().getUpdateTime().toString();

    }
    public String deleteMovie(String imdb_id)
    {
        Firestore dbFirestor= FirestoreClient.getFirestore();
        ApiFuture<WriteResult> wr= dbFirestor.collection("movies").document(imdb_id).delete();
        return "Document with username "+imdb_id+ " has been deleted";
    }

//////Rating save

    public String saveRating(Rating pers) throws ExecutionException, InterruptedException {
        Firestore dbFirestor= FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collestionsAPI=dbFirestor.collection("ratings").document(pers.getUsername()).set(pers);
        return collestionsAPI.get().getUpdateTime().toString();
    }

    public Rating getRatingDetails(String name) throws ExecutionException, InterruptedException {
        Firestore dbFirestor = FirestoreClient.getFirestore();
        DocumentReference doc = dbFirestor.collection("ratings").document(name);
        ApiFuture<DocumentSnapshot> future = doc.get();
        //estra document snapshot
        DocumentSnapshot snap = future.get();
        Rating pers = null;
        if (snap.exists()) {
            pers = snap.toObject(Rating.class);
            return pers;
        } else{return null;}
    }




    //similar to save user if the name exists-> it updates the document if it doesn't exist it creates it
    public String updateRatingDetails(Rating pers) throws ExecutionException, InterruptedException {
        Firestore dbFirestor= FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collestionsAPI=dbFirestor.collection("ratings").document(pers.getUsername()).set(pers);
        return collestionsAPI.get().getUpdateTime().toString();

    }
    public String deleteRating(String imdb_id)
    {
        Firestore dbFirestor= FirestoreClient.getFirestore();
        ApiFuture<WriteResult> wr= dbFirestor.collection("ratings").document(imdb_id).delete();
        return "rating with username "+imdb_id+ " has been deleted";
    }











    public List<Movie> getMovies() throws ExecutionException, InterruptedException {
        Firestore dbFirestor= FirestoreClient.getFirestore();

//asynchronously retrieve all documents
        ApiFuture<QuerySnapshot> future = dbFirestor.collection("movies").get();
       // System.out.println(future.toString());
        List<Movie> allMovies = new ArrayList<>();
// future.get() blocks on response
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
      //  System.out.println(future.get().getDocuments().toString());
        for (QueryDocumentSnapshot document : documents) {
            //ApiFuture<DocumentSnapshot> future2 = document.get();
            System.out.println(document.getId() + " => " + document.toObject(Movie.class).toString());
           // Map<String, Object> snap = document.getData();
            //System.out.println(snap);
            Movie mm=  document.toObject(Movie.class);
           // System.out.println("aici"+mm.toString());
            allMovies.add(mm);
        }
            return allMovies;
    }
    ///CRUD comments
    public String saveComments(Comment pers) throws ExecutionException, InterruptedException {
      //  Firestore dbFirestor= FirestoreClient.getFirestore();
       // UserComments uc= new UserComments(pers.getUsername(),)
      //  ApiFuture<WriteResult> collestionsAPI=dbFirestor.collection("comments").document(pers.getUsername()).set(pers);
       // return collestionsAPI.get().getUpdateTime().toString();
        UserComments user=null;
        Firestore dbFirestor= FirestoreClient.getFirestore();

        try {
            user= getCommentsDetails(pers.getUsername());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Movie m=new Movie();
        try {
             m= getMovieByID(pers.getMovieID());
        } catch (IOException e) {
            e.printStackTrace();
        }
        saveMovie(m);
        if(user!=null)
        {
            user.addComment(pers);
            ApiFuture<WriteResult> collestionsAPI=dbFirestor.collection("comments").document(pers.getUsername()).set(user);
            return collestionsAPI.get().getUpdateTime().toString();
        }
        else
        {
            ArrayList<Comment>c= new ArrayList<Comment>();
            c.add(pers);
            user= new UserComments(pers.getUsername(),c);
//            user.setUsername();
//            user.setCommentsList(c);
            ApiFuture<WriteResult> collestionsAPI=dbFirestor.collection("comments").document(pers.getUsername()).set(user);
            return collestionsAPI.get().getUpdateTime().toString();
        }
    }

    public UserComments getCommentsDetails(String idMovieComment) throws ExecutionException, InterruptedException {
        Firestore dbFirestor = FirestoreClient.getFirestore();
        DocumentReference doc = dbFirestor.collection("comments").document(idMovieComment);
        ApiFuture<DocumentSnapshot> future = doc.get();
        //estra document snapshot
        DocumentSnapshot snap = future.get();
        // DocumentReference documentReference= snap.getReference();
        UserComments pers = null;
        if (snap.exists()) {
            pers = snap.toObject(UserComments.class);
            // pers.setRecomendationsMovies(documentReference(Movie.class));
            return pers;
        } else{return null;}
    }


    public List<UserComments> getComments() throws ExecutionException, InterruptedException {
        Firestore dbFirestor= FirestoreClient.getFirestore();

//asynchronously retrieve all documents
        ApiFuture<QuerySnapshot> future = dbFirestor.collection("comments").get();
        // System.out.println(future.toString());
        List<UserComments> allMovies = new ArrayList<>();
// future.get() blocks on response
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        //  System.out.println(future.get().getDocuments().toString());
        for (QueryDocumentSnapshot document : documents) {
            //ApiFuture<DocumentSnapshot> future2 = document.get();
            System.out.println(document.getId() + " => " + document.toObject(UserComments.class).toString());
            // Map<String, Object> snap = document.getData();
            //System.out.println(snap);
            UserComments mm=  document.toObject(UserComments.class);
            // System.out.println("aici"+mm.toString());
            if(mm.getCommentsList().size()==0)
            {
                ApiFuture<WriteResult> wr= dbFirestor.collection("comments").document(mm.getUsername()).delete();
                System.out.println( "Document with username "+mm.getUsername()+ " has been deleted");
            }
            else{  allMovies.add(mm);}

        }
        return allMovies;
    }

    //similar to save user if the name exists-> it updates the document if it doesn't exist it creates it
    public String updateCommentsDetails(Comment pers) throws ExecutionException, InterruptedException {
        Firestore dbFirestor= FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collestionsAPI=dbFirestor.collection("comments").document(pers.getUsername()).set(pers);
        return collestionsAPI.get().getUpdateTime().toString();
    }




    public String deleteComments(Comment cmm,String userId) throws ExecutionException, InterruptedException {
//        Firestore dbFirestor= FirestoreClient.getFirestore();
//        ApiFuture<WriteResult> wr= dbFirestor.collection("comments").document(userID).delete();
//        return "Document with username "+movieID+ " has been deleted";


        UserComments user=null;
        try {
            user= getCommentsDetails(userId);
           // String deleteU=deleteUser(userId);
          //  System.out.println(user.getFavouritesMovies().size());

         //   System.out.println(user.getEmail());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


      //  Comment m= getMovieByID(movieId);
        if(user!=null) {
            user.deleteComment(cmm);
           // System.out.println(user.getFavouritesMovies().size());
            Firestore dbFirestor= FirestoreClient.getFirestore();
             //UserComments uc= new UserComments(pers.getUsername(),)
              ApiFuture<WriteResult> collestionsAPI=dbFirestor.collection("comments").document(user.getUsername()).set(user);
             return collestionsAPI.get().getUpdateTime().toString();
        }
        else{
            return "error at deleting comment";
        }
    }

    public Movie getMovieByID(String movieID) throws IOException {
        URL movie= new URL("https://api.themoviedb.org/3/movie/"+movieID+"?"+api_key+"&language=en-US");
        HttpURLConnection con = (HttpURLConnection) movie.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
        String output;
        System.out.println("Output from Server .... \n");
        Gson gson= new Gson();

        Movie mm=gson.fromJson(br.readLine(), Movie.class);
        System.out.println(mm.getTitle());
        return mm;
    }



    public Movie getMovieByTitle(String mvoieTitle) throws IOException{
       String movieT=mvoieTitle.replace(" ","%20");
        URL url = new URL(SEARCH_MOVIE_NAME+movieT);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
        String output;
        System.out.println("Output from Server .... \n");
        Gson gson= new Gson();
        ApiCallResult mm=gson.fromJson(br.readLine(), ApiCallResult.class);
        System.out.println(mm.getTotal_results());
        return mm.getResults().get(0);
    }



    public String addWishlistObject(String userId, String movieId) throws IOException, ExecutionException, InterruptedException {
        User user=null;
        try {

             user= getUserDetails(userId);
            System.out.println(user.getEmail());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Movie m= getMovieByID(movieId);
        if(user!=null)
        {
            for(int i=0; i<user.getFavouritesMovies().size(); i++)
            {
                Movie move= user.getFavouritesMovies().get(i);
                if(move.getImdb_id().equalsIgnoreCase(m.getImdb_id()))
                {
                   user.getFavouritesMovies().remove(move);
                }

            }//  this.favouritesMovies.remove(m);
          ///  System.out.println(this.getFavouritesMovies().size()+"faveourite");

            user.addToFavourites(m);
            return saveUser(user);
        }
        else
        {
            return "error at adding movie"+m.getTitle();
        }
    }
    public String deleteWishlistObject(String userId, String movieId) throws IOException, ExecutionException, InterruptedException {
        User user=null;
        try {
            user= getUserDetails(userId);
            String deleteU=deleteUser(userId);
            System.out.println(user.getFavouritesMovies().size());

            System.out.println(user.getEmail());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Movie m= getMovieByID(movieId);
        if(user!=null) {
            user.cutFromFavourites(m);
            System.out.println(user.getFavouritesMovies().size());
            return saveUser(user);
        }
        else{
            return "error at deleting movie"+m.getTitle();
        }
    }
    public String addWatchedObject(String userId, String movieId) throws IOException, ExecutionException, InterruptedException {
        User user=null;
        try {
            user= getUserDetails(userId);
            System.out.println(user.getEmail());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Movie m= getMovieByID(movieId);
        if(user!=null)
        {
            user.addToWatched(m);
            return saveUser(user);
        }
        else
        {
            return "error at adding favourite movie"+m.getTitle();
        }
    }

    public String saveRatings(Rating pers) throws ExecutionException, InterruptedException {
        //  Firestore dbFirestor= FirestoreClient.getFirestore();
        // UserComments uc= new UserComments(pers.getUsername(),)
        //  ApiFuture<WriteResult> collestionsAPI=dbFirestor.collection("comments").document(pers.getUsername()).set(pers);
        // return collestionsAPI.get().getUpdateTime().toString();
        UserRatings user=null;
        Firestore dbFirestor= FirestoreClient.getFirestore();

        try {
            user= getRatingsDetails(pers.getUsername());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        Movie m= getMovieByID(movieId);
        if(user!=null)
        {
            user.addRating(pers);
            ApiFuture<WriteResult> collestionsAPI=dbFirestor.collection("ratings").document(pers.getUsername()).set(user);
            return collestionsAPI.get().getUpdateTime().toString();
        }
        else
        {
            ArrayList<Rating>c= new ArrayList<Rating>();
            c.add(pers);
            user= new UserRatings(pers.getUsername(),c);
//            user.setUsername();
//            user.setCommentsList(c);
            ApiFuture<WriteResult> collestionsAPI=dbFirestor.collection("ratings").document(pers.getUsername()).set(user);
            return collestionsAPI.get().getUpdateTime().toString();
        }
    }

    public UserRatings getRatingsDetails(String idMovieComment) throws ExecutionException, InterruptedException {
        Firestore dbFirestor = FirestoreClient.getFirestore();
        DocumentReference doc = dbFirestor.collection("ratings").document(idMovieComment);
        ApiFuture<DocumentSnapshot> future = doc.get();
        //estra document snapshot
        DocumentSnapshot snap = future.get();
        // DocumentReference documentReference= snap.getReference();
        UserRatings pers = null;
        if (snap.exists()) {
            pers = snap.toObject(UserRatings.class);
            // pers.setRecomendationsMovies(documentReference(Movie.class));
            return pers;
        } else{return null;}
    }


    public List<UserRatings> getRating() throws ExecutionException, InterruptedException {
        Firestore dbFirestor= FirestoreClient.getFirestore();

//asynchronously retrieve all documents
        ApiFuture<QuerySnapshot> future = dbFirestor.collection("ratings").get();
        // System.out.println(future.toString());
        List<UserRatings> allMovies = new ArrayList<>();
// future.get() blocks on response
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        //  System.out.println(future.get().getDocuments().toString());
        for (QueryDocumentSnapshot document : documents) {
            //ApiFuture<DocumentSnapshot> future2 = document.get();
            System.out.println(document.getId() + " => " + document.toObject(UserRatings.class).toString());
            // Map<String, Object> snap = document.getData();
            //System.out.println(snap);
            UserRatings mm=  document.toObject(UserRatings.class);
            // System.out.println("aici"+mm.toString());
            if(mm.getratingsList().size()==0)
            {
                ApiFuture<WriteResult> wr= dbFirestor.collection("ratings").document(mm.getUsername()).delete();
                System.out.println( "Document with username "+mm.getUsername()+ " has been deleted");
            }
            else{  allMovies.add(mm);}

        }
        return allMovies;
    }

//    //similar to save user if the name exists-> it updates the document if it doesn't exist it creates it
//    public String updateCommentsDetails(Comment pers) throws ExecutionException, InterruptedException {
//        Firestore dbFirestor= FirestoreClient.getFirestore();
//        ApiFuture<WriteResult> collestionsAPI=dbFirestor.collection("comments").document(pers.getUsername()).set(pers);
//        return collestionsAPI.get().getUpdateTime().toString();
//    }




    public String deleteRatings(Rating cmm,String userId) throws ExecutionException, InterruptedException {
//        Firestore dbFirestor= FirestoreClient.getFirestore();
//        ApiFuture<WriteResult> wr= dbFirestor.collection("comments").document(userID).delete();
//        return "Document with username "+movieID+ " has been deleted";


        UserRatings user=null;
        try {
            user= getRatingsDetails(userId);
            // String deleteU=deleteUser(userId);
            //  System.out.println(user.getFavouritesMovies().size());

            //   System.out.println(user.getEmail());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //  Comment m= getMovieByID(movieId);
        if(user!=null) {
            user.deleteRating(cmm);
            // System.out.println(user.getFavouritesMovies().size());
            Firestore dbFirestor= FirestoreClient.getFirestore();
            //UserComments uc= new UserComments(pers.getUsername(),)
            ApiFuture<WriteResult> collestionsAPI=dbFirestor.collection("ratings").document(user.getUsername()).set(user);
            return collestionsAPI.get().getUpdateTime().toString();
        }
        else{
            return "error at deleting comment";
        }
    }












    public String deleteWatchedObject(String userId, String movieId) throws IOException, ExecutionException, InterruptedException {
        User user=null;
        try {
            user= getUserDetails(userId);
            String deleteU=deleteUser(userId);
            System.out.println(user.getFavouritesMovies().size());

            System.out.println(user.getEmail());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Movie m= getMovieByID(movieId);
        if(user!=null) {
            user.cutFromWatched(m);
            System.out.println(user.getFavouritesMovies().size());
            return saveUser(user);
        }
        else{
            return "error at delete Watched movie"+m.getTitle();
        }
    }


    public   List<User> getUsers() throws ExecutionException, InterruptedException {
        Firestore dbFirestor= FirestoreClient.getFirestore();

//asynchronously retrieve all documents
        ApiFuture<QuerySnapshot> future = dbFirestor.collection("users").get();
        // System.out.println(future.toString());
        List<User> allMovies = new ArrayList<>();
// future.get() blocks on response
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        //  System.out.println(future.get().getDocuments().toString());
        for (QueryDocumentSnapshot document : documents) {
            //ApiFuture<DocumentSnapshot> future2 = document.get();
            System.out.println(document.getId() + " => " + document.toObject(User.class).toString());
            // Map<String, Object> snap = document.getData();
            //System.out.println(snap);
            User mm=  document.toObject(User.class);
            // System.out.println("aici"+mm.toString());
            allMovies.add(mm);
        }
        return allMovies;
    }

    public ArrayList<Movie> prepareDataforMovie(String user_id) throws ExecutionException, InterruptedException, IOException, URISyntaxException {
      User util=  getUserDetails(user_id);
         List<Movie> favouritesMoviesUser=util.getFavouritesMovies();
        //movies seen by the user
         List<Movie>  watchedMoviesUser=util.getWatchedMovies();
        ArrayList<String>RecsForOne= new ArrayList<>();
         for(Movie m :favouritesMoviesUser)
         {
            for(String oneNameMovie:(getRecsDetails(m.getTitle())))
            {

                System.out.println(oneNameMovie);
                RecsForOne.add(oneNameMovie);
            }
         }
         //daca au acelasi nume il scoatem ca pp deja vazut
         for(Movie seen: watchedMoviesUser)
         {
             for(String str: RecsForOne){
                 if(seen.getTitle().equalsIgnoreCase(str))
                 {
                     RecsForOne.remove(str);
                 }

             }
         }
         ArrayList<Movie>Recs= new ArrayList<>();
    for(String str2: RecsForOne)
    {
        Movie m= getMovieByTitle(str2.split("\\s+")[0]);
        Recs.add(m);
        System.out.println(m);

    }
    util.setRecomendationsMovies(Recs);
    deleteUser(util.getUsername());
    saveUser(util);
        return Recs;
    }

    public ArrayList<String> getRecsDetails(String imdb_id) throws URISyntaxException, IOException {
        URIBuilder builder = new URIBuilder();
      String  imdb=imdb_id.replaceAll("The","");
        imdb_id.replaceFirst("The"," ");
        URL url = new URL("http://127.0.0.1:5000/?movieName="+imdb.replaceAll("\\s",""));
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
        String output;
        ArrayList<String>onlyTheMovies=new ArrayList<>();
        ArrayList<String[]> array1= new ArrayList();
        while ((output = br.readLine()) != null) {
                String[] add=output.substring(1).split(";");
            array1.add(add);
        }
        for(String[] temp:array1) {
            for (int i = 0; i < 5; i++) {
                onlyTheMovies.add(temp[i].split(",")[0]);
            }
        }
        return onlyTheMovies;
    }


}

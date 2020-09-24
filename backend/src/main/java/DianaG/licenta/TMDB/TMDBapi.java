package DianaG.licenta.TMDB;

import DianaG.licenta.entities.Movie;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class TMDBapi {

    String api_key="api_key=88251fade3433bfe286d74cc40d2ded2";
    String api_request="https://api.themoviedb.org/3/movie/550";
    String request_key=api_request+"?"+api_key;
    URL search = new URL("https://api.themoviedb.org/3/search/movie?api_key=88251fade3433bfe286d74cc40d2ded2&query=Psycho");
    URL discover = new URL("https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc?&api_key=88251fade3433bfe286d74cc40d2ded2");
    URL movie= new URL("https://api.themoviedb.org/3/movie/539?"+api_key+" &language=en-US");

    public TMDBapi() throws IOException {
        URL url = new URL("https://api.themoviedb.org/3/search/movie?api_key=88251fade3433bfe286d74cc40d2ded2&query=Psycho");
        HttpURLConnection con = (HttpURLConnection) movie.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");

        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
        }
    }
}



package DianaG.licenta;

import DianaG.licenta.TMDB.TMDBapi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class LicentaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LicentaApplication.class, args);
		try {
			new TMDBapi();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

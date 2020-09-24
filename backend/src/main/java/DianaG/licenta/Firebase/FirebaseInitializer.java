package DianaG.licenta.Firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
@Service
public class FirebaseInitializer {
//connects to firebase straight after compiling
    @PostConstruct
    public void initialize() throws IOException {
        //connection details

        FileInputStream serviceAccount =
                new FileInputStream("./fir-auth-142f7-firebase-adminsdk-wtsk0-3f0d0233b7.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://fir-auth-142f7.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);

    }

}



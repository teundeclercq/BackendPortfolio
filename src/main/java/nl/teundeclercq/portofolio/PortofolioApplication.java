package nl.teundeclercq.portofolio;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.core.io.ClassPathResource;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class PortofolioApplication extends SpringBootServletInitializer {
	private static final Logger loggerApplication = Logger.getLogger( PortofolioApplication.class.getName() );
	public static void main(String[] args) {
		SpringApplication.run(PortofolioApplication.class, args);
		try {
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(new ClassPathResource("/s4portfoliofirebase-firebase-adminsdk-9il0m-67bf53866e.json").getInputStream()))
					.setDatabaseUrl("https://s4portfoliofirebase.firebaseio.com")
					.build();

			FirebaseApp.initializeApp(options);
		} catch (IOException e) {
			loggerApplication.log(Level.WARNING, "IOException", e);
		}
	}
}

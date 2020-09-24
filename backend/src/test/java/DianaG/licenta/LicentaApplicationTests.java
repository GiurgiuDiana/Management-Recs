package DianaG.licenta;

import DianaG.licenta.Services.FirebaseService;
import DianaG.licenta.entities.Comment;
import DianaG.licenta.entities.Movie;
import DianaG.licenta.entities.User;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@SpringBootTest
class LicentaApplicationTests {


	@Autowired
	FirebaseService firebaseService;
	@Test
	void contextLoads() throws ExecutionException, InterruptedException {
		Movie m1= new Movie(1,"151","Silence","Silence",4.5);
		Movie m2= new Movie(2,"153","Midsommar","Midsommar",4.5);
		Movie m3= new Movie(3,"1578","Parasite","Parasite",4.5);
		Movie m4= new Movie(4,"1544","Flower","Flower",4.5);
		Comment com= new Comment("comentariu",1,"diana",m1.getImdb_id());
		List<Movie> mm= new ArrayList<Movie>();
		List<Movie> mm2= new ArrayList<Movie>();
		List<Movie> mm3= new ArrayList<Movie>();
		mm.add(m1);
		mm2.add(m2);
		mm2.add(m3);
		mm3.add(m4);
		User u1= new User("Diana","giurgiu","15","dianaG@yahoo.com","123456","dianaG","diana","Baritiu",mm,mm2,mm3);
		//FirebaseService serv= new FirebaseService();
		//serv.saveUser(u1);
        u1.setEmail("diana@diana.com");
        assertTrue(u1.getEmail().equals("diana@diana.com"));

	}


	@Test
	void UserIntegrationtesting() throws ExecutionException,InterruptedException
	{
		Movie m1= new Movie(1,"151","Silence","Silence",4.5);
		Movie m2= new Movie(2,"153","Midsommar","Midsommar",4.5);
		Movie m3= new Movie(3,"1578","Parasite","Parasite",4.5);
		Movie m4= new Movie(4,"1544","Flower","Flower",4.5);
		List<Movie> mm= new ArrayList<Movie>();
		List<Movie> mm2= new ArrayList<Movie>();
		List<Movie> mm3= new ArrayList<Movie>();
		firebaseService=new FirebaseService();
		User u1= new User("Diana","giurgiu","15","dianaG@yahoo.com","123456","dianaG","diana","Baritiu",mm,mm2,mm3);
		assertNotNull(u1);
		firebaseService.saveUser(u1);
		User gotU1=firebaseService.getUserDetails(u1.getUsername());
		assertNotNull(gotU1);
		u1.setEmail("diana@diana.com");
		assertTrue(u1.getEmail().equals("diana@diana.com"));
		firebaseService.updateUserDetails(u1);
		User gotUpdatedUser=firebaseService.getUserDetails(u1.getUsername());
		String userDeleted=firebaseService.deleteUser(u1.getUsername());
		assertTrue(userDeleted.contains(u1.getUsername()));

	}
/*
	@Test
	void UserJUnitCRUDtesting()throws ExecutionException,InterruptedException{
		User u1= new User("Diana","giurgiu","15","dianaG@yahoo.com","123456","dianaG","diana","Baritiu",mm,mm2,mm3);//save operation
		firebaseService.saveUser(u1);
		User gotU1=firebaseService.getUserDetails(u1.getUsername());
		assertNotNull(gotU1);
		u1.setEmail("diana@diana.com");
		//updateOperation
		assertTrue(u1.getEmail().equals("diana@diana.com"));
		firebaseService.updateUserDetails(u1);
		User gotUpdatedUser=firebaseService.getUserDetails(u1.getUsername());
		String userDeleted=firebaseService.deleteUser(u1.getUsername());
		assertTrue(userDeleted.contains(u1.getUsername()));
	}*/

    @Test
    void movieCRUD()throws ExecutionException,InterruptedException{

        Movie m1= new Movie(1,"151","Silence","Silence",4.5);
        m1.setAdult(true);



    }

}

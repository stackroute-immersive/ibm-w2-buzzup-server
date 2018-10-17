package com.stackroute.buzzup.moviescreeningservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.stackroute.buzzup.kafka.domain.MovieSchedule;
import com.stackroute.buzzup.kafka.domain.Seats;
import com.stackroute.buzzup.moviescreeningservice.service.MovieScheduleService;



@Component
public class DataLoader implements ApplicationRunner {

	private MovieScheduleService movieScheduleService;

	
	@Autowired
	public DataLoader(MovieScheduleService movieScheduleService) {
		this.movieScheduleService = movieScheduleService;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<Integer> list1 = new ArrayList();
		List<Integer> list2 = new ArrayList();
		for (int i = 0; i < 10; i++) {
		
			list1.add(i);
			list2.add(i);
		}
		String[] typesOfSeats = { "Platnium", "Gold", "Silver" };
		int[] noOfSeats = new int[] { 10, 20, 30 };
		int[] weekendsprice = new int[] { 1000, 1500, 2500 };
		int[] weekdayprice = new int[] { 500, 800, 2000};
		Seats local = new Seats(10, 10, list1, list2);
		
		
	    MovieSchedule local14 = new MovieSchedule("t41", "Pvr", "pvr@gmail.com",
	        " OMR,Opposite Athidhi Mall, Dharavi, Mumbai-500234", "Mumbai", "pvr123", "100",
	        local, typesOfSeats, noOfSeats, "t4", "Venom",
	        "https://i0.wp.com/lh3.googleusercontent.com/7-CVRM2okJBXY6KCdzXuPDkIu4XraNEClpLbDxRqyrXCwO7EO4OIUMqqiXx7TclUIOk=w300",
	        "Michelle Williams", "Riz Ahmed", "Ruben Fleischer", "Comics",
	        "Venom is a 2018 American superhero film based on the Marvel Comics character of the same name, produced by Columbia Pictures in association with Marvel. Distributed by Sony Pictures Releasing, it is the first film in Sony's Marvel Universe. The film is directed by Ruben Fleischer from a screenplay by Jeff Pinkner, Scott Rosenberg, and Kelly Marcel, and stars Tom Hardy as Eddie Brock / Venom, alongside Michelle Williams, Riz Ahmed, Scott Haze, and Reid Scott. In Venom, journalist Brock gains superpowers after being bound to an alien symbiote whose species plans to invade Earth.",
	        "3D", "English", "02:02:16", "01/10/2018", 4, "09:00,12:00,15:00,18:00", weekendsprice, weekdayprice);
	    movieScheduleService.addMovieSchedule(local14);
	    MovieSchedule local15 = new MovieSchedule("t42", "Sangam", "sangam@gmail.com",
	        "120, Jaynagar, Near IPl Bank,Uppal,East,Mumbai-500060", "Mumbai", "Sangam123", "100",
	        local, typesOfSeats, noOfSeats, "m11", "Johnny English Strikes Again",
	        "http://buzinessbytes.com/wp-content/uploads/2018/09/JE3_1SHT_ROWAN_OLGA_R4-page-001-300x300.jpg",
	        "Rowan Atkinson","Beny Miller","Olga Kurylenko", "Comedy",
	        "Johnny English Strikes Again is a 2018 action comedy[3] film directed by David Kerr; it is a sequel to the 2011 film Johnny English Reborn and the third instalment in the Johnny English series. The film is written by William Davies and produced by Rowan Atkinson, who reprises his role as the title character. The film will be released in cinemas in the United Kingdom on 5 October 2018 and 26 October in the United States, by Universal Pictures.",
	        "2D", "English", "01:44:26", "05/10/2018", 2, "10:00,13:30", weekendsprice, weekdayprice);
	movieScheduleService.addMovieSchedule(local15);
	    MovieSchedule local16 = new MovieSchedule("t43", "Ags70mm", "ags@gmail.com",
	        "1,Sairam Nagar ColonyMain Road, ECL,Mumbai-500055", "Mumbai", "ags123", "100", local,
	        typesOfSeats, noOfSeats, "p3", "Stree",
	        "http://content.hungama.com/audio%20album/display%20image/300x300%20jpeg/5239452731.jpg", 
	"Rajkummar Rao","Shraddha Kapoor", "Sharat Katariya", "Horror",
	        "Stree (transl. Woman;) is a 2018 Indian Hindi-language comedy horror film that went on to become one of the biggest blockbusters of all time. The film is directed by Amar Kaushik, written by Raj Nidimoru and Krishna D.K. and produced by Dinesh Vijan and Raj Nidimoru and Krishna D.K. under the banner of Maddock Films in association with D2RFilms. It is based on the Indian urban legend Nale Ba, about a spirit who knocks on people's doors at night. Stree stars Rajkummar Rao and Shraddha Kapoor. Pankaj Tripathi, Aparshakti Khurrana, and Abhishek Banerjee appear in supporting roles.",
	        "2D", "Hindi", "02:09:39", "30/08/2018", 5, "09:00,17:00", weekendsprice, weekdayprice);
	 movieScheduleService.addMovieSchedule(local16);
	    MovieSchedule local17 = new MovieSchedule("t44", "Inox120mm", "inox@gmail.com",
	        "83,Sriram Nagar ColonyMain Road, ECIL,Mumbai-500045", "Mumbai", "Inox123", "100", local,
	        typesOfSeats, noOfSeats, "v3", "Sanju",
	        "https://1.bp.blogspot.com/--Rvh-QJBTsE/W0gNBKfJULI/AAAAAAAAADE/2uAD9QV6uAcX1POpTWyQCNYxfhCebioIACLcBGAs/s300-c/Sanju-2018.jpg",
	 "Ranbir Kapoor","Pareshi Rawali","Vicky Kaushal", "Drama",
	        "TSanju is a 2018 Indian biographical film directed by Rajkumar Hirani and written by Hirani and Abhijat Joshi. It was jointly produced by Hirani and Vidhu Vinod Chopra under the banners Rajkumar Hirani Films and Vinod Chopra Films respectively. The film follows the life of Bollywood actor Sanjay Dutt, his addiction with drugs, arrest for alleged association with the 1993 Bombay bombings, relationship with his father, comeback in the industry, the eventual drop of charges from bombay blasts, and release after completing his jail term. Ranbir Kapoor stars as Dutt, along with an ensemble cast which features Paresh Rawal as Sunil Dutt, Vicky Kaushal, Manisha Koirala as Nargis, Dia Mirza as Manyata Dutt, Sonam Kapoor, Anushka Sharma and Jim Sarbh.",
	        "2D", "Hindi", "02:41:39", "29/06/2018", 2, "09:00,17:00", weekendsprice, weekdayprice);
	  movieScheduleService.addMovieSchedule(local17);
	    MovieSchedule local18 = new MovieSchedule("t45", "PVRMumbai", "pvr@gmail.com",
	        "1-6-1,Sriram Nagar ColonyMain Road, ECIL,Mumbai-500045", "Mumbai", "Radhika123", "100", local,
	        typesOfSeats, noOfSeats, "o3", "Kaala",
	        "https://i9.behindwoods.com/tamil-movies-cinema-news-16/images/superstar-rajinikanths-kaala-official-telugu-songs-jukebox-new-home-mob-index.jpg", "Rajinikanth","Huma","Samuthirakani", "Action",
	        "Kaala is a 2018 Indian Tamil-language sociopolitical action drama film written and directed by Pa. Ranjith and produced by Dhanush. Starring Rajinikanth in the lead role,the film was announced in 2016. The film was earlier scheduled to be released on 27 April 2018 but was postponed to June due to the standoff between Nadigar Sangam and Digital Service Providers on the increase of Virtual Print Fee charges along with the 2018 Tamil Nadu protests for Kaveri water sharing issue which also led to the delay in release of other Tamil films. Kaala premiered in Malaysia on 6 June 2018, followed by a release in 1,800 theatres in India on 7 June 2018. ",
	        "2D", "Tamil", "02:39:21", "07/06/2018", 3, "09:00,17:00,22:00", weekendsprice, weekdayprice);
	    movieScheduleService.addMovieSchedule(local18);
	    MovieSchedule local19 = new MovieSchedule("t46", "Aura", "aura@gmail.com",
	        "1,Sriram Nagar Main Road, Vadapalani,Chennai-600045", "Chennai", "flex123", "100", local,
	        typesOfSeats, noOfSeats, "a3", "Tamizh Padam 2",
	 "http://www.tamilmediahouse.com/flcimgs/news-images/tamizh-padam-2-trolls-actors-rajinikanth-and-vishal.jpg",
	        "Shiva","Iswarya Menon","Disha Pandey", "Parody",
	        "Tamizh Padam 2 (Tamil Film 2) is a 2018 Indian Tamil language parody film, written and directed by C. S. Amudhan, and produced by S. Sashikanth. A sequel to Thamizh Padam (2010), the film stars Shiva and Disha Pandey, with music composed by Kannan and cinematography by Gopi Amarnath.",
	        "2D", "Tamil", "02:25:21", "12/07/2018", 3, "09:00,17:00,22:00", weekendsprice, weekdayprice);
	    movieScheduleService.addMovieSchedule(local19);
	    MovieSchedule local20 = new MovieSchedule("t47", "Jazz4K", "jazz@gmail.com",
	        "Arcade,Opposite Athidhi Restaurant, Mumbai-500234", "Mumbai", "jazz123", "100", local, typesOfSeats,
	        noOfSeats, "m1", "Chak De India", "https://images-na.ssl-images-amazon.com/images/I/51yrR0KB2UL._SY300_QL70_.jpg",
	        "Shah Rukh Khan", "Sagarika Ghatge","Anand Shankar", "Parody",
	        "Chak De! India (English: Go For it! India or Go! India) is a 2007 Indian sports film, directed by Shimit Amin and produced by Aditya Chopra, with a screenplay written by Jaideep Sahni, sports scenes choreographed by Rob Miller, and music by Salim–Sulaiman. It tells a fictional story about the Indian women's national field-hockey team, which was inspired by the team's win at the 2002 Commonwealth Games, and explores themes such as feminism and sexism, the legacy of the partition of India, racial and religious bigotry, and ethnic and regional prejudice. The film stars Shahrukh Khan as Kabir Khan, former captain of the Indian men's national field-hockey team. After a disastrous loss to Pakistan, Khan is ostracized from the sport and he and his mother are driven from the family home by angry neighbors. Seven years later, to redeem himself, Khan becomes the coach of the Indian national women's hockey team and aims to turn its sixteen contentious players into a championship unit.",
	        "2D", "Hindi", "02:33:21", "10/08/2007", 4, "09:00,12:00,15:00,18:00", weekendsprice, weekdayprice);
	    movieScheduleService.addMovieSchedule(local20);
	    MovieSchedule local21 = new MovieSchedule("t48", "LuxeGreat", "luxe@gmail.com",
	        "Shaankar,BMT Road, Ramanagaram, Bangalore-562159", "Bangalore", "Shaan123", "100", local, typesOfSeats,
	        noOfSeats, "b21", "Sairat",
	        "https://images-na.ssl-images-amazon.com/images/I/61FEYqBJ3IL._SY300_QL70_.jpg",
	        "Rinku Rajguru","Akashi Thosar","Donsi", "Parody",
	        "Sairat (English: Wild) is a 2016 Indian Marathi-language romance film, directed by Nagraj Manjule and produced by himself under his banner Aatpat Production along with Essel Vision Productions and Zee Studios. Starring Rinku Rajguru and Akash Thosar in their debuts, it tells the story of two young college students from different castes who fall in love, sparking conflict between their families. ",
	        "2D", "Marathi", "02:56:45", "29/04/2016", 4, "09:00,12:00,15:00,18:00", weekendsprice, weekdayprice);


	}
}


package com.stackroute.buzzup.distributor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.stackroute.buzzup.distributor.domain.Movie;
import com.stackroute.buzzup.distributor.repository.MovieRepositary;



@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private MovieRepositary movieRepositary;

	public DataLoader(MovieRepositary movieRepository) {
		this.movieRepositary = movieRepository;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		movieRepositary.save(new Movie("21","pune", "Venom",
		        "https://i0.wp.com/lh3.googleusercontent.com/7-CVRM2okJBXY6KCdzXuPDkIu4XraNEClpLbDxRqyrXCwO7EO4OIUMqqiXx7TclUIOk=w300",
		  
		"Tom Hardy",
		        "Michelle Williams", "Riz Ahmed", "Comics ",
		        "Venom is a 2018 American superhero film based on the Marvel Comics character of the same name, produced by Columbia Pictures in association with Marvel.[5] Distributed by Sony Pictures Releasing, it is the first film in Sony's Marvel Universe. The film is directed by Ruben Fleischer from a screenplay by Jeff Pinkner, Scott Rosenberg, and Kelly Marcel, and stars Tom Hardy as Eddie Brock / Venom, alongside Michelle Williams, Riz Ahmed, Scott Haze, and Reid Scott. In Venom, journalist Brock gains superpowers after being bound to an alien symbiote whose species plans to invade Earth.",
		        "3D", "English", "02:02:16", "01-10-2018"));
//		movieRepositary.save(new Movie("22", "Johnny English Strikes Again",
//		        "http://buzinessbytes.com/wp-content/uploads/2018/09/JE3_1SHT_ROWAN_OLGA_R4-page-001-300x300.jpg",
//		  
//		"Rowan Atkinson","Ben Miller","Olga Kurylenko", "Comedy",
//		        "Johnny English Strikes Again is a 2018 action comedy[3] film directed by David Kerr; it is a sequel to the 2011 film Johnny English Reborn and the third instalment in the Johnny English series. The film is written by William Davies and produced by Rowan Atkinson, who reprises his role as the title character. The film will be released in cinemas in the United Kingdom on 5 October 2018 and 26 October in the United States, by Universal Pictures.",
//		        "2D", "English", "01:44:26", "05-10-2018"));
//		movieRepositary.save(new Movie("23", "Namaste England",
//		        "https://www.pagalworld.org/GpE34Kg9Gq/14477/thumb-namaste-england-2018-mp3-songs-300.jpg",
//		  
//		"Arjun Kapoor","Vipul Amrutlal Shah","Parineeti Chopra", "Romance",
//		        "Namaste England (lit. Hello England) is an upcoming Bollywood romantic comedy film directed and co-produced by Prakhar Bhagat. The film is the sequel to 2007 film Namastey London. The film stars Arjun Kapoor and Parineeti Chopra and Aditya Seal in lead roles. It is scheduled for a worldwide release on 19 October 2018. The Principle shoot of the film begins on 23 February 2018 at Amritsar, Punjab.The first poster of the film was released on 14 August 2018.",
//		        "2D", "Hindi", "02:09:39", "19-10-2018"));
//		movieRepositary.save(new Movie("24", "Stree",
//		        "http://content.hungama.com/audio%20album/display%20image/300x300%20jpeg/5239452731.jpg",
//		  
//		"Rajkummar Rao","Amar Kaushik","Shraddha Kapoor", "Horror",
//		        "Stree (transl. Woman;) is a 2018 Indian Hindi-language comedy horror film that went on to become one of the biggest blockbusters of all time. The film is directed by Amar Kaushik, written by Raj Nidimoru and Krishna D.K. and produced by Dinesh Vijan and Raj Nidimoru and Krishna D.K. under the banner of Maddock Films in association with D2RFilms. It is based on the Indian urban legend Nale Ba, about a spirit who knocks on people's doors at night. Stree stars Rajkummar Rao and Shraddha Kapoor. Pankaj Tripathi, Aparshakti Khurrana, and Abhishek Banerjee appear in supporting roles.",
//		        "2D", "Hindi", "02:09:39", "30-08-2018"));
//		movieRepositary.save(new Movie("25", "Andhadhun",
//		        "https://st1.bollywoodlife.com/wp-content/uploads/2018/10/Andhadhuni-movie-reviews45-300x300.jpg",
//		  
//		"Ayushmann Khurrana","Radhika Apte","Sriram Raghavan", "black comedy crime thriller",
//		        "Andhadhun (transl. Blind melody) is a 2018 Indian black comedy crime thriller film directed by Sriram Raghavan. It stars Tabu, Ayushmann Khurrana, and Radhika Apte and tells the story of a piano player who unwittingly becomes embroiled in the murder of a former film actor.It is inspired by the 2010 French short film L'Accordeur (The Piano Tuner). The film was released theatrically on 5 October 2018, and received critical acclaim",
//		        "2D", "Hindi", "02:18:39", "05-10-2018"));
//		movieRepositary.save(new Movie("26", "Badhaai Ho",
//		        "https://www.pagalworld.org/GpE34Kg9Gq/14488/117171-badhaaiyan-tenu-mp3-song-300.jpg",
//		  
//		"Ayushmann Khurrana","Amit Ravindernath ","Sanya Malhotra", "comedy drama",
//		        "Badhaai Ho (transl. Congratulations; Hindi pronunciation: [bədʱaːiː ɦoː]) is an upcoming Indian comedy drama film directed by Amit Ravindernath Sharma. The film stars Ayushmann Khurrana and Sanya Malhotra in the lead roles. Badhaai Ho is tipped to be a coming-of-age story with a tinge of romance.The Film is produced by Vineet Jain, Hemant Bhandari and Aleya Sen under the banner of Junglee Pictures and Chrome Pictures. It is written by Shantanu Srivastava",
//		        "2D", "Hindi", "02:18:21", "19-10-2018"));
//		movieRepositary.save(new Movie("27", "Chekka Chivantha Vaanam",
//		        "http://mimgs.sulekha.com/tamil/chekka-chivantha-vaanam/chekka-chivantha-vaanam_m.jpg",
//		  "Arvind Swamy","Mani Ratnam","Silambarasan", "crime thriller ",
//		        "Chekka Chivantha Vaanam (English: Crimson Red Sky) is a 2018 Indian Tamil-language crime thriller film co-written and directed by Mani Ratnam. The film features Arvind Swami, Silambarasan, Arun Vijay, Vijay Sethupathi, Jyothika, Aishwarya Rajesh, Aditi Rao Hydari, and Dayana Erappa as the ensemble cast, while Prakash Raj, Jayasudha, Thiagarajan and Mansoor Ali Khan appear in pivotal roles. The film tells the story about the bloody power struggle that erupts between three brothers who are vying to take over the family business following the death of their father.",
//		        "2D", "Tamil", "02:23:21", "27-09-2018"));
//		movieRepositary.save(new Movie("28", "96",
//		        "https://st1.bollywoodlife.com/wp-content/uploads/2018/10/96-300x300.jpg",
//		  
//		"Vijay Sethupathi","C. Prem Kumar","Trisha Krishnan", "romantic drama ",
//		        "96 is a 2018 Indian Tamil-language romantic drama film featuring Vijay Sethupathi and Trisha Krishnan in the lead roles.The film is written and directed by C. Prem Kumar who earlier handled the cinematography for Naduvula Konjam Pakkatha Kaanom, and its bankrolled by Nandagopal of Madras Enterprises. The music for the film is composed by Govind Menon, vocalist and violinist of the band Thaikkudam Bridge. N. Shanmuga Sundaram is doing the cinematography.",
//		        "2D", "Tamil", "02:37:21", "04-10-2018"));
//		movieRepositary.save(new Movie("29", "Aravinda Sametha Veera Raghava",
//		        "https://st1.bollywoodlife.com/wp-content/uploads/2018/10/ASVR-2-300x300.jpg",
//		  
//		"N. T. Rama Rao Jr.","Pooja Hegde","Trivikram Srinivas", "romantic drama ",
//		        "Aravindha Sametha Veera Raghava [ Veera Raghava with Aravindha ] is a 2018 Telugu action film,[4] produced by S. Radha Krishna on Haarika & Hassine Creations banner and directed by Trivikram Srinivas. The film stars N. T. Rama Rao Jr., Pooja Hegde and Eesha Rebba in the lead roles Sunil, Naga Babu, Jagapathi Babu and Supriya Pathak in supporting roles. The music was composed by S. Thaman. Zee Telugu purchased the film's satellite distribution rights for a ₹23.5 crore (US$3.3 million)",
//		        "2D", "Telugu", "02:43:21", "11-10-2018"));
				
		
}
}
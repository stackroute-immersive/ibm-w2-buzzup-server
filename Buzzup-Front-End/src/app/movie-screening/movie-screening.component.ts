import { Theatre } from './../theatre';
import { Distributor } from './../distributor';
import { Component, OnInit } from '@angular/core';
import { MovieSchedule} from '../screening-details';
import { ProducerService } from '../producer.service';
import { TheaterService } from '../theater.service';
import { MovieScreeningService } from '../movie-screening.service';
import { Movie } from '../movies';



export interface Timing{
  timeSlot: string;
}

@Component({
  selector: 'app-movie-screening',
  templateUrl: './movie-screening.component.html',
  styleUrls: ['./movie-screening.component.css']
})
export class MovieScreeningComponent implements OnInit {

  // Declaring fields
  public movieName: string;
  public seatCategory: string;
  public timeSlotArray: string[]=new Array("9-12 p.m","12-3 p.m","3-6 p.m","6-9 p.m");
  public timeSlot: string[] = new Array();
  public ticketPrice: string[] = new Array();
  public producerId: string = "deba@gmail.com";
  public category: string;
  public weekendprice: number;
  public weekdayprice: number;
  public movieDate: Date = new Date();
  public selectedTheater:string;
  public city: string;
  movieSchedule : MovieSchedule = new MovieSchedule();
  theatre: Theatre = new Theatre();
  distributor: Distributor = new Distributor();
  movie: Movie = new Movie();
  public flag1: boolean = false;
  public flag2: boolean = false;
  public flag3: boolean = false;
  public flag4: boolean = false;
  public showTimings: string;
  public time: string;
  public time1: string;
  public time2: string;
  public time3: string;
  public weekendsPrice: string[] = new Array();
  public weekdaysPrice: string[] = new Array();

  timings: Timing[] =[{timeSlot:'9 a.m - 12 p.m'},{timeSlot:'12 p.m - 3 p.m'},{timeSlot:'3 p.m - 6 p.m'},{timeSlot:'6 p.m - 9 p.m'}]
  constructor(private theaterService:TheaterService, private producerService:ProducerService, private screeningService:MovieScreeningService) {
    
  }

// onSubmit function, it passes the screening object to the screening-service function 
onSubmit(){ 
    this.movieSchedule.theatreId = this.theatre.theatreId;
    this.movieSchedule.theatreName = this.theatre.theatreName;
    this.movieSchedule.emailId = this.theatre.emailId;
    this.movieSchedule.theatreLocation = this.theatre.theatreLocation;
    this.movieSchedule.theatreCity = this.theatre.theatreCity;
    this.movieSchedule.theatreLicenseNo = this.theatre.theatreLicenseNo;
    this.movieSchedule.totalnumberOfSeats = this.theatre.totalnumberOfSeats;
    this.movieSchedule.seatLayout = this.theatre.seatLayout;
    this.movieSchedule.typesOfSeats = this.theatre.typesOfSeats;
    this.movieSchedule.numberOfSeats = this.theatre.numberOfSeats;
    this.movieSchedule.id = this.movie.id;
    this.movieSchedule.movieName = this.movieName;
    this.movieSchedule.moviePoster = this.movie.moviePoster;
    this.movieSchedule.actors = this.movie.actors;
    this.movieSchedule.actress = this.movie.actress;
    this.movieSchedule.directors = this.movie.directors;
    this.movieSchedule.movieGenres = this.movie.movieGenres;
    this.movieSchedule.synopsis = this.movie.synopsis;
    this.movieSchedule.format = this.movie.format;
    this.movieSchedule.languages = this.movie.languages;
    this.movieSchedule.movieDuration = this.movie.movieDuration;
    this.movieSchedule.movieReleaseDate = this.movie.movieReleaseDate;
    this.movieSchedule.weekdaysPrice = this.weekdaysPrice;
    this.movieSchedule.weekendsPrice = this.weekendsPrice;
    
    this.movieSchedule.showNumbers =1;
    this.showTimings= this.time.concat(this.time1,this.time2,this.time3);
    this.movieSchedule.showTimings = this.showTimings;

  // this.screening.city = this.theatre.theatreCity;
  // this.screening.theater = this.theatre;
  // this.screening.movieName = this.movieName;
  // // this.screening.seatCategory = this.seatCategory;
  // this.screening.ticketPrice = this.ticketPrice;
  // this.screening.timeSlot = this.timeSlot;
  // this.screening.movieDate = this.movieDate;
  console.log(this.movieSchedule);
  this.screeningService.createMovieScreening(this.movieSchedule).subscribe(
    data => console.log(data)
  );
  
}

//this function will call the theater-service method which will retain all the movies for a particular city
onClickCity(city){
this.theaterService.getAllTheater(city).subscribe(data => this.theatre = data);
}

//this function will push the time to the timeSlot array
// onClickCheckbox(t){

//   this.timeSlot.push(t);
  
// }
 nineClicked() {
  // if (!this.flag1) {
  //   this.flag1 = true;
  //   this.timeSlot.push('9-12 p.m');
  // }else {
  //   this.flag1 = false;
  //   this.timeSlot.splice(this.timeSlot.indexOf('9-12 p.m'),1);
  // }
  this.time = "09:00,";
  console.log(this.time);
}

twelveClicked() {
  // if (!this.flag2) {
  //   this.flag2 = true;
  //   this.timeSlot.push("12-3 p.m");
  // }else {
  //   this.flag2 = false;
  //   this.timeSlot.splice(this.timeSlot.indexOf("12-3 p.m"),1);
  // }
  this.time1 = "12:00,";
  console.log(this.time1);
}

threeClicked() {
  // if (!this.flag3) {
  //   this.flag3 = true;
  //   this.timeSlot.push("3-6 p.m");
  // }else {
  //   this.flag3 = false;
  //   this.timeSlot.splice(this.timeSlot.indexOf("3-6 p.m"),1);
  // }
  this.time2 = "15:00,";
  console.log(this.time2);
}
sixClicked() {
  // if (!this.flag4) {
  //   this.flag4 = true;
  //   this.timeSlot.push("6-9 p.m");
  // }else {
  //   this.flag4 = false;
  //   this.timeSlot.splice(this.timeSlot.indexOf("6-9 p.m"),1);
  // }
  this.time3 = "18:00,";
  console.log(this.time3);
}

//this function will set category with price
onClickSet(category,price){
this.weekdaysPrice.push(category+':'+price);
console.log(this.weekdaysPrice);
}

onClickSetPrice(category,price){
  this.weekendsPrice.push(category+':'+price);
  console.log(this.weekendsPrice);
  }

//on initialization this method will load the theater details for a particular producer emailId
  ngOnInit() {
  this.theaterService.getAllTheater(this.producerId).subscribe(
    data => this.theatre = data
  )
  this.city = this.theatre.theatreCity;
  
  }

  //this method will call producerService and get the movies according to city
  onSelect(){
    this.producerService.getAllMovie(this.theatre.theatreCity).subscribe(
      data => this.movie = data
    )
    console.log(this.theatre);
   
  }
}

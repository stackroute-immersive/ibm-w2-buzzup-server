import { Distributor } from './../distributor';
import { Component, OnInit } from '@angular/core';
import {Screening} from '../screening-details';
import { ProducerService } from '../producer.service';
import { TheaterService } from '../theater.service';
import { MovieScreeningService } from '../movie-screening.service';
import { Theater } from '../theater';


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
  public price: number;
  public movieDate: Date = new Date();
  public selectedTheater:string;
  public city: string;
  screening: Screening = new Screening();
  theater: Theater = new Theater();
  distributor: Distributor = new Distributor();
  public flag1: boolean = false;
  public flag2: boolean = false;
  public flag3: boolean = false;
  public flag4: boolean = false;


  timings: Timing[] =[{timeSlot:'9 a.m - 12 p.m'},{timeSlot:'12 p.m - 3 p.m'},{timeSlot:'3 p.m - 6 p.m'},{timeSlot:'6 p.m - 9 p.m'}]
  constructor(private theaterService:TheaterService, private producerService:ProducerService, private screeningService:MovieScreeningService) {
    
  }

// onSubmit function, it passes the screening object to the screening-service function 
onSubmit(){ 
  this.screening.city = this.theater.theaterCity;
  this.screening.theater = this.theater;
  this.screening.movieName = this.movieName;
  // this.screening.seatCategory = this.seatCategory;
  this.screening.ticketPrice = this.ticketPrice;
  this.screening.timeSlot = this.timeSlot;
  this.screening.movieDate = this.movieDate;
  //console.log(this.distributor);
  this.screeningService.createMovieScreening(this.screening).subscribe(
    data => console.log(data)
  );
  
}

//this function will call the theater-service method which will retain all the movies for a particular city
onClickCity(city){
this.theaterService.getAllTheater(city).subscribe(data => this.theater = data);
}

//this function will push the time to the timeSlot array
// onClickCheckbox(t){

//   this.timeSlot.push(t);
  
// }
 nineClicked() {
  if (!this.flag1) {
    this.flag1 = true;
    this.timeSlot.push('9-12 p.m');
  }else {
    this.flag1 = false;
    this.timeSlot.splice(this.timeSlot.indexOf('9-12 p.m'),1);
  }
  console.log(this.timeSlot);
}

twelveClicked() {
  if (!this.flag2) {
    this.flag2 = true;
    this.timeSlot.push("12-3 p.m");
  }else {
    this.flag2 = false;
    this.timeSlot.splice(this.timeSlot.indexOf("12-3 p.m"),1);
  }
  console.log(this.timeSlot);
}

threeClicked() {
  if (!this.flag3) {
    this.flag3 = true;
    this.timeSlot.push("3-6 p.m");
  }else {
    this.flag3 = false;
    this.timeSlot.splice(this.timeSlot.indexOf("3-6 p.m"),1);
  }
  console.log(this.timeSlot);
}
sixClicked() {
  if (!this.flag4) {
    this.flag4 = true;
    this.timeSlot.push("6-9 p.m");
  }else {
    this.flag4 = false;
    this.timeSlot.splice(this.timeSlot.indexOf("6-9 p.m"),1);
  }
  console.log(this.timeSlot);
}

//this function will set category with price
onClickSet(category,price){
this.ticketPrice.push(category+':'+price);
console.log(this.timeSlot);
}

//on initialization this method will load the theater details for a particular producer emailId
  ngOnInit() {
  this.theaterService.getAllTheater(this.producerId).subscribe(
    data => this.theater = data
  )
  this.city = this.theater.theaterCity;
  
  }

  //this method will call producerService and get the movies according to city
  onSelect(){
    this.producerService.getAllMovie(this.theater.theaterCity).subscribe(
      data => this.distributor = data
    )
  }
}

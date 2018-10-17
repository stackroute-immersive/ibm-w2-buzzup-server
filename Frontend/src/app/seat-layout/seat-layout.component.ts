import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import * as Stomp from '@stomp/stompjs';
import * as SockJS from 'sockjs-client';
import { DataService } from "../data.service";
import { Searchedmovie } from '../searched-movies';
import {BookingDetails} from '../ticket-details';
import { TokenStorage } from '../core/token.storage';

//import { GridLayout } from "ui/layouts/grid-layout";

@Component({
  selector: 'app-seat-layout',
  templateUrl: './seat-layout.component.html',
  styleUrls: ['./seat-layout.component.css']
})
export class SeatLayoutComponent implements OnInit {

  // public reserved: number[] = new Array(11,12);
  ticketDetails: BookingDetails = new BookingDetails();
  movie: Searchedmovie = new Searchedmovie();
  imgsrc: string = "src/assets/seat_available.png";
  greetings: string[] = [];
  disabled = true;
  name: string;
  private stompClient = null;
  private userName :string;

//variable declarations
movieTitle:string = "Captain America: The Winter Soldier";
screen: string = "LUXE CINEMAS";
time: string = "6:45PM";

price: number;
slot: string;

rows: string[] = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'];
cols: number[]  = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

// reserved: string[] = ['A2', 'A3', 'F5', 'F1', 'F2','F6', 'F7', 'F8', 'H1', 'H2', 'H3', 'H4'];
// selected: string[] = [];
reserved: string[] = ['A2', 'A3', 'F5', 'F1', 'F2','F6', 'F7', 'F8', 'H1', 'H2', 'H3', 'H4'];
selected: string[] = [];

// ticketPrice: number = 120;
// convFee: number = 30;
// totalPrice: number = 0;
// currency: string = "Rs";

//return status of each seat
getStatus = function(seatPos: string) {
  if(this.reserved.indexOf(seatPos) !== -1) {
      return 'reserved';
  } else if(this.selected.indexOf(seatPos) !== -1) {
      return 'selected';
  }
}
//clear handler
clearSelected = function() {
  this.selected = [];
}

//click handler
seatClicked = function(seatPos: string) {
  var index = this.selected.indexOf(seatPos);
  
  if(index !== -1) {
      // seat already selected, remove
      this.selected.splice(index, 1)
  } else {
      //push to selected array only if it is not reserved
      if(this.reserved.indexOf(seatPos) === -1)
          this.selected.push(seatPos);
  }
}

//Buy button handler
showSelected() {
  this.ticketDetails.emailId = this.userName;
  this.ticketDetails.movieName = this.movie.movieName;
  this.ticketDetails.city = this.movie.theatres[0].theatreLocation;
  this.ticketDetails.time = this.time;
  this.ticketDetails.price = this.selected.length * 200;
  this.ticketDetails.showId = this.movie.movieName;
  this.ticketDetails.theatreName = this.movie.theatres[0].theatreName;
  this.ticketDetails.bookTickets = this.selected;
  this.dataService.saveTicket(this.ticketDetails);
  if(this.selected.length > 0) {
      alert("Selected Seats: " + this.selected);
    
  } else {
      alert("No seats selected!");
  }
  this.stompClient.send(
    '/hello',
    {},
    JSON.stringify({ 'selected': this.selected })
  );
this.route.navigate(['/payment']);

}

/* onSubmit(){
  this.route.navigate(['/payment']);
} */
  constructor(private route:Router,private dataService:DataService, private token: TokenStorage) { 
    this.userName=token.getUserId();

  }

  ngOnInit() {
    this.time = this.dataService.returnSlot();
    this.price = this.dataService.returnCategory();
    this.slot = this.dataService.returnSlot();
    this.dataService.getMovieByName().subscribe(data => this.movie = data[0]);
    const socket = new SockJS('http://localhost:8080/stomp-endpoint');
    this.stompClient = Stomp.over(socket);
    const that = this;
    this.stompClient.connect({}, function (frame) {
      console.log('Connected: ' + frame);

      that.stompClient.subscribe('/topic/hi', function (hello) {
        that.showGreeting(JSON.parse(hello.body).selected);
      });
    });
  }
  showGreeting(message) {
   this.reserved= this.reserved.concat(message);
    console.log(this.reserved);
  }


}

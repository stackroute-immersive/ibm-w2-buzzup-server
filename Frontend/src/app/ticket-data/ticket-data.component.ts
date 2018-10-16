import { Show } from './../show';
import { Component, OnInit } from '@angular/core';
import {TicketingService} from '../ticketing.service';
import { DataService } from "../data.service";
import { BookingDetails } from './../ticket-details';
import { Searchedmovie } from '../searched-movies';


@Component({
  selector: 'app-ticket-data',
  templateUrl: './ticket-data.component.html',
  styleUrls: ['./ticket-data.component.css']
})
export class TicketDataComponent implements OnInit {

  movie: Searchedmovie = new Searchedmovie();

  public ticket: BookingDetails = new BookingDetails();

  constructor(private ticketingService:TicketingService, private dataService:DataService) { }
  public  showId: string;
    
  show:Show=new Show();
  
 


ngOnInit() {
  this.ticket = this.dataService.returnTicket();
  this.dataService.getMovieByName().subscribe(data => this.movie = data[0]);


  // this.ticketingService.getTicketById(this.showId).subscribe(data => this.show = data);
  // this.showId=this.show.showId;
 
    // this.movieService.getMovieByName('sairat').subscribe(data => this.movie = data);
    // console.log(this.movie);
  
}
  

}

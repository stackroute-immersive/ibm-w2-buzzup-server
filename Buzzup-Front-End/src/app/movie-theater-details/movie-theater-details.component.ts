import { DataService } from './../data.service';
import { MovieScreeningService } from './../movie-screening.service';
import { MovieSchedule } from './../screening-details';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Searchedmovie } from '../searched-movies';
import { MovieService } from './../movie.service';


export interface Theater{
   theatername:string;
   theaterCity: string;
   theaterAddress: string;
   theaterCategory: Array<string>;
   timeSlot: Array<string>;
   ticketPrice: Array<string>;
}

@Component({
  selector: 'app-movie-theater-details',
  templateUrl: './movie-theater-details.component.html',
  styleUrls: ['./movie-theater-details.component.css']
})
export class MovieTheaterDetailsComponent implements OnInit {

  movie: Searchedmovie = new Searchedmovie();

 // screenings: MovieSchedule[] = new Array();
 //screenings: MovieSchedule = new MovieSchedule();
 // screening: Screening = new Screening();
  theaters : Theater[] = [{theatername:'PVR',theaterCity:'Pune',theaterAddress:'xyz',theaterCategory:['platinum','gold','silver'],timeSlot:['9-12 p.m','12-3 p.m'],ticketPrice:['platinum : 400','gold : 300','silver : 200']},
  {theatername:'PVR',theaterCity:'Bangalore',theaterAddress:'xyz',theaterCategory:['platinum','gold','silver'],timeSlot:['3-6 p.m','6-9 p.m'],ticketPrice:['platinum : 500','gold : 400','silver : 300']},{theatername:'PVR',theaterCity:'Mumbai',theaterAddress:'xyz',theaterCategory:['platinum','gold','silver'],timeSlot:['9-12 p.m','12-3 p.m'],ticketPrice:['platinum : 400','gold : 300','silver : 200']}];
  constructor(private router:Router, private movieScreeningService:MovieScreeningService,private movieService: MovieService, private data:DataService) { }

  ngOnInit() {
    //this.moviename = this.movieName;
    // this.movieService.getMovieByName('Dilwale Dulhaniya Le Jayenge').subscribe(data => this.movie = data[0]);
    this.data.getMovieByName().subscribe(data => this.movie = data[0]);

  // this.movieScreeningService.getDetailsByMovie('The Nun').subscribe(
  //   data => this.screenings = data
  // );
  //console.log(this.screenings);
  }

  onSubmit(){
     console.log(this.movie);

    this.router.navigate(['seatlayout']);
  }

}

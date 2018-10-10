import { Movielist } from './../movie-list';
import { MovieService } from './../movie.service';
import { Component, OnInit } from '@angular/core';
import { DataService } from './../data.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-city-movie-details',
  templateUrl: './city-movie-details.component.html',
  styleUrls: ['./city-movie-details.component.css']
})
export class CityMovieDetailsComponent implements OnInit {

  public message: string;
  public movielist:Movielist = new Movielist();
  constructor(private movieService:MovieService, private data:DataService, private route:Router) { }

  ngOnInit() {
    // this.movieService.getMovieByCity('pune').subscribe(
    //   data => this.movielist = data
    // )
    this.data.getMovieByCity().subscribe(data=>this.movielist=data);
  }
  onClick(name:string){
    this.message = name;
    this.data.changeMessage(this.message);
    console.log(this.message);
    this.route.navigate(['/search']);
    }
}

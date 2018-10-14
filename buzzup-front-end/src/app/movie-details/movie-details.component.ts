import { Router } from '@angular/router';
import { DataService } from './../data.service';
import { Movie } from './../movies';
import { Searchedmovie } from '../searched-movies';
import { HttpClient } from '@angular/common/http';
import { MovieService } from './../movie.service';
import { Component, OnInit, Input } from '@angular/core';



@Component({
  selector: 'app-movie-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.css']
})
export class MovieDetailsComponent implements OnInit {

  constructor(private movieService: MovieService, private data:DataService, private route:Router) {

  }
  public message: string;
  @Input() movieName:string;
  public moviename: string;

  movie: Searchedmovie = new Searchedmovie();

onClick(msg:string){
  this.data.changeMessage(msg);
  this.route.navigate(['/theatredetails']);
  console.log(this.movie);
}
  ngOnInit() {
    this.moviename = this.movieName;
    this.data.getMovieByName().subscribe(data => this.movie = data[0]);
    // this.movieService.getMovieByName('Dilwale Dulhaniya Le Jayenge').subscribe(data => this.movie = data[0]);
    
    this.movieName = this.movie.movieName;



  }

}

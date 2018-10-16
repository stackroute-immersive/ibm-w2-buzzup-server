import { Component, OnInit, ViewChild, ElementRef, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from './../data.service';
import { MovieDetailsComponent } from './../movie-details/movie-details.component';
@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
  
})
export class HomePageComponent implements OnInit {

  public movieName="Dilwale_Dulhaniya";
  public message: string;
  public city:string;
  constructor(private data:DataService, private route:Router) { }
  onClick(name:string){
  this.message = name;
  this.data.changeMessage(this.message);
  console.log(this.message);
  this.route.navigate(['/search']);
  }
  onSelect(city:string){
  this.city = city;
  this.data.changeCity(this.city);
  console.log(this.city);
  this.route.navigate(['/movies']);
  }

  ngOnInit() {
  }

}

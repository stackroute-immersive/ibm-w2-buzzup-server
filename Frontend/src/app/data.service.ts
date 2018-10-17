import { Movielist } from './movie-list';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';
import {Observable} from 'rxjs';
import { Movie } from './movies';
import { Injectable } from '@angular/core';
import {BookingDetails} from './ticket-details';


@Injectable({providedIn: 'root'})
export class DataService{
    ticketDetails: BookingDetails = new BookingDetails();
    url = 'http://localhost:8089';
    newmsg:string;
    time:string;
    cityName:string;
    category: number;
    private messageSource = new BehaviorSubject<string>("default message");
    currentMessage = this.messageSource.asObservable;
    constructor(private _http: HttpClient){}
    changeMessage(message:string){
        this.newmsg = message;
        console.log(this.newmsg);
       // this.messageSource.next(message);
        // this.getMovieByName(message);
    }

    setSlot(time:string){
this.time = time;
    }
    returnSlot(){
        return this.time;
    }
    setCategory(cat:number){
this.category= cat;
    }
    returnCategory(){
        return this.category;
    }
   saveTicket(ticket:BookingDetails){
       this.ticketDetails = ticket;
   }
   returnTicket(){
    return this.ticketDetails;
   }

    changeCity(city:string){
     this.cityName = city;
    }

    getMovieByName():Observable<Movie>{
        return this._http.get<Movie>(`${this.url}/api/v1/movie/`+ this.newmsg);
      }
    getMovieByCity():Observable<Movielist>{
        return this._http.get<Movielist>(`${this.url}/api/v1/city/`+this.cityName);
    }
}
import { Movielist } from './movie-list';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';
import {Observable} from 'rxjs';
import { Movie } from './movies';
import { Injectable } from '@angular/core';


@Injectable({providedIn: 'root'})
export class DataService{
    
    url = 'http://localhost:8089';
    newmsg:string;
    cityName:string;
    private messageSource = new BehaviorSubject<string>("default message");
    currentMessage = this.messageSource.asObservable;
    constructor(private _http: HttpClient){}
    changeMessage(message:string){
        this.newmsg = message;
        console.log(this.newmsg);
       // this.messageSource.next(message);
        // this.getMovieByName(message);
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
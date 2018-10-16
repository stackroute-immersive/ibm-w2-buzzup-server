import { Movielist } from './movie-list';
import { Movie } from './movies';
import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MovieService {
  
  constructor(private _http: HttpClient) { }
  
  url = 'http://localhost:8089';

  getMovieByName(movieName):Observable<Movie>{
    return this._http.get<Movie>(`${this.url}/api/v1/movie/`+ movieName);
  }

  getMovieByCity(cityName):Observable<Movielist>{
    return this._http.get<Movielist>(`${this.url}/api/v1/city/`+cityName);
  }
}
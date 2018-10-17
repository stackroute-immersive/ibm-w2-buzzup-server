import { MovieSchedule } from './screening-details';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MovieScreeningService {

  constructor(private _http: HttpClient) { }
  url = 'http://localhost:8082';

  //this method will pass the screening object to the backend server
  createMovieScreening(screening): Observable<MovieSchedule>{
    return this._http.post<MovieSchedule>(`${this.url}/api/v1/add`, screening);
  }

  getDetailsByMovie(movieName): Observable<any>{
    return this._http.get<any>(`${this.url}/api/v1/movie/moviename/`+movieName);
  }
}

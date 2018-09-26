import { Screening } from './screening-details';
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
  createMovieScreening(screening): Observable<Screening>{
    return this._http.post<Screening>(`${this.url}/api/v1/movie`, screening);
  }
}

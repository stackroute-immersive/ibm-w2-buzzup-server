import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProducerService {

  constructor(private _http: HttpClient) { }
  url = 'http://localhost:8088';
  //this method will retrive all the movies based on cities
  getAllMovie(city): Observable<any>{
    return this._http.get<any>(`${this.url}/api/v1/movie/`+city);
  }
}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TheaterService {

  
  constructor(private _http: HttpClient) { }
  url = 'http://localhost:8087';

  //this method will return the theater for a producer emailId
  getAllTheater(id): Observable<any>{
    return this._http.get<any>(`${this.url}/api/v1/theatre/`+id);
  }
}

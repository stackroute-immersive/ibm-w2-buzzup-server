import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Rsvp } from './rsvp';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RsvpShowService {

  events:Array<Rsvp>;
  constructor(private http: HttpClient) { }
  showEvent() :  Observable<Array<Rsvp>>
  {
    return this.http.get<Array<Rsvp>>("http://localhost:8081/api/v1/events");
  }


}



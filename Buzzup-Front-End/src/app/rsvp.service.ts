import { Injectable } from '@angular/core';
import { Rsvp } from './rsvp';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RsvpService {

  rsvp=new Rsvp();
  constructor(private http: HttpClient) {
    this.http=http;
  }

  getEvent(rsvp:Rsvp) : Observable<any>
  {
    this.rsvp=rsvp;
    console.log(this.rsvp);
    return this.http.post<Rsvp>("http://localhost:8081/api/v1/event",rsvp);
  }
}

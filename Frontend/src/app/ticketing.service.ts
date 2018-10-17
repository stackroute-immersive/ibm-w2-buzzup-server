import { Show } from './show';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TicketingService {

  constructor(private _http: HttpClient) { }

  url = 'http://localhost:8082';

  getTicketById(showId):Observable<Show>{
  return this._http.get<Show>(`${this.url}/api/v1/ticket/show`+ showId);
}
}


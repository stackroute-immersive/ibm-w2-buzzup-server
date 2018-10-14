import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { BookingDetails } from './ticket-details';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SaveTicketService {

  constructor(private http:HttpClient) { }
  url = 'http://localhost:8083';
  createTicket(ticket): Observable<BookingDetails>{
    return this.http.post<BookingDetails>(`${this.url}/payment/bookticket`, ticket);
  }
}

import { Injectable } from '@angular/core';
import { FullBookingDetails } from './FullBookingDetails';
@Injectable({
  providedIn: 'root'
})
export class BookingDetailsService {
public booking:FullBookingDetails=new FullBookingDetails();
  constructor() { }
  send(bookedData:FullBookingDetails) {
    this.booking = bookedData;
  }
  receive() {
    console.log("receive" + this.booking.nameOfMovie);
    return this.booking;
  }
}

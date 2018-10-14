import { Router } from '@angular/router';
import { BookingDetails } from './../ticket-details';
import { SaveTicketService } from './../save-ticket.service';
import { PaymentService } from './../payment.service';
import { Component, OnInit } from '@angular/core';
import { Http, Headers} from '@angular/http';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  public ticket: BookingDetails = new BookingDetails();
  public emailId : string;
  public theatreName : string;
  public time : string;
  public city : string;
  public price : number;
  public showId : string;
  public movieName : string;
  public bookTickets : Array<number> ;
  constructor(private payment:PaymentService, private ticketService:SaveTicketService, private route:Router) { }

  ngOnInit() {
  }

  chargeCreditCard() {
    let form = document.getElementsByTagName("form")[0];
    (<any>window).Stripe.card.createToken({
      number: form.cardNumber.value,
      exp_month: form.expMonth.value,
      exp_year: form.expYear.value,
      cvc: form.cvc.value
    }, (status: number, response: any) => {
      if (status === 200) {
        //this.route.navigate(['/success']);
alert('you have successfully booked your ticket');
        let token = response.id;
       this.payment.chargeCard(token);
      } else {
alert('enter valid credentials');
        console.log(response.error.message);
      }
    });
  }
  saveTicket(){
    console.log("ticket saved");
    this.ticket.emailId = this.emailId;
    this.ticket.movieName = this.movieName;
    this.ticket.price = this.price;
    this.ticket.showId = this.showId;
    this.ticket.theatreName = this.theatreName;
    this.ticket.time = this.time;
    this.ticket.bookTickets = this.bookTickets;
    this.ticket.city = this.city;

    this.ticketService.createTicket(this.bookTickets).subscribe(
      data => console.log(data)
    );
  }
}

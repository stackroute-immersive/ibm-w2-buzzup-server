import { PaymentService } from './../payment.service';
import { Component, OnInit } from '@angular/core';
import { Http, Headers} from '@angular/http';


@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  constructor(private payment:PaymentService) { }

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
        let token = response.id;
       this.payment.chargeCard(token);
      } else {
        console.log(response.error.message);
      }
    });
  }
}

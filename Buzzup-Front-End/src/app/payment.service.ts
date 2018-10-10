import { Injectable } from '@angular/core';
import { Http, Headers} from '@angular/http';


@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  constructor(private http: Http) { }

  chargeCard(token: string) {
    const headers = new Headers({'token': token, 'amount': 100});
    this.http.post('http://localhost:8080/payment/charge', {}, {headers: headers})
      .subscribe(resp => {
        console.log(resp);
      })
  }
}

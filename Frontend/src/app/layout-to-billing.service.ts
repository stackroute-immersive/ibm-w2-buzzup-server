import { Injectable } from '@angular/core';
import { FullBookingDetails } from './FullBookingDetails';
@Injectable({
  providedIn: 'root'
})
export class LayoutToBillingService {
  public billingObj:FullBookingDetails;
  constructor() { }
  sendToBilling(BillDetail)
  {
 this.billingObj=BillDetail;
  }
  getAtBilling(){
    return this.billingObj;
  }
}

import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { map } from "rxjs/operators";
@Injectable({
  providedIn: "root"
})
export class BookingLayoutService {
  data: any;
  private _url = "http://localhost:dummy";

  constructor(private http: HttpClient) {}
  saveTickeDetails(id: string) {
    return this.http.post(this._url + "/" + id, "");
  }
}

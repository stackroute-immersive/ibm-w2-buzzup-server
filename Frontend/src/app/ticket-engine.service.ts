import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from "@angular/common/http";
import { map } from "rxjs/operators";
import { Layout } from "./layout";
@Injectable({
  providedIn: "root"
})
export class TicketEngineService {
  data;
  url = "http://127.0.0.1:9079/api/v1/ticket/layout";
  url1 = "http://127.0.0.1:9079/api/v1/ticket/update";
  constructor(private http: HttpClient) {}
  getseatDetails(showId): Observable<Layout[]> {
    console.log("inside service class");
    return this.http
      .get<Layout[]>(this.url + "/" + showId)
      .pipe(map(res => (this.data = res)));
  }
  getData(showId,blockedSeatsArray) {
    console.log("inside getData call");
    return this.http.put(this.url1 + "/" + showId,blockedSeatsArray);
    // return this.http.get(this.url2);
  }
}

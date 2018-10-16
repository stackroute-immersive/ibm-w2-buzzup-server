import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { UserRegistration } from "./user-registration";

@Injectable({
  providedIn: "root"
})
export class RegistrationService {
 private _url1: string = "http://localhost:8092/api/v1/userProfile/regestration";

  constructor(private http: HttpClient) {}

  addUser(user: UserRegistration): Observable<UserRegistration> {
    return this.http.post<UserRegistration>(this._url1, user);
  }
}

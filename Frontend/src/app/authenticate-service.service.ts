import { Injectable } from '@angular/core';
import { User } from './login';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({'Content-type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class AuthenticateServiceService {

  private url: string = 'http://localhost:8084/api/login';

  
  constructor(private http: HttpClient) { }

  getUser(user:User) : Observable<any>
  {
    console.log(user);
    return this.http.post<User>(this.url,user,httpOptions)
    .pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse){
    if(error.error instanceof ErrorEvent){
      console.log('An error occured: ', error.error.message);
    }
    else{
      console.log(`Backend returned code ${error.status}`, + `body was:- ${error.error}`);
    }
    console.log(`Backend returned code ${error.status}`, + `body was:- ${error.error}`);
    return throwError('Something went wrong please try again', );
  }
};



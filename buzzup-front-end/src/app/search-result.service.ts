import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import{Router} from '@angular/router';
import { BehaviorSubject } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class SearchResultService {
  constructor(private http: HttpClient) { }

  getSearchedMovies(name) { 
    console.log(name);
   return this.http.get('/api/v1/movies/'+name)
   }
   
}

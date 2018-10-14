import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/data.service';
import { Router } from '@angular/router';
import { TokenStorage } from '../core/token.storage';

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit {
  public movieName="Dilwale_Dulhaniya";
  public message: string;
  public city:string;
  userName:string;
  constructor(private data:DataService, private route:Router,private tokenStorage: TokenStorage) 
  { 
    this.userName = tokenStorage.getUserName();  
  }
  onClick(name:string){
    this.message = name;
    this.data.changeMessage(this.message);
    console.log(this.message);
    this.route.navigate(['/search']);
    }
    onSelect(city:string){
    this.city = city;
    this.data.changeCity(this.city);
    console.log(this.city);
    this.route.navigate(['/movies']);
    }
  ngOnInit() {
  }

}

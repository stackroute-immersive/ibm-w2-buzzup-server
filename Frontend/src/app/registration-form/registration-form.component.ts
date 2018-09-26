import { Component, OnInit } from "@angular/core";
import {MatSnackBar} from '@angular/material';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserRegistration } from "../user-registration";
import { RegistrationService } from "../registration.service";
import { Router } from '@angular/router';


export interface Language {
  value: string;
  viewValue: string;
}

@Component({
  selector: "app-registration-form",
  templateUrl: "./registration-form.component.html",
  styleUrls: ["./registration-form.component.css"]
})
export class RegistrationFormComponent implements OnInit {
 // user= new UserRegistration;

 userMobile: string;
 emailId: string;
 password: string;
 userName: string;
 userGender: string;
 age: string;
 city: string;
 fburl: string;
 twitterurl: string;
 prefLang: string[]= new Array();

user:UserRegistration = new UserRegistration();
  hide = true;
  isLinear = true;
  movieGenere: string[]= new Array();
  eventCategory: string[]= new Array();
  languages: Language[] = [
    { value: 'english', viewValue: 'English' },
    { value: 'hindi', viewValue: 'Hindi' },
    { value: 'bengali', viewValue: 'Bengali' },
    { value: 'telugu', viewValue: 'Telugu' },
    { value: 'tamil', viewValue: 'Tamil' },
    { value: 'marathi', viewValue: 'Marathi' },
    { value: 'punjabi', viewValue: 'Punjabi' },
    { value: 'kannada', viewValue: 'Kannada' }
  ];

  constructor(private formBuilder: FormBuilder,private registrationService: RegistrationService, private router:Router) { }

  ngOnInit() {
  }
onclick(m){
this.movieGenere.push(m);
console.log(this.movieGenere);
}
onclickevent(n){
  this.eventCategory.push(n);
  console.log(this.eventCategory);
  }
  onSubmit() {
    this.user.userMobile = this.userMobile;
    this.user.userName = this.userName;
    this.user.emailId = this.emailId;
    this.user.password = this.password;
    this.user.age = this.age;
    this.user.city = this.city;
    this.user.fburl = this.fburl;
    this.user.prefLang = this.prefLang;
    this.user.twitterurl = this.twitterurl;
    this.user.userGender = this.userGender;
    this.user.movieGenre = this.movieGenere;
    this.user.eventCategory = this.eventCategory;
      this.registrationService
      .addUser(this.user)
      .subscribe(data => console.log(data)
       );
       this.router.navigate(['/']);
      
  }


  selectLanguage(t){
    this.prefLang.push(t);
  }
}
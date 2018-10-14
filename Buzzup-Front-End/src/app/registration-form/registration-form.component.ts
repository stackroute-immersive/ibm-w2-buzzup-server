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
export interface Cities {
  value: string;
}

@Component({
  selector: "app-registration-form",
  templateUrl: "./registration-form.component.html",
  styleUrls: ["./registration-form.component.css"]
})
export class RegistrationFormComponent implements OnInit {

 userMobile: string;
 emailId: string;
 password: string;
 userName: string;
 userGender: string;
 age: string;
 city: string;
 cityName: string;
 fburl: string;
 twitterurl: string;
 prefLang: string[]= new Array();


 formGroup1: FormGroup;
 formGroup2: FormGroup;
 formGroup3: FormGroup;
 formGroup4: FormGroup;

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
  cities: Cities[] = [
    {value:'Delhi'},
    {value:'Bengaluru'},
    {value:'Pune'},
    {value:'Chennai'},
    {value:'Hyderabad'}
  ]

  setCity(city:string){
    this.city = city;
  }
  constructor(private formBuilder: FormBuilder,private registrationService: RegistrationService, private router:Router) { }

  ngOnInit() {

    this.formGroup1 = this.formBuilder.group({

      userMobile: ['', [Validators.required, Validators.minLength(10)]],
      emailId: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });

    this.formGroup2 = this.formBuilder.group({
      userName: [''],
      age: [''],
      // city: [''],
      userGender: ['']

    });
    this.formGroup3 = this.formBuilder.group({
      fburl: [''],
      twitterurl: ['']
    });
    
    this.formGroup4 = this.formBuilder.group({
      
      prefLang: ['']
    });


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
    console.log(this.user);

      this.registrationService
      .addUser(this.user)
      .subscribe(data => console.log(data)
       );
       this.router.navigate(['/login']);
      
  }


  selectLanguage(t){
    this.prefLang.push(t);
  }
}

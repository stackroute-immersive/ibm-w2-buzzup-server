import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { User } from '../login';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { AuthenticateServiceService } from '../authenticate-service.service';
//import { error } from '@angular/compiler/src/util';
import { TokenStorage } from '../core/token.storage';

@Component({
  selector: 'app-authenticate',
  templateUrl: './authenticate.component.html',
  styleUrls: ['./authenticate.component.css']
})
export class AuthenticateComponent implements OnInit {

  form1: FormGroup;
  submitted = false;
  emailId:string = '';
  userName:string ='';
  userRole:string = '';
  user:User=new User();
  error: any;
  constructor(private formBuilder: FormBuilder,private authenticateService : AuthenticateServiceService,private http : HttpClient, private token: TokenStorage, private router:Router) { 

  this.user.emailId = token.getUserId();
  this.user.userRole = token.getUserRole();
  this.user.userName =token.getUserName();

  }

  ngOnInit() 
  {
    this.form1=this.formBuilder.group({
      emailId: ['', [Validators.required,Validators.email]],
      password: ['', [Validators.required,Validators.minLength(6)]]
    });
  }

  onSubmit(user,http): void
  {
  
    console.log(this.user);
    this.user= user;
    this.submitted = true;

        // stop here if form is invalid
  
    this.authenticateService.getUser(this.user).subscribe
      (
          
        data => {
          this.token.saveToken(data['token'], data['emailId'], data['userRole']);
          if(this.user.userRole=='producer'){
            this.router.navigate(['/dashboard']);
          }
          else 
            this.router.navigate(['/user']);
          error => this.error = error;  
        }
      );
      
     

  }

}

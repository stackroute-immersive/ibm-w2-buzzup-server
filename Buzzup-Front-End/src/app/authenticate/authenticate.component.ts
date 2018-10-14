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
 emailId:string ;
 userName:string ='';
 password: string;
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

 onSubmit(http): void
 {

   

   this.user.emailId= this.emailId;
   this.user.password = this.password;
   console.log(this.user);
   this.submitted = true;

       // stop here if form is invalid

   this.authenticateService.getUser(this.user).subscribe
     (

       data => {
         this.token.saveToken(data['token'], data['emailId'], data['userRole'], data['userName']);
         if(this.user.userRole=='producer'){
           this.router.navigate(['/dashboard']);
         }
        
         else if(this.user.userRole=='consumer')
           this.router.navigate(['/user-page']);
        } ,
          //  else
          //  alert('Please Enter Valid Credentials');
      
         error =>{
          this.error = error;
          alert('Please Enter Valid Credentials');
         } 
         
         
       
     );


this.authenticateService.getUser(this.user).subscribe
     (

       data => {
         this.token.saveToken(data['token'], data['emailId'], data['userRole'], data['userName']);
         if(this.user.userRole=='producer'){
           this.router.navigate(['/dashboard']);
         }
        
         else if(this.user.userRole=='consumer')
           this.router.navigate(['/user-page']);
        } ,
          //  else
          //  alert('Please Enter Valid Credentials');
      
         error =>{
          this.error = error;
 });

}
}
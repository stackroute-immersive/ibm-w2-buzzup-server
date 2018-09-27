import { Component, OnInit } from '@angular/core';
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

  user:User=new User();
  error: any;
  constructor(private authenticateService : AuthenticateServiceService,private http : HttpClient,private token: TokenStorage, private router:Router) { }

  ngOnInit() {
  }

  onSubmit(user,http): void
  {
    this.user.email_id=user.emailId;
    this.user.password=user.password;
    this.user.user_role=user.user_Role;
    console.log(this.user);
    //this.postUser(user,http);
    this.authenticateService.getUser(this.user).subscribe
      (
        data => {
          this.token.saveToken(data['token'], data['email_Id'], data['user_role']);
          if(this.user.email_id=='deba@gmail.com'){
           this.router.navigate(['/dashboard']);
         }
         else
         this.router.navigate(['']);
          error => this.error = error;  
        }
      );
     

  }
  // postUser(user,http)
  // {
  //   this.userService.getUser(this.user).subscribe(data=>console.log(data));
  // }

}

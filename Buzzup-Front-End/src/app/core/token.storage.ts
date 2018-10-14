import { Injectable } from "@angular/core";
import { JwtHelperService } from "@auth0/angular-jwt";

const TOKEN_KEY = 'AuthToken';
const USER_ID = 'emailId';
const USER_NAME='userName';
const USER_ROLE= 'userRole';
const helper = new JwtHelperService();

@Injectable()
export class TokenStorage {

   decodedToken: any;
   emailId:any;
   userName:any;
   userRole:any;
   constructor(){}


   public saveToken(token: string, emailId:string ,userRole:string, userName:string){
       this.decodedToken = helper.decodeToken(token);
       this.emailId = this.decodedToken.jti;
       this.userName = this.decodedToken.name;
       this.userRole =this.decodedToken.sub;

       window.sessionStorage.removeItem(TOKEN_KEY)
       window.sessionStorage.removeItem(USER_ID);
       window.sessionStorage.setItem(TOKEN_KEY,token);
       window.sessionStorage.setItem(USER_ID,this.emailId);
       window.sessionStorage.setItem(USER_NAME,this.userName);
       window.sessionStorage.setItem(USER_ROLE,this.userRole);

   }

   public getToken(): string {

       return sessionStorage.getItem(TOKEN_KEY);

   }

   public getUserId(): string {

       return sessionStorage.getItem(USER_ID);
   }

   public getUserName(): string {

       return sessionStorage.getItem(USER_NAME);
   }

   public getUserRole(): string {

       return sessionStorage.getItem(USER_ROLE);
   }
}
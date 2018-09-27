import { Injectable } from "@angular/core";

const TOKEN_KEY = 'AuthToken';
const USER_ID = 'email_id';
const USER_ROLE= 'user_role';

@Injectable()
export class TokenStorage {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             

    constructor(){}


    public saveToken(token: string, email_id:string ,user_role:string){
        window.sessionStorage.removeItem(TOKEN_KEY)
        window.sessionStorage.removeItem(USER_ID);
        window.sessionStorage.setItem(TOKEN_KEY,token);
        window.sessionStorage.setItem(USER_ID,email_id);
        window.sessionStorage.setItem(USER_ROLE,user_role);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
    }

    public getToken(): string {

        return sessionStorage.getItem(TOKEN_KEY);

    }

    public getUserId(): string {

        return sessionStorage.getItem(USER_ID);
    }
}
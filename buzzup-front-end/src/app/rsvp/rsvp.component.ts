import { Component, OnInit } from '@angular/core';

import {FormBuilder, FormGroup, FormControl, Validators} from '@angular/forms';
import { Rsvp } from '../rsvp';

import { HttpClient } from '@angular/common/http';
import { RsvpService } from 'src/app/rsvp.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-rsvp',
  templateUrl: './rsvp.component.html',
  styleUrls: ['./rsvp.component.css']
})
export class RsvpComponent implements OnInit {

  rsvp:Rsvp=new Rsvp();
  recipientEmails : Array<string> = new Array();
  form1: FormGroup;
  emailId:any = '';
  constructor(private formBuilder: FormBuilder, private rsvpService : RsvpService,private http : HttpClient) //private router:Router 
  { 
  }

  ngOnInit() 
  {
    this.form1=this.formBuilder.group({
      emailId: ['', [Validators.required,Validators.email]]
    });
  }

  getErrorMessage() {
    return this.emailId.hasError('required') ? 'You must enter a value' :
        this.emailId.hasError('email') ? 'Not a valid email' :
            '';
  }

  onBook(rsvp,http): void
  {
    this.rsvp=rsvp;

    console.log(this.rsvp);
    this.rsvpService.getEvent(this.rsvp).subscribe(data=>console.log(data));
    // this.router.navigate(['']);
  }

  onAdd(recipientEmail:string)
  {
    this.recipientEmails.push(recipientEmail);
    this.rsvp.recipientEmail =this.recipientEmails;
    console.log(this.recipientEmails);
  }

}

import { Component, OnInit } from '@angular/core';

import { Rsvp } from '../rsvp';
import { RsvpShowService } from 'src/app/rsvp-show.service';
@Component({
  selector: 'app-rsvp-show',
  templateUrl: './rsvp-show.component.html',
  styleUrls: ['./rsvp-show.component.css']
})
export class RsvpShowComponent implements OnInit {

  events : Array<Rsvp> = new Array();
  rsvp : Rsvp=new Rsvp();
  constructor(private rsvpshowService : RsvpShowService) { }

  ngOnInit() {
    this.rsvpshowService.showEvent().subscribe(
      data => this.events=data
    );
  }

}

import { Component, OnInit, ViewChild, ElementRef, Output, EventEmitter } from '@angular/core';
import { animate, state, style, transition, trigger } from '@angular/animations';

import { FormBuilder } from '@angular/forms';
import { SearchResultService } from '../search-result.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  movie$: any;
  message: string;
  searchTitle: string;
  constructor( private data: SearchResultService,
    private formBuilder: FormBuilder) {}

  ngOnInit() { }   
    //this.data.currentMessage.subscribe(message => (this.message = message));
  //   console.log("in search result compoment", this.message);
  //}

  onSearch() {
    // console.log("Search is called ", this.message);
    // localStorage.setItem('searchKey',this.searchTitle);
    this.data.getSearchedMovies(this.searchTitle).subscribe(data => {
      this.movie$ = data;
      console.log(data);
    });
}
}

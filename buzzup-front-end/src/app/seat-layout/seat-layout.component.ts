import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-seat-layout',
  templateUrl: './seat-layout.component.html',
  styleUrls: ['./seat-layout.component.css']
})
export class SeatLayoutComponent implements OnInit {

  public reserved: number[] = new Array(11,12);
  imgsrc: string = "src/assets/seat_available.png";
  public seats: number[][] = new Array([1,2,3,4,5,6,7,8,9,10],[1,2,3,4,5,6,7,8,9,10],[1,2,3,4,5,6,7,8,9,10],[1,2,3,4,5,6,7,8,9,10],[1,2,3,4,5,6,7,8,9,10],[1,2,3,4,5,6,7,8,9,10],[1,2,3,4,5,6,7,8,9,10],[1,2,3,4,5,6,7,8,9,10],[1,2,3,4,5,6,7,8,9,10]);
  public rows: number[] = new Array(1,2,3,4,5,6,7,8,9);
  public columns: number[] = new Array(1,2,3,4,5,6,7,8,9,10);
  public seatPresent: boolean;
  public rowScreen: boolean;
  public theaterId: string;


  onSelect(i,j){
    // this.imgsrc="src/assets/seat_selected.png"
    console.log(i,j);
  }
  constructor() { }

  ngOnInit() {
  }


}

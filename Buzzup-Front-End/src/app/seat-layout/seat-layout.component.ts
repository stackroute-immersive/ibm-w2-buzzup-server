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
    if(i==0){
      console.log(i+j);
      // this.imgsrc="src/assets/seat_selected.png"
    }
    else if(i==1){
      console.log((i+9)+j);
    }
    else if(i==2){
      console.log((i+18)+j);
    }
    else if(i==3){
      console.log((i+27)+j);
    }
    else if(i==4){
      console.log((i+36)+j);
    }
    else if(i==5){
      console.log((i+45)+j);
    }
    else if(i==6){
      console.log((i+54)+j);
    }
    else if(i==7){
      console.log((i+63)+j);
    }
    else if(i==8){
      console.log((i+72)+j);
    }
  }
  constructor() { }

  ngOnInit() {
  }


}

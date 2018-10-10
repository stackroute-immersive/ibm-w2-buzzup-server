import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieTheaterDetailsComponent } from './movie-theater-details.component';

describe('MovieTheaterDetailsComponent', () => {
  let component: MovieTheaterDetailsComponent;
  let fixture: ComponentFixture<MovieTheaterDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MovieTheaterDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MovieTheaterDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

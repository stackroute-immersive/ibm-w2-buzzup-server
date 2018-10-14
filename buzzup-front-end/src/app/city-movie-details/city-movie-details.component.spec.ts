import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CityMovieDetailsComponent } from './city-movie-details.component';

describe('CityMovieDetailsComponent', () => {
  let component: CityMovieDetailsComponent;
  let fixture: ComponentFixture<CityMovieDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CityMovieDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CityMovieDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

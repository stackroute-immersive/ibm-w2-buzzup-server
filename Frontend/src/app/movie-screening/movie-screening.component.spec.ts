import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieScreeningComponent } from './movie-screening.component';

describe('MovieScreeningComponent', () => {
  let component: MovieScreeningComponent;
  let fixture: ComponentFixture<MovieScreeningComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MovieScreeningComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MovieScreeningComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

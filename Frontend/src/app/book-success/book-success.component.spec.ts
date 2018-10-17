import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BookSuccessComponent } from './book-success.component';

describe('BookSuccessComponent', () => {
  let component: BookSuccessComponent;
  let fixture: ComponentFixture<BookSuccessComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BookSuccessComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookSuccessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

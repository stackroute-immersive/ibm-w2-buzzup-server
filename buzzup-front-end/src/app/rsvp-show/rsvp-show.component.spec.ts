import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RsvpShowComponent } from './rsvp-show.component';

describe('RsvpShowComponent', () => {
  let component: RsvpShowComponent;
  let fixture: ComponentFixture<RsvpShowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RsvpShowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RsvpShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

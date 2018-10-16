import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TicketDataComponent } from './ticket-data.component';

describe('TicketDataComponent', () => {
  let component: TicketDataComponent;
  let fixture: ComponentFixture<TicketDataComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TicketDataComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TicketDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

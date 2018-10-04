import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProducerDashboardComponent } from './producer-dashboard.component';

describe('ProducerDashboardComponent', () => {
  let component: ProducerDashboardComponent;
  let fixture: ComponentFixture<ProducerDashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProducerDashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProducerDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

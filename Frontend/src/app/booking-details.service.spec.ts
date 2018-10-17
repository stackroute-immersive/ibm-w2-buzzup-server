import { TestBed, inject } from '@angular/core/testing';

import { BookingDetailsService } from './booking-details.service';

describe('BookingDetailsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BookingDetailsService]
    });
  });

  it('should be created', inject([BookingDetailsService], (service: BookingDetailsService) => {
    expect(service).toBeTruthy();
  }));
});

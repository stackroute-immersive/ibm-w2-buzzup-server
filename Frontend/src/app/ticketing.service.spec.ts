import { TestBed } from '@angular/core/testing';

import { TicketingService } from './ticketing.service';

describe('TicketingService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TicketingService = TestBed.get(TicketingService);
    expect(service).toBeTruthy();
  });
});

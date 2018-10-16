import { TestBed, inject } from '@angular/core/testing';

import { TicketEngineService } from './ticket-engine.service';

describe('TicketEngineService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TicketEngineService]
    });
  });

  it('should be created', inject([TicketEngineService], (service: TicketEngineService) => {
    expect(service).toBeTruthy();
  }));
});

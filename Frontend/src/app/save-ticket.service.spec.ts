import { TestBed, inject } from '@angular/core/testing';

import { SaveTicketService } from './save-ticket.service';

describe('SaveTicketService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SaveTicketService]
    });
  });

  it('should be created', inject([SaveTicketService], (service: SaveTicketService) => {
    expect(service).toBeTruthy();
  }));
});

import { TestBed, inject } from '@angular/core/testing';

import { RsvpService } from './rsvp.service';

describe('RsvpService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RsvpService]
    });
  });

  it('should be created', inject([RsvpService], (service: RsvpService) => {
    expect(service).toBeTruthy();
  }));
});

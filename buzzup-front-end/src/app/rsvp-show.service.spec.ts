import { TestBed, inject } from '@angular/core/testing';

import { RsvpShowService } from './rsvp-show.service';

describe('RsvpShowService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RsvpShowService]
    });
  });

  it('should be created', inject([RsvpShowService], (service: RsvpShowService) => {
    expect(service).toBeTruthy();
  }));
});

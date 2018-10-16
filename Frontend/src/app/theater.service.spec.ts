import { TestBed, inject } from '@angular/core/testing';

import { TheaterService } from './theater.service';

describe('TheaterService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TheaterService]
    });
  });

  it('should be created', inject([TheaterService], (service: TheaterService) => {
    expect(service).toBeTruthy();
  }));
});

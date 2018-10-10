import { TestBed, inject } from '@angular/core/testing';

import { MovieScreeningService } from './movie-screening.service';

describe('MovieScreeningService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MovieScreeningService]
    });
  });

  it('should be created', inject([MovieScreeningService], (service: MovieScreeningService) => {
    expect(service).toBeTruthy();
  }));
});

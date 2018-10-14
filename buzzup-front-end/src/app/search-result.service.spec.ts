import { TestBed } from '@angular/core/testing';

import { SearchResultService } from './search-result.service';

describe('SearchResultService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SearchResultService = TestBed.get(SearchResultService);
    expect(service).toBeTruthy();
  });
});

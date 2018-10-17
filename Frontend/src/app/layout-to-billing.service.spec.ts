import { TestBed, inject } from '@angular/core/testing';

import { LayoutToBillingService } from './layout-to-billing.service';

describe('LayoutToBillingService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LayoutToBillingService]
    });
  });

  it('should be created', inject([LayoutToBillingService], (service: LayoutToBillingService) => {
    expect(service).toBeTruthy();
  }));
});

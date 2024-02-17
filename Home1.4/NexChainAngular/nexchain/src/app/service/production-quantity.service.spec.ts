import { TestBed } from '@angular/core/testing';

import { ProductionQuantityService } from './production-quantity.service';

describe('ProductionQuantityService', () => {
  let service: ProductionQuantityService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProductionQuantityService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

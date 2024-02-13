import { TestBed } from '@angular/core/testing';

import { ProductionProductService } from './production-product.service';

describe('ProductionProductService', () => {
  let service: ProductionProductService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProductionProductService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

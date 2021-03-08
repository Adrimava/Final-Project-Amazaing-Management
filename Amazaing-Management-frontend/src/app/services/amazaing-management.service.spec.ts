import { TestBed } from '@angular/core/testing';

import { AmazaingManagementService } from './amazaing-management.service';

describe('AmazaingManagementService', () => {
  let service: AmazaingManagementService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AmazaingManagementService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

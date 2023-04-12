import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListProductCustomerComponent } from './list-product-customer.component';

describe('ListProductCustomerComponent', () => {
  let component: ListProductCustomerComponent;
  let fixture: ComponentFixture<ListProductCustomerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListProductCustomerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListProductCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

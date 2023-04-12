import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListOrderCustomerComponent } from './list-order-customer.component';

describe('ListOrderCustomerComponent', () => {
  let component: ListOrderCustomerComponent;
  let fixture: ComponentFixture<ListOrderCustomerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListOrderCustomerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListOrderCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

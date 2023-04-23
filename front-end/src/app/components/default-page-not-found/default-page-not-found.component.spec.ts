import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DefaultPageNotFoundComponent } from './default-page-not-found.component';

describe('DefaultPageNotFoundComponent', () => {
  let component: DefaultPageNotFoundComponent;
  let fixture: ComponentFixture<DefaultPageNotFoundComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DefaultPageNotFoundComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DefaultPageNotFoundComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClubApplicationsComponent } from './club-applications.component';

describe('ClubApplicationsComponent', () => {
  let component: ClubApplicationsComponent;
  let fixture: ComponentFixture<ClubApplicationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClubApplicationsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClubApplicationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

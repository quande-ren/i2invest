import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StartClubComponent } from './start-club.component';

describe('StartClubComponent', () => {
  let component: StartClubComponent;
  let fixture: ComponentFixture<StartClubComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StartClubComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StartClubComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

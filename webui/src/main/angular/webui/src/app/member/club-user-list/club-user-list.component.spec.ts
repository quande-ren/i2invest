import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClubUserListComponent } from './club-user-list.component';

describe('ClubUserListComponent', () => {
  let component: ClubUserListComponent;
  let fixture: ComponentFixture<ClubUserListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClubUserListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClubUserListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

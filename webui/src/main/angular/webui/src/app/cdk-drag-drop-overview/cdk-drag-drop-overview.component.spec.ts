import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CdkDragDropOverviewComponent } from './cdk-drag-drop-overview.component';

describe('CdkDragDropOverviewComponent', () => {
  let component: CdkDragDropOverviewComponent;
  let fixture: ComponentFixture<CdkDragDropOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CdkDragDropOverviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CdkDragDropOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

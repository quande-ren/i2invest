import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocuSignItemComponent } from './docu-sign-item.component';

describe('DocuSignItemComponent', () => {
  let component: DocuSignItemComponent;
  let fixture: ComponentFixture<DocuSignItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DocuSignItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DocuSignItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

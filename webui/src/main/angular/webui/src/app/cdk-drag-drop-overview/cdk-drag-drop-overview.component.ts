import { CdkDragEnd } from '@angular/cdk/drag-drop';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cdk-drag-drop-overview',
  templateUrl: './cdk-drag-drop-overview.component.html',
  styleUrls: ['./cdk-drag-drop-overview.component.css']
})
export class CdkDragDropOverviewComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

dragEnd(event: CdkDragEnd) {
  console.log(event.source.getFreeDragPosition());
}

}

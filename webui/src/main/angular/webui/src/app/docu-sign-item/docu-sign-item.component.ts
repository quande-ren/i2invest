import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-docu-sign-item',
  templateUrl: './docu-sign-item.component.html',
  styleUrls: ['./docu-sign-item.component.css']
})
export class DocuSignItemComponent implements OnInit {
  @Input() imageFile:string;
  @Input() text:string
  @Input() allowDragDrop=true;

  constructor() { }

  ngOnInit(): void {
  }

  dragEnd($event){

  }
}

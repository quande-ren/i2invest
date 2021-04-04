import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-docu-sign-item',
  templateUrl: './docu-sign-item.component.html',
  styleUrls: ['./docu-sign-item.component.css']
})
export class DocuSignItemComponent implements OnInit {
  public imageFile:string;
  public text:string
  constructor() { }

  ngOnInit(): void {
  }

  dragEnd($event){
    
  }
}

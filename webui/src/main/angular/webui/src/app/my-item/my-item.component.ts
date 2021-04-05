import { Component, ComponentFactory, ComponentFactoryResolver, ComponentRef, OnInit, ViewChild, ViewContainerRef } from '@angular/core';

@Component({
  selector: 'app-my-item',
  templateUrl: './my-item.component.html',
  styleUrls: ['./my-item.component.css']
})
export class MyItemComponent implements OnInit {

  text: string;
   

  constructor() {}
  
  
  ngOnInit(): void {
  }

}

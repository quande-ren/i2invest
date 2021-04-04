import { Component, ComponentFactory, ComponentFactoryResolver, ComponentRef, OnInit, ViewChild, ViewContainerRef } from '@angular/core';
import { AlertComponent } from '../alert/alert.component';

@Component({
  selector: 'app-my-item',
  templateUrl: './my-item.component.html',
  styleUrls: ['./my-item.component.css']
})
export class MyItemComponent implements OnInit {

  @ViewChild("alertContainer", { read: ViewContainerRef }) container: any;
  componentRef: ComponentRef<any>;
 
  

  constructor(private resolver: ComponentFactoryResolver) {}
  
  createComponent(type:any) {
    //this.container.clear();
    const factory: ComponentFactory<any> = this.resolver.resolveComponentFactory(AlertComponent);

    this.componentRef = this.container.createComponent(factory);
    
    this.componentRef.instance.type = type;

    this.componentRef.instance.output.subscribe(event => console.log(event));

  }

  ngOnInit(): void {
  }

}

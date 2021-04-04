import { Component, ComponentFactory, ComponentFactoryResolver, ComponentRef, OnInit, ViewChild, ViewContainerRef } from '@angular/core';
import { DocuSignItemComponent } from '../docu-sign-item/docu-sign-item.component';

@Component({
  selector: 'app-my-item',
  templateUrl: './my-item.component.html',
  styleUrls: ['./my-item.component.css']
})
export class MyItemComponent implements OnInit {

  @ViewChild("alertContainer", { read: ViewContainerRef }) container: any;
  componentRef: ComponentRef<DocuSignItemComponent>;
 
  

  constructor(private resolver: ComponentFactoryResolver) {}
  
  createComponent(imageFile:string, text: string) {

    const factory: ComponentFactory<DocuSignItemComponent> = this.resolver.resolveComponentFactory(DocuSignItemComponent);

    this.componentRef = this.container.createComponent(factory);
    this.componentRef.instance.imageFile=imageFile;
    this.componentRef.instance.text=text;

    
  }

  ngOnInit(): void {
  }

}

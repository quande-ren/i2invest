import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-alert',
  template: `
    <h1>Alert {{type}}</h1>
  `
})
export class AlertComponent implements OnInit {

  @Input() type: string = "success";

  constructor() { }

  ngOnInit(): void {
  }

}

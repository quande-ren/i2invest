import { Component, OnInit } from '@angular/core';
import { SessionManagerService } from 'src/app/services/session-manager.service';

@Component({
  selector: 'app-property-list',
  templateUrl: './property-list.component.html',
  styleUrls: ['./property-list.component.css']
})
export class PropertyListComponent implements OnInit {

  constructor(public sessionManager: SessionManagerService) { }

  ngOnInit(): void {
  }

}

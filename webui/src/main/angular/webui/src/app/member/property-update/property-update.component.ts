import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { PropertyVo } from 'src/app/model/property-vo.model';
import { RestfulService } from 'src/app/services/restful.service';
import { SessionManagerService } from 'src/app/services/session-manager.service';

@Component({
  selector: 'app-property-update',
  templateUrl: './property-update.component.html',
  styleUrls: ['./property-update.component.css']
})
export class PropertyUpdateComponent implements OnInit {

 
  
  propertyVo: PropertyVo;

  constructor(private restfulService: RestfulService,
		private messageService: MessageService,
		public sessionManager: SessionManagerService,
    private router: Router) { }

  ngOnInit(): void {
    this.propertyVo=this.sessionManager.currentProperty;
  }

  
  updateProperty(){
		let jsonType='PropertyRequest';
    this.propertyVo.id=this.sessionManager.currentProperty.id;
		let jsonObj={email: this.sessionManager.email, token: this.sessionManager.token, requestType: 'Update', property: this.propertyVo};
      this.restfulService.callRestful(jsonType, jsonObj, 
			(response)=> {
                this.messageService.add({severity:'message', summary: 'Success', detail: 'Project is created ' });
                this.sessionManager.currentProperty=this.propertyVo;
                this.router.navigateByUrl('/member/propertylist');
            });

  }
/*
  showProperties(){
    this.sessionManager.currentProject=this.projectVo;
    this.router.navigateByUrl('/member/propertylist');
  }
  */

}

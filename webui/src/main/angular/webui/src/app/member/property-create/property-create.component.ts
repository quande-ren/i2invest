import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { PropertyVo } from 'src/app/model/property-vo.model';
import { RestfulService } from 'src/app/services/restful.service';
import { SessionManagerService } from 'src/app/services/session-manager.service';

@Component({
  selector: 'app-property-create',
  templateUrl: './property-create.component.html',
  styleUrls: ['./property-create.component.css']
})
export class PropertyCreateComponent implements OnInit {

  propertyVo: PropertyVo=new PropertyVo();

  constructor(private restfulService: RestfulService,
		private messageService: MessageService,
		public sessionManager: SessionManagerService,
    private router: Router) { }

  ngOnInit(): void {
  }

  createProperty(){
		let jsonType='PropertyRequest';
    this.propertyVo.projectId=this.sessionManager.currentProject.id;
		let jsonObj={email: this.sessionManager.email, token: this.sessionManager.token, requestType: 'Create', property: this.propertyVo};
      this.restfulService.callRestful(jsonType, jsonObj, 
			(response)=> {
                this.messageService.add({severity:'message', summary: 'Success', detail: 'Property is created ' });
                this.router.navigateByUrl('/member/propertylist');
            });

  }


}

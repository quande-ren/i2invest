import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PropertyVo } from 'src/app/model/property-vo.model';
import { RestfulService } from 'src/app/services/restful.service';
import { SessionManagerService } from 'src/app/services/session-manager.service';

@Component({
  selector: 'app-property-list',
  templateUrl: './property-list.component.html',
  styleUrls: ['./property-list.component.css']
})
export class PropertyListComponent implements OnInit {

  properties: PropertyVo[];

  constructor(private restfulService: RestfulService,
		public sessionManager: SessionManagerService,
    private router: Router) { }

  ngOnInit(): void {
    this.doRetrieve();
  }

  doRetrieve(){
    let jsonType='PropertyRequest';
    let property=new PropertyVo();
    
    property.projectId=this.sessionManager.currentProject.id;

		let jsonObj={email: this.sessionManager.email, token: this.sessionManager.token, requestType: 'Retrieve', property: property};
      this.restfulService.callRestful(jsonType, jsonObj, 
			(response)=> {
                 this.properties=response.properties;
            } );    
  }

  selectProperty(property: PropertyVo){
    this.sessionManager.currentProperty=property;
    this.router.navigateByUrl('/member/propertyupdate');
  }


}

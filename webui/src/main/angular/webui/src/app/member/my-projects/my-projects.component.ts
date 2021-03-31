import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { ProjectVo } from 'src/app/model/project-vo.model';
import { RestfulService } from 'src/app/services/restful.service';
import { SessionManagerService } from 'src/app/services/session-manager.service';

@Component({
  selector: 'app-my-projects',
  templateUrl: './my-projects.component.html',
  styleUrls: ['./my-projects.component.css']
})
export class MyProjectsComponent implements OnInit {
  projects: ProjectVo[];

  constructor(private restfulService: RestfulService,
		private messageService: MessageService,
		private sessionManager: SessionManagerService,
    private router: Router) { }

  ngOnInit(): void {
    this.doRetrieve();
  }

  doRetrieve(){
    let jsonType='ProjectRequest';
		let jsonObj={email: this.sessionManager.email, token: this.sessionManager.token, requestType: 'Retrieve', retrieveType: 'select p.* from i2_Project p where p.name is not null'};
      this.restfulService.callRestful(jsonType, jsonObj).subscribe(
        response => {
              if(response.success){
                 this.projects=response.projects;
              }else{
                this.messageService.add({severity:'error', summary: 'Error', detail: response.errorMessage+' ('+response.errorCode+')' });
              }
            },
        error   => 	{
              this.messageService.add({severity:'error', summary: 'Error', detail:'Server Error.'});
            }
    );    
  }


}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProjectVo } from 'src/app/model/project-vo.model';
import { RestfulService } from 'src/app/services/restful.service';
import { SessionManagerService } from 'src/app/services/session-manager.service';

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent implements OnInit {
  projects: ProjectVo[];

  constructor(private restfulService: RestfulService,
		public sessionManager: SessionManagerService,
    private router: Router) { }

  ngOnInit(): void {
    this.doRetrieve();
  }

  doRetrieve(){
    let jsonType='ProjectRequest';
    let project=new ProjectVo();
    
    project.clubId=this.sessionManager.currentClub.id;

		let jsonObj={email: this.sessionManager.email, token: this.sessionManager.token, requestType: 'Retrieve', project: project};
      this.restfulService.callRestful(jsonType, jsonObj, 
			(response)=> {
                 this.projects=response.projects;
            } );    
  }

  selectProject(project: ProjectVo){
    this.sessionManager.currentProject=project;
    this.router.navigateByUrl('/member/projectupdate');
  }


}

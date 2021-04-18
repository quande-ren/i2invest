import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { ProjectVo } from 'src/app/model/project-vo.model';
import { RestfulService } from 'src/app/services/restful.service';
import { SessionManagerService } from 'src/app/services/session-manager.service';

@Component({
  selector: 'app-project-update',
  templateUrl: './project-update.component.html',
  styleUrls: ['./project-update.component.css']
})
export class ProjectUpdateComponent implements OnInit {

  projectVo: ProjectVo;

  constructor(private restfulService: RestfulService,
		private messageService: MessageService,
		public sessionManager: SessionManagerService,
    private router: Router) { }

  ngOnInit(): void {
    this.projectVo=this.sessionManager.currentProject;
  }

  
  updateProject(){
		let jsonType='ProjectRequest';
    this.projectVo.clubId=this.sessionManager.currentClub.id;
		let jsonObj={email: this.sessionManager.email, token: this.sessionManager.token, requestType: 'Update', project: this.projectVo};
      this.restfulService.callRestful(jsonType, jsonObj, 
			(response)=> {
                this.messageService.add({severity:'message', summary: 'Success', detail: 'Project is created ' });
                this.sessionManager.currentProject=this.projectVo;
                this.router.navigateByUrl('/member/projectlist');
            });

  }


}

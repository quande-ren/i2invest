import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { ProjectVo } from 'src/app/model/project-vo.model';
import { RestfulService } from 'src/app/services/restful.service';
import { SessionManagerService } from 'src/app/services/session-manager.service';

@Component({
  selector: 'app-start-project',
  templateUrl: './start-project.component.html',
  styleUrls: ['./start-project.component.css']
})
export class StartProjectComponent implements OnInit {
  projectVo: ProjectVo=new ProjectVo();

  constructor(private restfulService: RestfulService,
		private messageService: MessageService,
		private sessionManager: SessionManagerService,
    private router: Router) { }

  ngOnInit(): void {
  }

  startProject(){
		let jsonType='ProjectRequest';
    this.projectVo.clubId=this.sessionManager.clubVo.id;
		let jsonObj={email: this.sessionManager.email, token: this.sessionManager.token, requestType: 'Create', project: this.projectVo};
      this.restfulService.callRestful(jsonType, jsonObj, 
			(response)=> {
                this.messageService.add({severity:'message', summary: 'Success', detail: 'Project is created ' });
                this.router.navigateByUrl('/member/myprojects');
            });

  }

}

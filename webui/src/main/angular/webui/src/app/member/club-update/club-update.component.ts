import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { ClubVo } from 'src/app/model/club-vo.model';
import { ProjectVo } from 'src/app/model/project-vo.model';
import { RestfulService } from 'src/app/services/restful.service';
import { SessionManagerService } from 'src/app/services/session-manager.service';

@Component({
  selector: 'app-club-update',
  templateUrl: './club-update.component.html',
  styleUrls: ['./club-update.component.css']
})

export class ClubUpdateComponent implements OnInit {
	
  clubVo: ClubVo;
  
	constructor(
		private restfulService: RestfulService,
		private messageService: MessageService,
		private sessionManager: SessionManagerService,
    private router: Router) { }

  ngOnInit(): void {
    this.clubVo=this.sessionManager.currentClub;
  }

  startProject(){
    this.router.navigateByUrl('/member/projectcreate');
  }

  updateClub(){

    let jsonType='ClubUpdateRequest';

    this.clubVo.contactEmail=this.sessionManager.email;

	let jsonObj={email: this.sessionManager.email, token: this.sessionManager.token, club: this.clubVo};

    this.restfulService.callRestful(jsonType, jsonObj, 
			(response)=> {
                this.sessionManager.currentClub=response.club;
                this.messageService.add({severity:'message', summary: 'Success', detail: 'Club Info is updated ' });
                this.router.navigateByUrl('/member/clublist');
            } );

  }

  joinClub(){
    let jsonType='ClubJoinRequest';

    this.clubVo.contactEmail=this.sessionManager.email;

    this.clubVo.id=this.sessionManager.currentClub.id;

	  let jsonObj={email: this.sessionManager.email, token: this.sessionManager.token, clubId: this.sessionManager.currentClub.id};

    this.restfulService.callRestful(jsonType, jsonObj, 
			(response)=> {
                this.messageService.add({severity:'message', summary: 'Success', detail: 'Request to Join Club is sent ' });
                this.router.navigateByUrl('/member/clublist');
            } );

  }

  showProjects(){
    this.sessionManager.currentClub=this.clubVo;

    this.router.navigateByUrl('/member/projectlist');

  }
  


}

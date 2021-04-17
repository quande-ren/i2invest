import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { ClubVo } from '../../model/club-vo.model';
import { RestfulService } from '../../services/restful.service';
import { SessionManagerService } from '../../services/session-manager.service';

@Component({
  selector: 'app-start-club',
  templateUrl: './start-club.component.html',
  styleUrls: ['./start-club.component.css']
})
export class StartClubComponent implements OnInit {
  clubVo: ClubVo=new ClubVo();

  constructor(
		private restfulService: RestfulService,
		private messageService: MessageService,
		private sessionManager: SessionManagerService,
    	private router: Router
    ) { }

  ngOnInit(): void {  }

  startClub() {

	let jsonType='ClubStartRequest';
	    
	this.clubVo.contactEmail=this.sessionManager.email;
	
	let jsonObj={email: this.sessionManager.email, token: this.sessionManager.token, club: this.clubVo};
    
	this.restfulService.callRestful(jsonType, jsonObj, (response)=> {
				this.messageService.add({severity:'message', summary: 'Success', detail: 'Invest Club is created ' });
                this.router.navigateByUrl('/member/myclubs');
			});
  }

}

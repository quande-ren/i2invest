import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { ClubVo } from '../../model/club-vo.model';
import { RestfulService } from '../../services/restful.service';
import { SessionManagerService } from '../../services/session-manager.service';

@Component({
  selector: 'app-club-create',
  templateUrl: './club-create.component.html',
  styleUrls: ['./club-create.component.css']
})
export class ClubCreateComponent implements OnInit {
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
                this.router.navigateByUrl('/member/clublist');
			});
  }

}

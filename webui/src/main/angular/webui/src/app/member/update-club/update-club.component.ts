import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { ClubVo } from 'src/app/model/club-vo.model';
import { RestfulService } from 'src/app/services/restful.service';
import { SessionManagerService } from 'src/app/services/session-manager.service';

@Component({
  selector: 'app-update-club',
  templateUrl: './update-club.component.html',
  styleUrls: ['./update-club.component.css']
})
export class UpdateClubComponent implements OnInit {
  clubVo: ClubVo;
  constructor(private restfulService: RestfulService,
		private messageService: MessageService,
		private sessionManager: SessionManagerService,
    private router: Router) { }

  ngOnInit(): void {
    this.clubVo=this.sessionManager.clubVo;
  }

  startProject(){
    this.router.navigateByUrl('/member/startproject');
  }
  updateClub(){

    let jsonType='ClubUpdateRequest';
    this.clubVo.contactEmail=this.sessionManager.email;
		let jsonObj={email: this.sessionManager.email, token: this.sessionManager.token, club: this.clubVo};
      this.restfulService.callRestful(jsonType, jsonObj, 
			(response)=> {
                this.sessionManager.clubVo=response.club;
                this.messageService.add({severity:'message', summary: 'Success', detail: 'Club Info is updated ' });
                this.router.navigateByUrl('/member/myclubs');
            } );

  }

  joinClub(){
    let jsonType='ClubJoinRequest';
    this.clubVo.contactEmail=this.sessionManager.email;
    this.clubVo.id=this.sessionManager.clubVo.id;
		let jsonObj={email: this.sessionManager.email, token: this.sessionManager.token, clubId: this.sessionManager.clubVo.id};
    this.restfulService.callRestful(jsonType, jsonObj, 
			(response)=> {
                this.messageService.add({severity:'message', summary: 'Success', detail: 'Request to Join Club is sent ' });
                this.router.navigateByUrl('/member/myclubs');
            } );

  }
  


}

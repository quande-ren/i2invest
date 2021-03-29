import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { ClubVo } from 'src/app/model/club-vo.module';
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

  updateClub(){

    let jsonType='ClubUpdateRequest';
    this.clubVo.contactEmail=this.sessionManager.email;
		let jsonObj={email: this.sessionManager.email, token: this.sessionManager.token, club: this.clubVo};
      this.restfulService.callRestful(jsonType, jsonObj).subscribe(
        response => {
              if(response.success){
                this.messageService.add({severity:'message', summary: 'Success', detail: 'Club Info is updated ' });
                this.router.navigateByUrl('/member/myclubs');
              }else{
                this.messageService.add({severity:'error', summary: 'Error', detail: response.errorMessage+' ('+response.errorCode+')' });
              }
            },
        error   => 	{
              this.messageService.add({severity:'error', summary: 'Error Message', detail:error});
            }
    );

  }

}

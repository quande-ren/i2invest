import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { ClubVo } from '../../model/club-vo.model';
import { RestfulService } from '../../services/restful.service';
import { SessionManagerService } from '../../services/session-manager.service';


@Component({
  selector: 'app-my-clubs',
  templateUrl: './my-clubs.component.html',
  styleUrls: ['./my-clubs.component.css']
})
export class MyClubsComponent implements OnInit {
  clubs: ClubVo[];

  constructor(private restfulService: RestfulService,
		private messageService: MessageService,
		private sessionManager: SessionManagerService,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.doRetrieve();
  }

  goModify(clubId: number){
    for(let club of this.clubs){
      if(club.id===clubId){
        this.sessionManager.clubVo=club;
        this.router.navigateByUrl('/member/updateclub');
        return;
      }
    }

  }

  joinClub(){
  }
  

  doRetrieve(){
    let jsonType='ClubRetrieveRequest';
		let jsonObj={email: this.sessionManager.email, token: this.sessionManager.token, retrieveType: 'select p.* from i2_Club p where p.clubName is not null'};
      this.restfulService.callRestful(jsonType, jsonObj).subscribe(
        response => {
              if(response.success){
                 this.clubs=response.clubs;
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

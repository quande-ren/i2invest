import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { ClubVo } from 'src/app/model/club-vo.model';
import { UserVo } from 'src/app/model/user-vo.model';
import { RestfulService } from 'src/app/services/restful.service';
import { SessionManagerService } from 'src/app/services/session-manager.service';

@Component({
  selector: 'app-club-applications',
  templateUrl: './club-applications.component.html',
  styleUrls: ['./club-applications.component.css']
})
export class ClubApplicationsComponent implements OnInit {
  clubs: ClubVo[];
  clubUsers: UserVo[];

  constructor(private restfulService: RestfulService,
		private messageService: MessageService,
		private sessionManager: SessionManagerService,
    private router: Router) { }

  ngOnInit(): void {
    this.doRetrieve();
  }

  doRetrieve(){
    console.log("here");
    let jsonType='ClubRequest';
		let jsonObj={email: this.sessionManager.email, token: this.sessionManager.token, requestType: 'RetrieveClubApplocations'};
      this.restfulService.callRestful(jsonType, jsonObj).subscribe(
        response => {
              if(response.success){
                 this.clubs=response.clubs;
                 this.clubUsers=response.clubUsers;
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

import { Component, OnInit } from '@angular/core';
import { ClubVo } from 'src/app/model/club-vo.model';
import { UserVo } from 'src/app/model/user-vo.model';
import { RestfulService } from 'src/app/services/restful.service';
import { SessionManagerService } from 'src/app/services/session-manager.service';

@Component({
  selector: 'app-club-user-list',
  templateUrl: './club-user-list.component.html',
  styleUrls: ['./club-user-list.component.css']
})
export class ClubUserListComponent implements OnInit {
  club: ClubVo;
  clubs: ClubVo[];
  clubUsers: UserVo[];

  constructor(
		private restfulService: RestfulService,
		private sessionManager: SessionManagerService) { }

  ngOnInit(): void {
    this.doRetrieve();
  }

  doRetrieve(){
    console.log("here");
    let jsonType='ClubRequest';
    this.club=new ClubVo();
    this.club.id=this.sessionManager.currentClub.id;
	  
    let jsonObj={
        email: this.sessionManager.email, 
        token: this.sessionManager.token, 
        club: this.club,
        requestType: 'RetrieveClubUsers'
      };
    
    this.restfulService.callRestful(jsonType, jsonObj, (response)=> {
                 this.clubs=response.clubs;
                 this.clubUsers=response.clubUsers;
            } );    
  }

}

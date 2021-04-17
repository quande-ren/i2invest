import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { ClubVo } from '../../model/club-vo.model';
import { RestfulService } from '../../services/restful.service';
import { SessionManagerService } from '../../services/session-manager.service';


@Component({
  selector: 'app-club-list',
  templateUrl: './club-list.component.html',
  styleUrls: ['./club-list.component.css']
})
export class ClubListComponent implements OnInit {
  clubsOwn: ClubVo[];
  clubsInterested: ClubVo[];
  otherClubs: ClubVo[];

  constructor(private restfulService: RestfulService,
		private messageService: MessageService,
		private sessionManager: SessionManagerService,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.doRetrieve();
  }

  selectClub(clubVo: ClubVo){
        this.sessionManager.currentClub=clubVo;

        this.router.navigateByUrl('/member/clubupdate');
  }


  doRetrieve(){
    	let jsonType='ClubRetrieveRequest';
		let jsonObj={email: this.sessionManager.email, token: this.sessionManager.token, retrieveType: 'select p.* from i2_Club p where p.name is not null'};
      	this.restfulService.callRestful(jsonType, jsonObj, 
			(response)=> {
                 this.clubsOwn=response.clubsOwn;
                 this.clubsInterested=response.clubsInterested;
                 this.otherClubs=response.otherClubs;
            } );    
  }
}

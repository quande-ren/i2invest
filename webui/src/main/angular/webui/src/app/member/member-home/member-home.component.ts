import { Component, OnInit } from '@angular/core';
import { RestfulService } from '../../services/restful.service';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { Response } from '@angular/http';
import { SessionManagerService } from '../../services/session-manager.service';
import { UserVo } from '../../model/user-vo.model';

@Component({
	selector: 'app-member-home',
	templateUrl: './member-home.component.html',
	styleUrls: ['./member-home.component.css']
})
export class MemberHomeComponent implements OnInit {

	searchEmail:string;
	userVo: UserVo;

	constructor(private restfulService: RestfulService,
		private messageService: MessageService,
		private sessionManager: SessionManagerService) { }

	ngOnInit(): void {
	}

	doSearch() {
		let jsonType='UserRetrieveRequest';
		let jsonObj={email: this.sessionManager.email, token: this.sessionManager.token, searchEmail: this.searchEmail};

		this.restfulService.callRestful(jsonType, jsonObj, 
			(response)=> {
							this.userVo=response.user;
						 });

	}

}

import { Component, OnInit } from '@angular/core';
import { RestfulService } from '../../services/restful.service';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { Response } from '@angular/http';
import { SessionManagerService } from '../../services/session-manager.service';


@Component({
	selector: 'app-login',
	templateUrl: './login.component.html',
	styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
	email = 'quande.ren@gmail.com';
	password = 'Yanmei123';


	constructor( private restfulService : RestfulService,
				 private messageService: MessageService,
				 private sessionManager : SessionManagerService,
				 private router: Router,
			
	 		   ) { 
	}

	ngOnInit(): void {
	}

	doLogin() {
		let jsonType='UserSignInRequest';
		let jsonObj={email: this.email, password: this.password};

		this.restfulService.callRestful(jsonType, jsonObj).subscribe(
		 	response => {
							if(response.success){
								this.sessionManager.token=response.token;
								this.sessionManager.email=this.email;
								this.sessionManager.userVo=response.user;
								console.log(this.sessionManager.token);
								this.router.navigateByUrl('/member/memberhome');
							}else{
								this.messageService.add({severity:'error', summary: 'Error Login', detail: response.errorMessage+' ('+response.errorCode+')' });
								this.sessionManager.token='';
								this.sessionManager.email='';
							}
						},
			 
		 	error   => 	{
							this.messageService.add({severity:'error', summary: 'Error !', detail:'Failed to connect server'});
						}
		);
	}

}

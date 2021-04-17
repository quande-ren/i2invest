import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { RestfulService } from 'src/app/services/restful.service';
import { SessionManagerService } from 'src/app/services/session-manager.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  constructor(private restfulService : RestfulService, 
    private messageService: MessageService,
    private sessionManager : SessionManagerService,
    private router: Router) { }

  public email: string;

  ngOnInit(): void {
  }

  retrievePassword(){
		let jsonType='UserForgotPasswordRequest';
		let jsonObj={email: this.email};

		this.restfulService.callRestful(jsonType, jsonObj, 
			(response)=> {
								this.sessionManager.email=this.email;
								this.messageService.add({severity:'message', summary: 'Success', detail: 'Password Retrieved Successfully' });
								this.router.navigateByUrl('/signin');
						});

  }
}

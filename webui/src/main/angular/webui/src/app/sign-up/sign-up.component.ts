import { UserVo } from '../model/user-vo.model';
import { Component, OnInit, OnDestroy, ChangeDetectorRef, Input, Renderer2 } from '@angular/core';
import { RestfulService } from '../services/restful.service';
import { MessageService } from 'primeng/api';
import { Response } from '@angular/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})

export class SignUpComponent implements OnInit   {
  userVo: UserVo=new UserVo();
  passwordConfirm ='Yanmei123';	
  constructor(	private restfulService : RestfulService, 
				private messageService: MessageService,
				private router: Router
	) { }

  ngOnInit(): void {
  }

	doSignUp(){
		let jsonType='SignUpRequest';
		let jsonObj={user: this.userVo};

		this.restfulService.callRestful(jsonType, jsonObj).subscribe(
		 	response => {
							if(response.success){
								console.log(response);
								this.router.navigateByUrl('/signin');
								this.messageService.add({severity:'message', summary: 'Success', detail: 'You can now sign in using the new created credential' });
							}else{
								this.messageService.add({severity:'error', summary: 'Error Sign Up', detail: response.errorMessage+' ('+response.errorCode+')' });
							}
						},
			 
		 	error   => 	{
							this.messageService.add({severity:'error', summary: 'Error Message', detail:error});
						}
		);
		
	}

}

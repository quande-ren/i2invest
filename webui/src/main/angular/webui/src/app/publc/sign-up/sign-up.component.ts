import { UserVo } from '../../model/user-vo.model';
import { Component, OnInit, OnDestroy, ChangeDetectorRef, Input, Renderer2 } from '@angular/core';
import { RestfulService } from '../../services/restful.service';
import { MessageService } from 'primeng/api';
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
		if(this.userVo.phoneNum===''){
			 this.messageService.add({severity:'error', summary: 'Error Message', detail:'Phone Num is required'});
			 return;
		}
		if(this.userVo.email===''){
			 this.messageService.add({severity:'error', summary: 'Error Message', detail:'Email is required'});
			 return;
		}
		if(this.userVo.firstName===''){
			 this.messageService.add({severity:'error', summary: 'Error Message', detail:'First Name is required'});
			 return;
		}
		if(this.userVo.lastName===''){
			 this.messageService.add({severity:'error', summary: 'Error Message', detail:'Last Name is required'});
			 return;
		}
		
		let jsonType='UserSignUpRequest';
		let jsonObj={user: this.userVo};

		this.restfulService.callRestful(jsonType, jsonObj, 
			(response)=> {
								console.log(response);
								this.router.navigateByUrl('/signin');
								this.messageService.add({severity:'message', summary: 'Success', detail: 'You can now sign in using the new created credential' });
						});
		
	}

}

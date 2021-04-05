import { UserVo } from '../../model/user-vo.model';
import { Component, OnInit, OnDestroy, ChangeDetectorRef, Input, Renderer2 } from '@angular/core';
import { RestfulService } from '../../services/restful.service';
import { MessageService } from 'primeng/api';
import { Response } from '@angular/http';
import { Router } from '@angular/router';
import { FieldsetModule } from 'primeng/fieldset';
import { SessionManagerService } from '../../services/session-manager.service';

@Component({
	selector: 'app-change-profile',
	templateUrl: './change-profile.component.html',
	styleUrls: ['./change-profile.component.css']
})
export class ChangeProfileComponent implements OnInit {

	userVo: UserVo=new UserVo();
	oldPassword = '1';
	newPassword = '2';
	passwordConfirm = '2';

	constructor(
		private restfulService: RestfulService,
		private messageService: MessageService,
		private sessionManager: SessionManagerService,
		private router: Router
	) { }

	ngOnInit(): void {
		this.userVo=this.sessionManager.userVo;
	}

	doChangePassword() {
		let errorMsg='';
		if(this.newPassword!=this.passwordConfirm){
			errorMsg='New Password and password confirm does not match';
		}else if(this.newPassword===this.oldPassword){
			errorMsg='Old Password and new Password are the same.'
		}
		console.log("errorMsg="+errorMsg);
		
		if(errorMsg!==''){
			this.messageService.add({ severity: 'error', summary: 'Error', detail: errorMsg });
			return;
		}
		
		let jsonType = 'UserChangeProfileRequest';
		let jsonObj = { user: this.userVo , 
		                email: this.sessionManager?.userVo?.email,
						token: this.sessionManager?.token, 
						oldPassword: this.oldPassword, 
						newPassword: this.newPassword, 
						changePasswordOnly: true};

		this.restfulService.callRestful(jsonType, jsonObj).subscribe(
			response => {
				if (response.success) {
					console.log(response);
					this.router.navigateByUrl('/signin');
					this.messageService.add({ severity: 'message', summary: 'Password Change Success', detail: 'You can now sign in using the new created credential' });
				} else {
					this.messageService.add({ severity: 'error', summary: 'Error', detail: response.errorMessage + ' (' + response.errorCode + ')' });
				}
			},

			error => {
				this.messageService.add({ severity: 'error', summary: 'Error Message', detail: error });
			}
		);

	}

	doChangeProfile() {
		let jsonType = 'UserProfileChangeRequest';
		let jsonObj = { user: this.userVo , 
		                email: this.sessionManager?.userVo?.email,
						token: this.sessionManager?.token, 
						requestType: "ChangeProfile"};

		this.restfulService.callRestful(jsonType, jsonObj).subscribe(
			response => {
				if (response.success) {
					console.log(response);
					this.router.navigateByUrl('/signin');
					this.messageService.add({ severity: 'message', summary: 'Password Change Success', detail: 'You can now sign in using the new created credential' });
				} else {
					this.messageService.add({ severity: 'error', summary: 'Error', detail: response.errorMessage + ' (' + response.errorCode + ')' });
				}
			},

			error => {
				this.messageService.add({ severity: 'error', summary: 'Error Message', detail: error });
			}
		);


	}

	doChangeEmail() {
		}

}

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './publc/login/login.component';
import { SignUpComponent } from './publc/sign-up/sign-up.component';
import { MemberHomeComponent } 		from './member/member-home/member-home.component';
import { FileUploadComponent } from './publc/file-upload/file-upload.component';
import { ForgotPasswordComponent } from './publc/forgot-password/forgot-password.component';
import { MyItemComponent } from './my-item/my-item.component';
import { ProfileUpdateComponent } from './member/profile-update/profile-update.component';
import { ClubCreateComponent } from './member/club-create/club-create.component';
import { ClubListComponent } from './member/club-list/club-list.component';
import { ClubUpdateComponent } from './member/club-update/club-update.component';
import { ProjectCreateComponent } from './member/project-create/project-create.component';
import { ProjectUpdateComponent } from './member/project-update/project-update.component';
import { ProjectListComponent } from './member/project-list/project-list.component';
import { PropertyListComponent } from './member/property-list/property-list.component';
import { PropertyCreateComponent } from './member/property-create/property-create.component';
import { PropertyUpdateComponent } from './member/property-update/property-update.component';
import { ClubUserListComponent } from './member/club-user-list/club-user-list.component';

const routes: Routes = [
	{ path: '', 						component: LoginComponent, 				data: {name: '', 						role: ['ALL']} },
	{ path: 'test', 					component: MyItemComponent, 			data: {name: 'test', 					role: ['ALL']} },
	{ path: 'signin', 					component: LoginComponent,  			data: {name: 'SignIn', 					role: ['ALL']} },
	{ path: 'signup', 					component: SignUpComponent, 			data: {name: 'SignUp', 					role: ['ALL']} },
	{ path: 'fileupload', 				component: FileUploadComponent, 		data: {name: 'FileUpload', 				role: ['ALL']} },
	{ path: 'forgotpassword', 			component: ForgotPasswordComponent, 	data: {name: 'Forgotpassword', 			role: ['ALL']} },
	{ path: 'member/memberhome', 		component: MemberHomeComponent, 		data: {name: 'MemberHome', 				role: ['ALL']} },
	{ path: 'member/profileupdate', 	component: ProfileUpdateComponent, 		data: {name: 'ProfileUpdate', 			role: ['ALL']} },
	
	{ path: 'member/clubuserlist', 		component: ClubUserListComponent, 		data: {name: 'ClubUserList', 			role: ['ALL']} },
	{ path: 'member/clubcreate', 		component: ClubCreateComponent, 		data: {name: 'ClubCreate', 				role: ['ALL']} },
	{ path: 'member/clublist', 			component: ClubListComponent, 			data: {name: 'ClubList', 				role: ['ALL']} },
	{ path: 'member/clubupdate', 		component: ClubUpdateComponent, 		data: {name: 'ClubUpdate', 				role: ['ALL']} },
	
	{ path: 'member/projectcreate', 	component: ProjectCreateComponent, 		data: {name: 'ProjectCreate', 			role: ['ALL']} },
	{ path: 'member/projectupdate', 	component: ProjectUpdateComponent, 		data: {name: 'ProjectUpdate', 			role: ['ALL']} },
	{ path: 'member/projectlist', 		component: ProjectListComponent, 		data: {name: 'ProjectList', 			role: ['ALL']} },
	
	{ path: 'member/propertylist', 		component: PropertyListComponent, 		data: {name: 'PropertyList', 			role: ['ALL']} },
	{ path: 'member/propertycreate', 	component: PropertyCreateComponent, 	data: {name: 'PropertyCreate', 			role: ['ALL']} },
	{ path: 'member/propertyupdate', 	component: PropertyUpdateComponent, 	data: {name: 'PropertyUpdate', 			role: ['ALL']} },

];

@NgModule({
  imports: [
	  
	  RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

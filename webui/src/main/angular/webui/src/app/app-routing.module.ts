import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './publc/login/login.component';
import { SignUpComponent } from './publc/sign-up/sign-up.component';
import { MemberHomeComponent } 		from './member/member-home/member-home.component';
import { ChangeProfileComponent } 	from './member/change-profile/change-profile.component';
import { StartClubComponent } from './member/start-club/start-club.component';
import { MyClubsComponent } from './member/my-clubs/my-clubs.component';
import { UpdateClubComponent } from './member/update-club/update-club.component';
import { FileUploadComponent } from './publc/file-upload/file-upload.component';
import { StartProjectComponent } from './member/start-project/start-project.component';
import { MyProjectsComponent } from './member/my-projects/my-projects.component';
import { ForgotPasswordComponent } from './publc/forgot-password/forgot-password.component';
import { ClubApplicationsComponent } from './member/club-applications/club-applications.component';

const routes: Routes = [
	{ path: '', 						component: LoginComponent, 				data: {name: '', 						role: ['ALL']} },
	{ path: 'signin', 					component: LoginComponent,  			data: {name: 'SignIn', 					role: ['ALL']} },
	{ path: 'signup', 					component: SignUpComponent, 			data: {name: 'SignUp', 					role: ['ALL']} },
	{ path: 'fileupload', 				component: FileUploadComponent, 		data: {name: 'FileUpload', 				role: ['ALL']} },
	{ path: 'forgotpassword', 			component: ForgotPasswordComponent, 	data: {name: 'Forgotpassword', 			role: ['ALL']} },
	{ path: 'member/memberhome', 		component: MemberHomeComponent, 		data: {name: 'MemberHome', 				role: ['ALL']} },
	{ path: 'member/changeprofile', 	component: ChangeProfileComponent, 		data: {name: 'ChangeProfile', 			role: ['ALL']} },
	{ path: 'member/startclub', 		component: StartClubComponent, 			data: {name: 'StartClub', 				role: ['ALL']} },
	{ path: 'member/myclubs', 			component: MyClubsComponent, 			data: {name: 'MyClubs', 				role: ['ALL']} },
	{ path: 'member/updateclub', 		component: UpdateClubComponent, 		data: {name: 'UpdateClub', 				role: ['ALL']} },
	{ path: 'member/startproject', 		component: StartProjectComponent, 		data: {name: 'StartProject', 			role: ['ALL']} },
	{ path: 'member/myprojects', 		component: MyProjectsComponent, 		data: {name: 'MyProjects', 				role: ['ALL']} },
	{ path: 'member/clubapplications', 	component: ClubApplicationsComponent, 	data: {name: 'ClubApplications', 		role: ['ALL']} },

];

@NgModule({
  imports: [
	  
	  RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

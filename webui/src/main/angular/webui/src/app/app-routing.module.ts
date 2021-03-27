import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { MemberHomeComponent } from './member/member-home/member-home.component';

const routes: Routes = [
	{ path: '', 					component: LoginComponent, 		data: {name: '', 			role: ['ALL']} },
	{ path: 'signin', 				component: LoginComponent,  	data: {name: 'SignIn', 		role: ['ALL']} },
	{ path: 'signup', 				component: SignUpComponent, 	data: {name: 'SignUp', 		role: ['ALL']} },
	{ path: 'member/memberhome', 	component: MemberHomeComponent, data: {name: 'MemberHome', 	role: ['ALL']} },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

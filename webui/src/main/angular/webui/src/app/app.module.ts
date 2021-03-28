import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import { SignUpComponent } from './sign-up/sign-up.component';
import { RestfulService } from './services/restful.service';
import { MessageService } from 'primeng/api';
import { ToastModule } from 'primeng/toast';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MemberHomeComponent } from './member/member-home/member-home.component';
import { ChangeProfileComponent } from './member/change-profile/change-profile.component';
import { FieldsetModule } from 'primeng/fieldset';
import { FooterComponent } from './layout/footer/footer.component';
import { HeaderComponent } from './layout/header/header.component';
import { SidebarComponent } from './layout/sidebar/sidebar.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatExpansionModule } from '@angular/material/expansion';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignUpComponent,
    MemberHomeComponent,
    ChangeProfileComponent,
    FooterComponent,
    HeaderComponent,
    SidebarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
	FormsModule,
	HttpModule,
	HttpClientModule,
	ToastModule,
	BrowserAnimationsModule,
	FieldsetModule,
	FlexLayoutModule 
  ],
  providers: [RestfulService, MessageService],
  bootstrap: [AppComponent]
})
export class AppModule { }

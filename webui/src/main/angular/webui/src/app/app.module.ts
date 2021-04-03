import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './publc/login/login.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SignUpComponent } from './publc/sign-up/sign-up.component';
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
import { StartClubComponent } from './member/start-club/start-club.component';
import { MyClubsComponent } from './member/my-clubs/my-clubs.component';
import { UpdateClubComponent } from './member/update-club/update-club.component';
import { FileUploadComponent } from './publc/file-upload/file-upload.component';
import { StartProjectComponent } from './member/start-project/start-project.component';
import { MyProjectsComponent } from './member/my-projects/my-projects.component';
import { ForgotPasswordComponent } from './publc/forgot-password/forgot-password.component';
import { TableModule } from 'primeng/table';
import { ClubApplicationsComponent } from './member/club-applications/club-applications.component';
import { FileUploadModule } from 'primeng/fileupload';
import { NgxExtendedPdfViewerModule } from 'ngx-extended-pdf-viewer';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignUpComponent,
    MemberHomeComponent,
    ChangeProfileComponent,
    FooterComponent,
    HeaderComponent,
    SidebarComponent,
    StartClubComponent,
    MyClubsComponent,
    UpdateClubComponent,
    FileUploadComponent,
    StartProjectComponent,
    MyProjectsComponent,
    ForgotPasswordComponent,
    ClubApplicationsComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
	  FormsModule,
	  HttpClientModule,
	  ToastModule,
	  BrowserAnimationsModule,
	  FieldsetModule,
	  FlexLayoutModule,
    FileUploadModule,
    TableModule,
    NgxExtendedPdfViewerModule

  ],
  providers: [RestfulService, MessageService],
  bootstrap: [AppComponent]
})
export class AppModule { }

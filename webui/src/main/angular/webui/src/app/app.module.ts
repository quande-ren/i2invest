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
import { FieldsetModule } from 'primeng/fieldset';
import { FooterComponent } from './layout/footer/footer.component';
import { HeaderComponent } from './layout/header/header.component';
import { SidebarComponent } from './layout/sidebar/sidebar.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { FileUploadComponent } from './publc/file-upload/file-upload.component';
import { ForgotPasswordComponent } from './publc/forgot-password/forgot-password.component';
import { TableModule } from 'primeng/table';
import { ClubApplicationsComponent } from './member/club-applications/club-applications.component';
import { FileUploadModule } from 'primeng/fileupload';
import { DragDropModule } from '@angular/cdk/drag-drop';
import { NgxExtendedPdfViewerModule } from 'ngx-extended-pdf-viewer';
import { MyItemComponent } from './my-item/my-item.component';
import { DocuSignItemComponent } from './docu-sign-item/docu-sign-item.component';
import { EditorModule } from 'primeng/editor';
import { CheckboxModule } from 'primeng/checkbox';
import { RadioButtonModule } from 'primeng/radiobutton';
import { InputSwitchModule } from 'primeng/inputswitch';
import { ProfileUpdateComponent } from './member/profile-update/profile-update.component';
import { ClubCreateComponent } from './member/club-create/club-create.component';
import { ClubListComponent } from './member/club-list/club-list.component';
import { ClubUpdateComponent } from './member/club-update/club-update.component';
import { ProjectCreateComponent } from './member/project-create/project-create.component';
import { ProjectListComponent } from './member/project-list/project-list.component';
import { PropertyListComponent } from './member/property-list/property-list.component';
import { ProjectUpdateComponent } from './member/project-update/project-update.component';
import { PropertyCreateComponent } from './member/property-create/property-create.component';
import { PropertyUpdateComponent } from './member/property-update/property-update.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignUpComponent,
    MemberHomeComponent,
    ProfileUpdateComponent,
    FooterComponent,
    HeaderComponent,
    SidebarComponent,
    ClubCreateComponent,

    ClubListComponent,
    ClubUpdateComponent,
    FileUploadComponent,
    ProjectCreateComponent,
    ProjectListComponent,
    ForgotPasswordComponent,
    ClubApplicationsComponent,
    MyItemComponent,
    DocuSignItemComponent,
    PropertyListComponent,
    ProjectUpdateComponent,
    PropertyCreateComponent,
    PropertyUpdateComponent

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
    NgxExtendedPdfViewerModule,
    DragDropModule,
    EditorModule,
    CheckboxModule,
    RadioButtonModule,
    InputSwitchModule
  ],
  providers: [RestfulService, MessageService],
  bootstrap: [AppComponent]
})
export class AppModule { }

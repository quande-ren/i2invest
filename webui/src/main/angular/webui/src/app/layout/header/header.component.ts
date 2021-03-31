import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { ClubVo } from 'src/app/model/club-vo.model';
import { UserVo } from 'src/app/model/user-vo.model';
import { RestfulService } from 'src/app/services/restful.service';
import { SessionManagerService } from 'src/app/services/session-manager.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private restfulService : RestfulService,
    private messageService: MessageService,
    public sessionManager : SessionManagerService,
    private router: Router,) { }

  ngOnInit(): void {
  }


  doLogout(){
    this.sessionManager.email='';
    this.sessionManager.token='';
    this.sessionManager.clubVo=new ClubVo();
    this.sessionManager.userVo=new UserVo();
    this.sessionManager.isLoggedIn=false;
    this.router.navigateByUrl('/signin');
  }

}

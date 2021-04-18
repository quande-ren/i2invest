import { Injectable } from '@angular/core';
import { ClubVo } from '../model/club-vo.model';
import { ProjectVo } from '../model/project-vo.model';
import { PropertyVo } from '../model/property-vo.model';
import { UserVo } from '../model/user-vo.model';

@Injectable({
  providedIn: 'root'
})
export class SessionManagerService {
  public userVo : UserVo;
  //public clubVo : ClubVo;
  public currentClub : ClubVo;
  public currentProject : ProjectVo;
  public currentProperty : PropertyVo;
  public token='';
  public email='';
  public isLoggedIn=false;
	
  constructor() { }
}

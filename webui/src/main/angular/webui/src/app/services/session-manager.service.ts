import { Injectable } from '@angular/core';
import { ClubVo } from '../model/club-vo.model';
import { UserVo } from '../model/user-vo.model';

@Injectable({
  providedIn: 'root'
})
export class SessionManagerService {
  public userVo : UserVo;
  public clubVo : ClubVo;
  public token='';
  public email='';
  public isLoggedIn=false;
	
  constructor() { }
}

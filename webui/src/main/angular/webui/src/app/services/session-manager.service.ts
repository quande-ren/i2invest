import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SessionManagerService {
  public userVo : any;
  public token='';
  public email='';
	
  constructor() { }
}

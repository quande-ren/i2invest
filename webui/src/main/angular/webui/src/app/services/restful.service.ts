import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { MessageService } from 'primeng/api';

@Injectable()
export class RestfulService {

  	constructor(private http: HttpClient, private messageService: MessageService) { }

	public callRestful(jsonType:string, jsonObj: any, callback: any) {
		
		let dtoWrapper={type: jsonType, jsonString: JSON.stringify(jsonObj)};
		
		//console.log("login using " + this.email + " " + this.password);
		return this.http
		           .post(environment.API_BASE_URL+"/api/postJson3", dtoWrapper)
				   .subscribe(
								response 	=> this.handleResponse(response, callback), 
								err 		=> this.handleError(err)						
					  		 );
	}

	private handleResponse(response: any, callback: any) {
	      if(response.success){
	        callback(response);
	      }else{
	        this.messageService.add({severity:'error', summary: 'Error', detail: response.errorMessage+' ('+response.errorCode+')' });
	      }
	}
	
	private handleError(error: Response) {
	    console.log(error.status + ' :: ' + + JSON.stringify(error) );
	    this.messageService.add({severity:'error', summary: 'Error Message', detail:error+''});
  	}


}

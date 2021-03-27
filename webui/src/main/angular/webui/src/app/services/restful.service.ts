import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';

@Injectable()
export class RestfulService {

  	constructor(private http: HttpClient) { }

	public callRestful(jsonType:string, jsonObj: any): Observable<any> {
		let dtoWrapper={type: jsonType, jsonString: JSON.stringify(jsonObj)};
		
		//console.log("login using " + this.email + " " + this.password);
		return this.http.post(environment.API_BASE_URL+"/api/postJson3", dtoWrapper)
			//.map(res=>res.json())
			//.catch(this.handleError);
	}
	
	private handleError(error: Response) {
	    console.log(error.status + ' :: ' + + JSON.stringify(error) );
	    //return Observable.throw(error.json().error );
  	}


}

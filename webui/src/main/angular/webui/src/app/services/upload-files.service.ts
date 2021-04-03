import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RestfulService } from './restful.service';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UploadFilesService {


  constructor(private http: HttpClient, 
              private restfulService : RestfulService) { }

  upload(file: File): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();

    formData.append('file', file);

    const req = new HttpRequest('POST', environment.API_BASE_URL+'/fileupload', formData, {
      reportProgress: true,
      responseType: 'json'
    });

    return this.http.request(req);
  }

}

import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RestfulService } from './restful.service';

@Injectable({
  providedIn: 'root'
})
export class UploadFilesService {

  private baseUrl = 'http://localhost:8080/i2invest';

  constructor(private http: HttpClient, 
              private restfulService : RestfulService) { }

  upload(file: File): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();

    formData.append('file', file);

    const req = new HttpRequest('POST', `${this.baseUrl}/upload`, formData, {
      reportProgress: true,
      responseType: 'json'
    });

    return this.http.request(req);
  }

}

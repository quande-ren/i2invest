import { HttpEvent, HttpEventType, HttpRequest, HttpResponse } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { Observable } from 'rxjs';
import { FileVo } from 'src/app/model/file-vo.model';
import { RestfulService } from 'src/app/services/restful.service';
import { UploadFilesService } from 'src/app/services/upload-files.service';
import { environment } from 'src/environments/environment';
import { pdfDefaultOptions } from 'ngx-extended-pdf-viewer';


@Component({
  selector: 'app-file-upload',
  templateUrl: './file-upload.component.html',
  styleUrls: ['./file-upload.component.css']
})
export class FileUploadComponent implements OnInit {


  onClick(evt:any){
    console.log(evt.clientX+" "+evt.clientY);
}  

  width = 600;
  height = 1000;
  draggables = [
    { x: 0, y: 0 },
    { x: 300, y: 300 },
    { x: 0, y: 300 },
    { x: 300, y: 0 },
  ];



  uploadUrl=environment.API_BASE_URL+'/fileapi/fileUpload';

  uploadedFiles: any[] = [];

  files: FileVo[];

  constructor(
      private uploadService: UploadFilesService, 
      private messageService: MessageService,
      private router: Router,
      private restfulService : RestfulService) { 
	//pdfDefaultOptions.assetsFolder = 'bleeding-edge';
	}

  fillColor = 'rgb(255, 0, 0)';

  changeColor() {
    const r = Math.floor(Math.random() * 256);
    const g = Math.floor(Math.random() * 256);
    const b = Math.floor(Math.random() * 256);
    this.fillColor = `rgb(${r}, ${g}, ${b})`;
  }

  

  ngOnInit(): void {
    //this.fileInfos = this.uploadService.getFiles();
    this.retrieveFiles();
  }


  onUpload(event:any) {
    for(let file of event.files) {
        this.uploadedFiles.push(file);
    }

    this.messageService.add({severity: 'info', summary: 'File Uploaded', detail: ''});
  }

  retrieveFiles(){

    let jsonType='FileRequest';
		let jsonObj={requestType: 'RetrieveWithoutData'};

		this.restfulService.callRestful(jsonType, jsonObj).subscribe(
		 	response => {
							if(response.success){
								console.log(response);
                this.files=response.files;
								this.messageService.add({severity:'message', summary: 'Success', detail: 'File Retrieved' });
							}else{
								this.messageService.add({severity:'error', summary: 'Error Sign Up', detail: response.errorMessage+' ('+response.errorCode+')' });
							}
						},
			 
		 	error   => 	{
							this.messageService.add({severity:'error', summary: 'Error Message', detail:error});
						}
		);    

  }

  /*

  upload(): void {
    this.progress = 0;
  
    if (this.selectedFiles) {
      const file: File | null = this.selectedFiles.item(0);
  
      if (file) {
        this.currentFile = file;
  
        this.uploadService.upload(this.currentFile).subscribe(
          (event: any) => {
            if (event.type === HttpEventType.UploadProgress) {
              this.progress = Math.round(100 * event.loaded / event.total);
            } else if (event instanceof HttpResponse) {
              this.message = event.body.message;
              // this.fileInfos = this.uploadService.getFiles();
              this.retrieveFiles();
            }
          },
          (err: any) => {
            console.log(err);
            this.progress = 0;
  
            if (err.error && err.error.message) {
              this.message = err.error.message;
            } else {
              this.message = 'Could not upload the file!';
            }
  
            this.currentFile = undefined;
          });
      }
  
      this.selectedFiles = undefined;
    }
  }
*/
}

import { Component, ComponentFactory, ComponentFactoryResolver, ComponentRef, Input, OnInit, ViewChild, ViewContainerRef } from '@angular/core';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { FileVo } from 'src/app/model/file-vo.model';
import { RestfulService } from 'src/app/services/restful.service';
import { UploadFilesService } from 'src/app/services/upload-files.service';
import { environment } from 'src/environments/environment';
import { CdkDragEnd } from '@angular/cdk/drag-drop';
import { DocuSignItemComponent } from 'src/app/docu-sign-item/docu-sign-item.component';


@Component({
  selector: 'app-file-upload',
  templateUrl: './file-upload.component.html',
  styleUrls: ['./file-upload.component.css']
})
export class FileUploadComponent implements OnInit {


  @ViewChild("dynamicElementContainer", { read: ViewContainerRef }) container: any;
  componentRef: ComponentRef<DocuSignItemComponent>;
  
  createDragDrop(imageFile: string, text: string):void {
    console.log("in createDragDrop");
    const factory: ComponentFactory<DocuSignItemComponent> = this.resolver.resolveComponentFactory(DocuSignItemComponent);
    this.componentRef = this.container.createComponent(factory);
    this.componentRef.instance.imageFile=imageFile;
    this.componentRef.instance.text=text;
  }


  onClick(evt:any):void{
    console.log(evt.clientX+" "+evt.clientY);
  }  

  uploadUrl=environment.API_BASE_URL+'/fileapi/fileUpload';

  uploadedFiles: any[] = [];

  files: FileVo[];

  constructor(
      private messageService: MessageService,
      private resolver: ComponentFactoryResolver,
      private restfulService : RestfulService) { 
	}

  dragEnd(event: CdkDragEnd) {
    console.log(event.source.getFreeDragPosition());
  }

  ngOnInit(): void {
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

		this.restfulService.callRestful(jsonType, jsonObj, 
			(response)=> {
							console.log(response);
                			this.files=response.files;
							this.messageService.add({severity:'message', summary: 'Success', detail: 'File Retrieved' });
						});    

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

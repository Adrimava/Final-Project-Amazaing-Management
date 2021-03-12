import { Component, OnInit } from '@angular/core';
import { AmazaingManagementService } from 'src/app/services/amazaing-management.service';
import { BusinessModel } from 'src/app/services/interfaces/database.interface';

@Component({
  selector: 'app-business-model',
  templateUrl: './business-model.component.html',
  styleUrls: ['./business-model.component.css']
})
export class BusinessModelComponent implements OnInit {

  businessModelList: BusinessModel[] = [];
  businessModel: BusinessModel;
  detailsVisible: boolean = false;
  showDetail: Boolean[] = []

  constructor(
    private amazaingManagementService: AmazaingManagementService
  ) { }

  ngOnInit(): void {
    this.getBusinessModels();
  }

  getBusinessModels(): void {
    this.amazaingManagementService.getAllBusinessModel().subscribe(result => {
      this.businessModelList = result;
    }, error => {
      console.log(error);
    });
  }

  businessModelDetails(id: number): void {
    this.amazaingManagementService.getBusinessModelById(id).subscribe(result => {
      this.businessModel = result;
    });
    if (!this.detailsVisible || id === this.businessModel.modelId) {
      this.detailsVisible = !this.detailsVisible;
    }
  }

  showDetails(index: number):void {
    if(this.showDetail[index] === false) {
      this.showDetail = []
      for(let i = 0; i < this.businessModelList.length; i++) {
        this.showDetail.push(false)
      }
      this.showDetail[index] = true;
    } else {
      this.showDetail[index] = false;
    }
  }

}

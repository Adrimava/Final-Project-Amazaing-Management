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
  businessModel: BusinessModel = null;

  constructor(
    private amazaingManagementService: AmazaingManagementService
  ) { }

  ngOnInit(): void {
    this.showBusinessModels();
  }

  showBusinessModels(): void {
    this.amazaingManagementService.getAllBusinessModel().subscribe(result => {
      this.businessModelList = result;
    }, error => {
      console.log(error);
    });
  }

  showDetails(id: number): void {
    this.amazaingManagementService.getBusinessModelById(id).subscribe(result => {
      this.businessModel = result;
    });
  }

}

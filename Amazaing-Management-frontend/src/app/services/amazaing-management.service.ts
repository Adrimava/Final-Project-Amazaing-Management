import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BusinessModel } from './interfaces/database.interface';

@Injectable({
  providedIn: 'root'
})
export class AmazaingManagementService {

  constructor(
    private http: HttpClient
  ) { }

  getAllBusinessModel(): Observable<BusinessModel[]> {
    return this.http.get<BusinessModel[]>('http://localhost:8080/business-model');
  }

  getBusinessModelById(id: number): Observable<BusinessModel> {
    return this.http.get<BusinessModel>(`http://localhost:8080/business-model/${id}`);
  }

}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BusinessModel, Company, Player } from './interfaces/database.interface';

@Injectable({
  providedIn: 'root'
})
export class AmazaingManagementService {

  constructor(
    private http: HttpClient
  ) { }

  
  /**
   *  Business Model Service 
   */

  getAllBusinessModel(): Observable<BusinessModel[]> {
    return this.http.get<BusinessModel[]>('http://localhost:8080/business-model');
  }

  getBusinessModelById(id: number): Observable<BusinessModel> {
    return this.http.get<BusinessModel>(`http://localhost:8080/business-model/${id}`);
  }

  
  /**
   *  Player service
   */

  getAllPlayers(): Observable<Player[]> {
    return this.http.get<Player[]>('http://localhost:8080/players');
  }

  getPlayerById(id: number): Observable<Player> {
    return this.http.get<Player>(`http://localhost:8080/player/${id}`);
  }

  storePlayer(player: any): void {
    this.http.post(`http://localhost:8080/player`, player).subscribe(data=>
    console.log('Posted new Player'));
  }

  updatePlayer(id: number, player: any): void {
    this.http.put(`http://localhost:8080/player/${id}`, player).subscribe(data=>
    console.log('Player updated'));
  }

  deletePlayer(id: number): void {
    this.http.delete(`http://localhost:8080/player/${id}`).subscribe(data=>
    console.log(`Deleted player with id ${id}`));
  }

  /**
   *  Company service
   */

    getAllCompanies(): Observable<Company[]> {
      return this.http.get<Company[]>('http://localhost:8080/companies');
    }
  
    getCompanyById(id: number): Observable<Company> {
      return this.http.get<Company>(`http://localhost:8080/company/${id}`);
    }
  
    storeCompany(company: any): void {
      this.http.post(`http://localhost:8080/company`, company).subscribe(data=>
      console.log('Posted new company'));
    }
  
    updateCompany(id: number, company: any): void {
      this.http.put(`http://localhost:8080/company/${id}`, company).subscribe(data=>
      console.log('company updated'));
    }
  
    deleteCompany(id: number): void {
      this.http.delete(`http://localhost:8080/company/${id}`).subscribe(data=>
      console.log(`Deleted Company with id ${id}`));
    }

}

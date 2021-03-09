import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PlayerDTO } from '../models/player-dto';
import { BusinessModel, Player } from './interfaces/database.interface';

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
    console.log('Post new Player'));
  }

  updatePlayer(id: number, player: any): void {
    this.http.put(`http://localhost:8080/player/${id}`, player).subscribe(data=>
    console.log('Update Player'));
  }

  deletePlayer(id: number): void {
    this.http.delete(`http://localhost:8080/player/${id}`).subscribe(data=>
    console.log(`Deleted player with id ${id}`));
  }

}

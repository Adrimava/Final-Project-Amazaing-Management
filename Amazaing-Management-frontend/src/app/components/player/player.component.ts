import { Component, OnInit } from '@angular/core';
import { PlayerDTO } from 'src/app/models/player-dto';
import { AmazaingManagementService } from 'src/app/services/amazaing-management.service';
import { Player } from 'src/app/services/interfaces/database.interface';

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.css']
})
export class PlayerComponent implements OnInit {

  playerList: Player[] = [];
  player: Player = null;
  playerName: string = '';
  money: number = 1000;
  playerPhoto: string = 'human';
  formIsVisible: boolean = false;
  difficulty: string = 'easy'
  gender: string = 'human';

  constructor(
    private amazaingManagementService: AmazaingManagementService
  ) { }

  ngOnInit(): void {
    this.getPlayers();
    setTimeout(()=>{ this.playerDetails(this.playerList[0].playerId); }, 50);
  }

  getPlayers(): void {
    this.amazaingManagementService.getAllPlayers().subscribe(result => {
      this.playerList = result;
    }, error => {
      console.log(error);
    });
  }

  playerDetails(id: number): void {
    this.amazaingManagementService.getPlayerById(id).subscribe(result => {
      this.player = result;
    });
  }

  createPlayer(): void {    
    if (this.difficulty === 'easy') {
      this.money = 2000;
    } else if (this.difficulty === 'medium') {
      this.money = 1000;
    } else {
      this.money = 500;
    }
    let player: PlayerDTO = new PlayerDTO(this.playerName, this.money, this.playerPhoto);
    this.amazaingManagementService.storePlayer(this.body(player));
    this.playerName = '';
    setTimeout(()=>{ this.getPlayers(); }, 100);
    setTimeout(()=> {this.player = this.playerList[this.playerList.length - 1] }, 200 );  
    this.showForm();
  }

  updatePlayer(id: number): void {
    let player: PlayerDTO = new PlayerDTO(this.playerName, this.money, this.playerPhoto);
    this.amazaingManagementService.updatePlayer(id, this.body(player));
    setTimeout(()=>{ this.getPlayers(); }, 100);
    setTimeout(()=>{ this.player = this.playerList[this.playerList.length - 1] }, 200 ); 
  }

  deletePlayer(id: number): void {
    this.amazaingManagementService.deletePlayer(id);
    setTimeout(()=>{ this.getPlayers(); }, 100);
    setTimeout(()=>{ this.player = this.playerList[this.playerList.length - 1] }, 200 ); 
  }

  body(player: PlayerDTO): any {
    let playerBody: any = {
      playerName: player.playerName,
      money: player.money,
      photo: player.photo
    }
    return playerBody;
  }

  showForm(): void {
    this.formIsVisible = !this.formIsVisible;
  }

}

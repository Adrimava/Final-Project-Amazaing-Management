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
  playerPhoto: string = 'default picture';

  constructor(
    private amazaingManagementService: AmazaingManagementService
  ) { }

  ngOnInit(): void {
    this.getPlayers();
    this.playerDetails(1);
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
    let player: PlayerDTO = new PlayerDTO(this.playerName, this.money, this.playerPhoto);
    this.amazaingManagementService.storePlayer(this.body(player));
    this.playerName = '';
  }

  updatePlayer(id: number): void {
    let player: PlayerDTO = new PlayerDTO(this.playerName, this.money, this.playerPhoto);
    this.amazaingManagementService.updatePlayer(id, this.body(player));
  }

  deletePlayer(id: number): void {
    this.amazaingManagementService.deletePlayer(id);
  }

  body(player: PlayerDTO): any {
    let playerBody: any = {
      playerName: player.playerName,
      money: player.money,
      photo: player.photo
    }
    return playerBody;
  }

}

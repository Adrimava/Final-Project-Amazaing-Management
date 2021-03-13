import { Component, EventEmitter, Input, OnChanges, OnInit, Output } from '@angular/core';
import { PlayerDTO } from 'src/app/models/player-dto';
import { AmazaingManagementService } from 'src/app/services/amazaing-management.service';
import { Player } from 'src/app/services/interfaces/database.interface';

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.css']
})
export class PlayerComponent implements OnInit, OnChanges {

  playerList: Player[] = [];
  player: Player = null;
  playerName: string = '';
  money: number = 1000;
  playerPhoto: string = 'human';
  formIsVisible: boolean = false;
  difficulty: string = 'easy'
  gender: string = 'human';
  firstCompany: number = 1;

  @Output() sendPlayerEvent = new EventEmitter<number>();
  @Output() sendFirstCompanyEvent = new EventEmitter<number>();
  @Output() sendMoneyEvent = new EventEmitter<number>();

  @Input()
  moneyChanges: number = 0;

  constructor(
    private amazaingManagementService: AmazaingManagementService
  ) { }

  ngOnInit(): void {
    this.getPlayers();
    setTimeout(()=>{ this.playerDetails(this.playerList[0].playerId); }, 50);
  }

  ngOnChanges(): void {
    this.player.money += this.moneyChanges;
    this.moneyChanges = 0;
    this.updatePlayer(this.player.playerId);
    this.sendMoneyEvent.emit(this.player.money);
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
      this.sendFirstCompanyEvent.emit(this.firstCompany);
      this.sendPlayerEvent.emit(this.player.playerId);
      this.sendMoneyEvent.emit(this.player.money);
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
    setTimeout(() => { this.playerDetails(this.player.playerId); }, 200);
  }

  updatePlayer(id: number): void {
    let player: PlayerDTO = new PlayerDTO(this.player.playerName, this.player.money, this.player.photo);
    this.amazaingManagementService.updatePlayer(id, this.body(player));
    setTimeout(()=>{ this.getPlayers(); }, 100);
  }

  deletePlayer(id: number): void {
    if (this.playerList.length > 1) {
      this.amazaingManagementService.deletePlayer(id);
      setTimeout(()=>{ this.getPlayers(); }, 100);
      setTimeout(()=>{ this.playerDetails(this.playerList[this.playerList.length - 1].playerId) }, 200 );
    }
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

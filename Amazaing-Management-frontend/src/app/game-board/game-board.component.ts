import { Component, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-game-board',
  templateUrl: './game-board.component.html',
  styleUrls: ['./game-board.component.css']
})
export class GameBoardComponent implements OnInit {

  currentPlayer: number = 1;
  firstCompany: number = 1;
  money: number = 1000;
  moneyChanges: number = 0;

  getCurrentPlayer($event: number) {
    this.currentPlayer = $event;
  }

  getFirstCompany($event: number) {
    this.firstCompany = $event;
  }

  getMoney($event: number) {
    this.money = $event;
  }

  getMoneyChanges($event: number) {
    this.moneyChanges = $event;
  }

  constructor() { }

  ngOnInit(): void {
  }

}

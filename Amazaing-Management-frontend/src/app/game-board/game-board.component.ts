import { Component, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-game-board',
  templateUrl: './game-board.component.html',
  styleUrls: ['./game-board.component.css']
})
export class GameBoardComponent implements OnInit {

  currentPlayer: number = 1;

  getCurrentPlayer($event: number) {
    this.currentPlayer = $event;
  }

  constructor() { }

  ngOnInit(): void {
  }

}

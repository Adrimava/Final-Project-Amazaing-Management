import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { BusinessModelComponent } from './components/business-model/business-model.component';
import { PlayerComponent } from './components/player/player.component';
import { FormsModule } from '@angular/forms';
import { CompanyComponent } from './components/company/company.component';
import { EmployeeComponent } from './components/employee/employee.component';
import { GameBoardComponent } from './game-board/game-board.component';

@NgModule({
  declarations: [
    AppComponent,
    BusinessModelComponent,
    PlayerComponent,
    CompanyComponent,
    EmployeeComponent,
    GameBoardComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

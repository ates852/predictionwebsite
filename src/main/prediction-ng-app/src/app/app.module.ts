import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StandingslistComponent } from './components/standingslist/standingslist.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { UserTeamStandingsListComponent } from './components/user-team-standings-list/user-team-standings-list.component';

@NgModule({
  declarations: [
    AppComponent,
    StandingslistComponent,
    UserTeamStandingsListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

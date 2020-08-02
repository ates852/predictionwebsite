import {Component, OnInit} from '@angular/core';
import {StandingsService} from "../../services/standings.service";

export interface UserTeam {
  id: Number;
  nameOfTeam: String;
  position: Number;
  userId: Number;
}

@Component({
  selector: 'app-user-team-standings-list',
  templateUrl: './user-team-standings-list.component.html',
  styleUrls: ['./user-team-standings-list.component.css']
})

export class UserTeamStandingsListComponent implements OnInit {

  TeamArray = [];

  constructor(private standingsService: StandingsService) {
  }

  ngOnInit(): void {
    this.standingsService.getList().subscribe((res: UserTeam) => {
      this.TeamArray
    })
  }
}

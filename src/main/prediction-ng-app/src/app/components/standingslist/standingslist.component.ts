import {Component, OnInit} from '@angular/core';
import {StandingsService} from "../../services/standings.service";

@Component({
  selector: 'app-standingslist',
  templateUrl: './standingslist.component.html',
  styleUrls: ['./standingslist.component.css']
})
export class StandingslistComponent implements OnInit {

  ItemArray = [];

  constructor(private standingsService: StandingsService) {
  }

  ngOnInit() {
    this.standingsService.getList().subscribe((res: any[]) => {
      this.ItemArray = res;
    })
  }
}

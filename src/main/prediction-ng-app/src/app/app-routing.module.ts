import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StandingslistComponent} from "./components/standingslist/standingslist.component";

const routes: Routes = [
  { path: '', redirectTo: 'standings', pathMatch: 'full' },
  { path: 'standings', component: StandingslistComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

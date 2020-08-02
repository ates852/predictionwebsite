import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

const baseUrl = "http://localhost:8080/userteams/list/1";

@Injectable({
  providedIn: 'root'
})

export class StandingsService {


  constructor(private http: HttpClient) { }

  getList(): Observable<any>{
    return this.http.get(baseUrl);
  }
}

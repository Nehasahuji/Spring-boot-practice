import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class EmployeeServiceService {
  url = environment.url;
  constructor(private httpClient: HttpClient) {}

  getData(id: any) {
     return this.httpClient.get<any>(`${this.url}/v2/employee/${id}`);
  }
}

import { Component, OnInit } from '@angular/core';
import { EmployeeServiceService } from '../employee-service.service';

@Component({
  selector: 'app-employee-info',
  templateUrl: './employee-info.component.html',
  styleUrls: ['./employee-info.component.less'],
})
export class EmployeeInfoComponent implements OnInit {
  id = 50;
  constructor(private employeeService: EmployeeServiceService) {}

  ngOnInit(): void {
    this.getData();
  }

  getData() {
    this.employeeService.getData(this.id).subscribe(
      (res) => {
        console.log(res);
      },
      (errorResponse) => {
        console.log("errorResponse",errorResponse);
        console.log(errorResponse.status);
        console.log(errorResponse.message);
        console.log(errorResponse.error.message);
      }
    );
  }
}

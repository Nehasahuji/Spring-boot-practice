import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EmployeeRoutingModule } from './employee-routing.module';
import { EmployeeInfoComponent } from './employee-info/employee-info.component';


@NgModule({
  declarations: [
    EmployeeInfoComponent
  ],
  imports: [
    CommonModule,
    EmployeeRoutingModule,
    
  ]
})
export class EmployeeModule { }

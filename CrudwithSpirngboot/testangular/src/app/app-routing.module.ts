import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import path from 'path';
import { ApitestComponent } from './apitest/apitest.component';

const routes: Routes = [
  { path: 'apitest', component: ApitestComponent }, // Corrected 'component' property
  { path: '', redirectTo: '/apitest', pathMatch: 'full' } // Redirect to /apitest by default

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

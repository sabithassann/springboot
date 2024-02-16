import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductionProductComponent } from './components/production-product/production-product.component';

const routes: Routes = [
  { path: 'products', component: ProductionProductComponent },
  { path: '', redirectTo: '/products', pathMatch: 'full' }, // Default route
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { Component, OnInit } from '@angular/core';
import { ProductionRecords } from '../../model/production-records.model';
import { ProductionQuantityService } from '../../service/production-quantity.service';
import { ProductionProductService } from '../../service/production-product.service';
import { ProductionProduct } from '../../model/production-product.model';

@Component({
  selector: 'app-production-quantity',
  templateUrl: './production-quantity.component.html',
  styleUrl: './production-quantity.component.css'
})
export class ProductionQuantityComponent implements OnInit{

  newProductionData: ProductionRecords = {
    productName: '',
    productionQuantity: null,
    productionDate: '',
    qualityControlInfo: '',
    batchNumber: ''
  };

  products: ProductionProduct[] = [];

  constructor(private productionQtyService: ProductionQuantityService,
    private productionProductService: ProductionProductService
    ){}

    ngOnInit(): void {
      this.loadProducts();
    }


  submitProduction(): void {
    this.productionQtyService.productProduct(this.newProductionData)
      .subscribe(
        response => {
          console.log('Production successful:', response);
          // Optionally, perform any additional actions after successful production
        },
        error => {
          console.error('Error producing product:', error);
          // Optionally, handle error messages or display them to the user
        }
      );
  }



  loadProducts(): void {
    this.productionProductService.getAllProducts()
      .subscribe(
        products => {
          this.products = products;
          console.log('Production products loaded:', this.products);
        },
        error => {
          console.error('Error loading production products:', error);
          // Optionally, handle error messages or display them to the user
        }
      );
  }

}

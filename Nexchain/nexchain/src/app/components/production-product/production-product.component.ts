import { Component, OnInit } from '@angular/core';
import { ProductionProduct } from '../../model/production-product.model';
import { ProductionProductService } from '../../service/production-product.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-production-product',
  templateUrl: './production-product.component.html',
  styleUrls: ['./production-product.component.css'] // Change styleUrl to styleUrls

})
export class ProductionProductComponent implements OnInit{
  products: ProductionProduct[] = [];
  productForm: FormGroup;

  constructor(private productionProductService: ProductionProductService) {
    this.productForm = new FormGroup({
      newProductName: new FormControl('', Validators.required)
    });
  }
  
  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts(): void {
    this.productionProductService.getAllProducts().subscribe(products => {
      this.products = products;
    });
  }

  deleteProduct(id: number | undefined): void {
    if (id !== undefined) {
      this.productionProductService.deleteProduct(id).subscribe(() => {
        this.loadProducts();
      });
    }
  }

  addProduct(): void {
    if (this.productForm.valid) {
      const newProduct: ProductionProduct = {
        productName: this.productForm.value.newProductName
      };
  
      this.productionProductService.createProduct(newProduct).subscribe(() => {
        this.productForm.reset(); // Reset the form
        this.loadProducts(); // Reload the list of products
      });
    }
  }

}

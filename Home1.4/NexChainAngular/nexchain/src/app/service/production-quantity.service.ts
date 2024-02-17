import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ProductionRecords } from '../model/production-records.model';
import { Observable, catchError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductionQuantityService {

  private baseUrl= 'http://localhost:8084/production';

  constructor(private http: HttpClient) { }


  productProduct(data: ProductionRecords):Observable<any>{
    return this.http.post<any>(`${this.baseUrl}/produceProduct`, data)
    .pipe(
      catchError(this.handleError)
    );
  }

  private handleError(error: any): Observable<never> {
    console.error('An error occurred:', error);
    throw error;
  }

}


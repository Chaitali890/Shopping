import { Injectable } from '@angular/core';
import { HttpService } from './http.service';
import { Observable } from 'rxjs';
import { ENDPOINTS, SERVICES } from '../constant/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpService:HttpService) { }

  getAllProducts():Observable<any>{
    return this.httpService.getMethod(SERVICES.PROD,ENDPOINTS.ALL);
  }
  
  getProductBySubCatId(subCatId:number):Observable<any>{
    return this.httpService.getMethodByRefId(SERVICES.PROD,ENDPOINTS.BY_REF_ID,subCatId);
  }
}

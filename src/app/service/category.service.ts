import { Injectable } from '@angular/core';
import { HttpService } from './http.service';
import { Observable } from 'rxjs';
import { ENDPOINTS, SERVICES } from '../constant/http';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private httpService:HttpService) { }

  getMethodByMainCatId(mainCatId:number):Observable<any>{
    return this.httpService.getMethodByRefId(SERVICES.CAT,ENDPOINTS.BY_REF_ID,mainCatId);
  }
}

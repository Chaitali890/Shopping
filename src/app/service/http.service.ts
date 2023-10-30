import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppURL, ENDPOINTS, SERVICES } from '../constant/http';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

 headers = new HttpHeaders({
    'Content-Type':'application/json'
 });
  

  constructor(private http:HttpClient) { }

  // getMainCategory():Observable<any>{
  //   return this.http.get(AppURL++,{headers:this.headers})
  // }

  getMethod(service:string,endpoint:string):Observable<any>{
    return this.http.get(AppURL + service + endpoint, { headers: this.headers });
  }
 
  // getMethodByMainCatId(mainCatId:number):Observable<any>{
  //   return this.http.get(AppURL+++,{headers:this.headers})
  // }

  
  getMethodByRefId(service:String,endpoint:String,refid:number):Observable<any>{
    return this.http.get(AppURL + service + endpoint + refid, { headers: this.headers });
  }

  postMethod(service:string,endpoint:string,body:any):Observable<any>{
    return this.http.post(AppURL + service + endpoint,body, { headers:this.headers});
  }
  



}

import { Injectable } from '@angular/core';
import { HttpService } from './http.service';
import { User } from '../model/user';
import { ENDPOINTS, SERVICES } from '../constant/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpService:HttpService) { }

  // public signIn(username:string,password:string){
  //   alert("ABC");
  // }

  public signIn(user:User):Observable<any>{
   return this.httpService.postMethod(SERVICES.USER,ENDPOINTS.LOGIN,user);


  }
  
} 

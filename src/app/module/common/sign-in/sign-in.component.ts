import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  constructor(private userService:UserService) {}

  ngOnInit(): void {
   
  }
  

// username!:string;
// password!:string;

// user!:User;
// signIn():void{
// this.userService.signIn(this.username,this.password);
// }

// signIn():void{
//   this.user.email = this.username;
//   this.user.password = this.password;
//   this.userService.signIn(this.user).subscribe((response:any) => {
//     if(response.success===true){
//       this.user = response.data;
//       sessionStorage.setItem("user",this.user.userId.toString());
//       window.location.href='/';
//     }
//   });
//   }


user:User = new User();
signIn():void{
  this.userService.signIn(this.user).subscribe((response:any) => {
    if(response.success===true){
      this.user = response.data;
      sessionStorage.setItem("userId",this.user.userId.toString());
      window.location.href='/';
    }
  });
  }




}

import { Component,EventEmitter,Input,OnInit, Output } from '@angular/core';
import { Cart } from 'src/app/model/cart';
import { Product } from 'src/app/model/product';
import { User } from 'src/app/model/user';
import { CartService } from 'src/app/service/cart.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  @Input()

  product!:Product;

  @Output() cartCount = new EventEmitter<string>();
  
  constructor(private cartService:CartService) {}

  user:any
  cart !: Cart;

  ngOnInit(): void {
  this.getCartCount();
  }

  // addToCart(prodId:string):void{
  //   this.user = sessionStorage.getItem("user")   
  //   if(this.user && this.user.userId && this.user.userId!=='0'){

  //   } 
  //   else{
  //         console.log("I am in else section");
  //         window.location.href='/signin';

  //   }
  // }

  addNewItem(value: string) {
    this.cartCount.emit(value);  

  }


  addToCart(prodId:string):void{
    var userId = sessionStorage.getItem("userId")   
     if(userId && userId!=='0'){
        // alert("success");
        this.cart = new Cart();
        this.cart.prodId = prodId;
        this.cart.userId = userId;
        this.cart.status='active';
        this.cartService.addCart(this.cart).subscribe((response:any) => {
          if(response.success===true){
            this.cart = response.data;
            alert("product added to cart");
          }
        });
       this.getCartCount();
     } 
     else{
           console.log("I am in else section");
           window.location.href='/signin';
     }
}
getCartCount(){
  var userId = JSON.parse(sessionStorage.getItem("userId") || '{}')
  this.cartService.getCartByUserId(userId).subscribe((response:any)=>{
    if(response.success===true){
      console.log("AA"+response.data);
     // this.cartCount = response.data.length;
      var cartCount = response.data.length;
      console.log("AA"+cartCount);
      this.cartCount.emit(cartCount);  
    }
  });
}
}
import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/model/category';
import { MainCategory } from 'src/app/model/maincategory';
import { Product } from 'src/app/model/product';
import { CartService } from 'src/app/service/cart.service';
import { CategoryService } from 'src/app/service/category.service';
import { MaincategoryService } from 'src/app/service/maincategory.service';
import { ProductService } from 'src/app/service/product.service';
import { SubcategoryService } from 'src/app/service/subcategory.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
    constructor(private maincategoryService:MaincategoryService, private categoryService:CategoryService,private subcatService:SubcategoryService,private productService:ProductService,private cartService:CartService) {}

    maincategories:MainCategory[]=[];
    cartCount=0;

    // arrowname:string='keyboard_arrow_right';
    // isCollapse=false;

    searchText: string = '';

  products:Product[]=[];

  ngOnInit(): void {
      this.getMainCategory();
      this.getAllProducts();
  }
 
  setCartCount($event:any){
    console.log("BB:"+$event);
    this.cartCount = $event;
  }
  getMainCategory():void{
    this.maincategoryService.getMainCategory().subscribe((response:any) => {
      if(response.success===true){
        this.maincategories = response.data;
        this.maincategories.filter((maincategory:MainCategory)=>{
        this.getMethodByMainCatId(maincategory);
        });
       // console.log("MainCategory"+JSON.stringify(this.maincategories));
      }
    });
  }

  getMethodByMainCatId(maincategory:MainCategory){
    this.categoryService.getMethodByMainCatId(maincategory.mainCatId).subscribe((response:any) =>{
      if(response.success===true){
        maincategory.categoryList = response.data;
        maincategory.categoryList.filter((category:Category) => {
          this.getSubCategoriesByCatId(category);
          //console.log(maincategory.categoryList);
        });
      }
    });
  }

  getSubCategoriesByCatId(category:Category){
    this.subcatService.getSubCategoriesByCatId(category.catId).subscribe((response:any)=>{
      if(response.success===true){
        category.subCatList = response.data;
        category.cssClass='list-group collapse hide';
       // console.log("SubCategory"+JSON.stringify(category.subCatList));
      }
    });
  }
  
  changeArrow(mainCat:MainCategory){
    // this.arrowname= (mainCat.isCollapse===true)? 'keyboard_arrow_down' : 'keyboard_arrow_right';
    mainCat.isCollapse = !mainCat.isCollapse;
  }

  changeCatArrow(cat:Category){
    cat.isCollapse = !cat.isCollapse;
    cat.cssClass =  cat.isCollapse ? 'list-group collapse show':'list-group collapse hide';
  }

  getAllProducts(){
    this.productService.getAllProducts().subscribe((response:any) => {
      if(response.success===true){
        this.products = response.data;
       // console.log("Products"+JSON.stringify(this.products));
      }
    });
  }
}

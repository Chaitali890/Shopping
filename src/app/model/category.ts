import { SubCategory } from "./subcategory";

export interface Category{
    catId:number,
    catName:string,
    catDesc:string,
    status:string,
    mainCatId:number,
    catImage:string,
    catImageName:string,
    subCatList:SubCategory[],
    cssClass:string,
    isCollapse:boolean
}
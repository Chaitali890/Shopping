import { Category } from "./category";

export interface MainCategory{
    mainCatId:number,
    mainCatName:string,
    mainCatDesc:string,
    status:string,
    categoryList:Category[],
    isCollapse:boolean
}
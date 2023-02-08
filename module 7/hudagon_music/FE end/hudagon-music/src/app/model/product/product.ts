import { ProductOrderDetail } from "../order/product-order-detail";
import { Brand } from "./brand";
import { Category } from "./category";
import { Guitar } from "./guitar";
import { ImgUrlProduct } from "./img-url-product";
import { Piano } from "./piano";

export interface Product {
    [x: string]: import("d:/code/CodeGym2/C0622G1-DoHoangDuc/module 7/hudagon_music/FE end/hudagon-music/src/app/payload/response/product-detail-info-response").ProductDetailInfoResponse;
    id?: number;
    name?: string;
    registerDay?: string;
    description?: string;
    price?: number;
    quantity?: number;
    deleteStatus?: number;
    brand?: Brand;
    category?: Category;
    imgUrlProductList?: ImgUrlProduct[];
    guitar?: Guitar;
    piano?: Piano;
    productOrderDetailSet?: ProductOrderDetail[];
}

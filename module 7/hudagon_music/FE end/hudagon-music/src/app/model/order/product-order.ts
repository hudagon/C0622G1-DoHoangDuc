import { ProductOrderDetail } from "./product-order-detail";

export interface ProductOrder {
    id?: number;
    orderDate?: string;
    deleteStatus?: number;
    paymentStatus?: number;
    totalMoney?: number;
    productOrderDetailSet: any;
}

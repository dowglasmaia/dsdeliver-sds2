import { Product } from './types';

 /* verificando se o produto ja estar selecionado  ou não */
export function checkIsCelected(selectedProducts:Product[], product: Product) {
    return  selectedProducts.some(item => item.id === product.id);
}
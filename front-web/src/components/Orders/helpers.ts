import { Product } from "./types";

/* verificando se o produto ja estar selecionado  ou não */
export function checkIsCelected(selectedProducts: Product[], product: Product) {
  return selectedProducts.some((item) => item.id === product.id);
}

/* Formatando Valores Moeda*/
export function formatPrice(price: number) {
  const formatter = new Intl.NumberFormat("pt-BR", {
    style: "currency",
    currency: "BRL",
    minimumFractionDigits: 2,
  });
  return formatter.format(price);
}

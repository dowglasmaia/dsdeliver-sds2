export type Product = {
  id: number;
  name: string;
  price: number;
  description: string;
  imageUri: string;
};

export interface OrderLocationData {
  address: string;
  latitude: number;
  longitude: number;
}

type ProductId ={
  id: number
}

export type OrderPlaload ={
  products: ProductId[];
} & OrderLocationData;   // juntando um type com o outro, ou interface com outra, para  compartilhares os dados.

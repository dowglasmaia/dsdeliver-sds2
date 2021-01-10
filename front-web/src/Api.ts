import axios from "axios";

const API_URL = "http://localhost:8080";

const mapboxToken  = process.env.REACT_APP_ACCESS_TOKEN_MAP_BOX; // PEGANDO A VARIAVEL DE HAMBIENTE CRIADA PARA GUARDA O TEOKEN DE FORMA SEGURA.

export function fetchProducts() {
  return axios(`${API_URL}/products`);
}

/* retornar buscar para o endereço informada pelo ususrio */
export function  fetchLocalMapBox(local:string) {
  return axios (`https://api.mapbox.com/geocoding/v5/mapbox.places/${local}.json?access_token=${mapboxToken}`)
  
}

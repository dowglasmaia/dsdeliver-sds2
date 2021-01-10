import axios from "axios";
import { OrderPlaload } from "./components/Orders/types";

const mapboxToken = process.env.REACT_APP_ACCESS_TOKEN_MAP_BOX; // PEGANDO A VARIAVEL DE HAMBIENTE CRIADA PARA GUARDA O TEOKEN DE FORMA SEGURA.

const API_URL = "http://localhost:8080";

/* retornar buscar para o endereço informada pelo ususrio */
export function fetchLocalMapBox(local: string) {
  return axios(
    `https://api.mapbox.com/geocoding/v5/mapbox.places/${local}.json?access_token=${mapboxToken}`
  );
}

export function fetchProducts() {
  return axios.get(`${API_URL}/products`);
}

export function saveOrder(payload: OrderPlaload) {
  return axios.post(`${API_URL}/orders`, payload);
}

import { useEffect, useState } from "react"

import StepsHeader from "./StepsHeader"
import ProductsList from "./ProductsList"

import "./styles.css"
import { OrderLocationData, Product } from "./types";
import { fetchProducts } from "../../Api";
import OrderLocation from "./OrderLocation";
/*
interface IProductProps {
    id: number,
    name: string,
    description: string,
    imageUri: string,
    price: number
}*/


function Order() {
    
    // inicializando a lista Vazia.
    const [products, setProducts] = useState<Product[]>([]);  
    
    //pegando os dados da localização para enviar para a API de Back-end;
    const[orderLocation, setOrderLocation] = useState<OrderLocationData>();
    
    useEffect(() => {

        console.log(products)
        /* Listando produtos com requisição HTTP*/
        fetchProducts()
            .then(response => setProducts(response.data))
            .catch(error => console.log(error))

    }, [])

    return (
        <div className="orders-container">

            <StepsHeader />

            <ProductsList products={products}/>

            <OrderLocation onChangeLocation={location => setOrderLocation(location)}/>

        </div>
    )

}
export default Order;
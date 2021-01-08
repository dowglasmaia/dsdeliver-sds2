import { useEffect, useState } from "react"

import StepsHeader from "./StepsHeader"
import ProductsList from "./ProductsList"

import "./styles.css"
import { Product } from "./types";
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

            <OrderLocation/>

        </div>
    )

}
export default Order;
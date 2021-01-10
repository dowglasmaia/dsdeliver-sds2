import { useEffect, useState } from "react"

import StepsHeader from "./StepsHeader"
import ProductsList from "./ProductsList"

import "./styles.css"
import { OrderLocationData, Product } from "./types";
import { fetchProducts } from "../../Api";
import OrderLocation from "./OrderLocation";
import OrderSummary from "./OrderSummary";
import Footer from "../Footer";
import { checkIsCelected } from "./helpers";

function Order() {

    // inicializando a lista Vazia.
    const [products, setProducts] = useState<Product[]>([]);
    const [selectedProducts, setSelectedProducts] = useState<Product[]>([]); // armazena a lista de produtos selecionados
    
    //pegando os dados da localização para enviar para a API de Back-end;
    const [orderLocation, setOrderLocation] = useState<OrderLocationData>();

    useEffect(() => {

        console.log(products)
        /* Listando produtos com requisição HTTP*/
        fetchProducts()
            .then(response => setProducts(response.data))
            .catch(error => console.log(error))

    }, [])


    /* pegando a lsita de Produtos selecionados */
    const handleSelectProduct = (product: Product) => {

        /* verificando se o produto ja estar selecionado */
        const isAlreadySelected = checkIsCelected(selectedProducts, product);
      
        if (isAlreadySelected) {
          const selected = selectedProducts.filter(item => item.id !== product.id);
          setSelectedProducts(selected);
        } else {
          setSelectedProducts(previous => [...previous, product]);
        }
      }

    return (
        <>
            <div className="orders-container">

                <StepsHeader />

                <ProductsList 
                    products={products} 
                    onSelectProduct ={handleSelectProduct}
                    selectedProducts={selectedProducts}
                />

                <OrderLocation onChangeLocation={location => setOrderLocation(location)} />

                <OrderSummary />

            </div>

            <Footer />
        </>
    )

}
export default Order;
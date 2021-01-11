import { useEffect, useState } from "react"

import StepsHeader from "./StepsHeader"
import ProductsList from "./ProductsList"
import OrderLocation from "./OrderLocation";
import OrderSummary from "./OrderSummary";
import Footer from "../Footer";
import { checkIsCelected } from "./helpers";

import { OrderLocationData, Product } from "./types";

import { fetchProducts, saveOrder } from "../../Api";

import "./styles.css"

import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';


function Order() {

    // inicializando a lista Vazia.
    const [products, setProducts] = useState<Product[]>([]);
    const [selectedProducts, setSelectedProducts] = useState<Product[]>([]); // armazena a lista de produtos selecionados

    //pegando os dados da localização para enviar para a API de Back-end;
    const [orderLocation, setOrderLocation] = useState<OrderLocationData>();

    /* realizando a soma dos valores dos itens com REDUCE*/
    const totalPrice = selectedProducts.reduce((sum, item) => {
        return sum + item.price
    }, 0)

    useEffect(() => {

        console.log(products)
        /* Listando produtos com requisição HTTP*/
        fetchProducts()
            .then(response => setProducts(response.data))
            .catch(error => {
                toast.warning('Erro ao listar produtos')
            })
        //.catch(error => console.log(error))
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

    /* sbmetendo os dados para o servidor */
    const handleSubmit = () => {
        //iterando sobre a lista de produtos selecionado, e extraindo apenas o ID de cada produto.
        const productsIds = selectedProducts.map(({ id }) => ({ id }));

        //mergando tudo que a no ' orderLocation ' coms o ' productsIds 'par forma o payload 
        const payload = {
            ...orderLocation!,
            products: productsIds
        }

        saveOrder(payload)
            .then((response) => {
                toast.error(`Pedido enviado com sucesso! N° ${response.data.id}`); //sucesso
                setSelectedProducts([]);  // limpa a lista.
            })
            .catch(() => {
                toast.warning('Erro ao enviar pedido');
            })

    }

    return (
        <>
            <div className="orders-container">

                <StepsHeader />

                <ProductsList
                    products={products}
                    onSelectProduct={handleSelectProduct}
                    selectedProducts={selectedProducts}
                />

                <OrderLocation onChangeLocation={location => setOrderLocation(location)} />

                <OrderSummary
                    amount={selectedProducts.length}
                    totalPrice={totalPrice}
                    onSubmit={handleSubmit}
                />

            </div>

            <Footer />
        </>
    )

}
export default Order;
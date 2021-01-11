import { checkIsCelected } from "./helpers";
import ProductCard from "./ProductCard";
import { Product } from "./types";

type Props = {
    products: Product[];
    selectedProducts:Product[];
    onSelectProduct:(product: Product) => void;
}

function ProductsList( { products,selectedProducts, onSelectProduct }: Props) {
    return (
        <div className="orders-list-container">
            <div className="orders-list-items">

                {/* Interando a lista de Produtos de montando os Cards */}
               {products.map( product => (
                    <ProductCard  
                        key={product.id} 
                        product={product}
                        onSelectProduct={onSelectProduct }
                        isSelected={checkIsCelected(selectedProducts, product)  /* invoca a função para selecinar  ou deselecionar o Produro*/}
                    />
               ))}

            </div>
        </div>
    )

}
export default ProductsList;
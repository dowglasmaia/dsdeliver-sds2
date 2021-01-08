import "./styles.css"

import StepsHeader from "./StepsHeader"
import ProductsList from "./ProductsList"

//import { ReactComponent as MainImage } from './main.svg';

function Order() {
    return (
        <div className="orders-container">

            <StepsHeader />

            <ProductsList />

        </div>
    )

}
export default Order;
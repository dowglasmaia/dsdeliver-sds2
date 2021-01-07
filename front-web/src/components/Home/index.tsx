import "./styles.css"
import Footer from "../Footer";

import { ReactComponent as MainImage } from './main.svg';
import { Link } from "react-router-dom";

function Home() {
    return (
        <>
            <div className="home-container">
                <div className="home-content">
                    <div className="home-actions">
                        <h1 className="home-title">
                            Faça seu pedido <br />
                        que entregamos  <br />
                        pra você!!!
                    </h1>

                        <h4 className="home-subtitle">
                            Escolha o seu pedido e em poucos minutos <br />
                            levaremoss na sua porta
                         </h4>

                        <Link to="/orders" className="home-btn-order">
                            FAZER PEDIDO
                        </Link>

                    </div>

                    <div className="home-img" >
                        <MainImage />
                    </div>

                </div>
            </div>

            <Footer/>
            


        </>
    )

}
export default Home;
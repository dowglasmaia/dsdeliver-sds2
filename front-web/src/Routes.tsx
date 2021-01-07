import React from "react";

import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Home from "./components/Home";
import Navbar from "./components/Navbar";
import Order from "./components/Orders";

function Routes() {
  return (

    <Router>

      <Navbar />

      <Switch>
        <Route path="/" exact>
          <Home /> {/*componente */}
        </Route>
       
        <Route path="/orders" exact component={ Order }/>      


      </Switch>
    </Router>

  );
}

export default Routes;

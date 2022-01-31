import "./App.css";

import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Navbar1 from './components/Navbar1';
 import SearchBar from './components/Search';
import  Signup  from './components/Signup';
import Login  from './components/Login';
import Footer from './components/Footer';
import Footer1 from './components/Footer1.js'


function App() {
  return (
    <>
      <Router>
    <Navbar1 />
       
        <div className="pages">
          <Switch>
          <Route exact path="/" component={Login} />

          <Route exact path="/search" component={SearchBar} />
           <Route exact path="/signup" component={Signup} />
           <Route exact path="/login" component={Login} />

          </Switch>
        </div>
        <Footer1 />
      </Router>
    
     
   </>
  );
}

export default App;
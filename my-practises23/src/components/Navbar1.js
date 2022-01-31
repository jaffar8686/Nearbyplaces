import React, { useState } from "react";

import { Link } from "react-router-dom";
import {Navbar,Nav,Container} from "react-bootstrap"
import './Navbar1.css'
const Navbar1 = () => {
    const [showMediaIcons, setShowMediaIcons] = useState(false);
    return (
        <Navbar bg="dark" variant="dark" style={{height:'80px'}}>
        <Container>
        <Navbar.Brand> <img
        alt=""
        src="near1.png"
        width="30"
        height="30"
        className="d-inline-block align-top"
      /></Navbar.Brand>
        <Navbar.Brand href="/search">
    
        <h4>Search</h4></Navbar.Brand>
        <Nav className="me-auto">
         
          <Nav.Link href="/signup" style={{marginLeft:'150px'}}><h5>SignUp</h5></Nav.Link>
          <Nav.Link href="/login" style={{marginLeft:'50px'}}><h5>LogIn</h5></Nav.Link>
        </Nav>
        </Container>
      </Navbar>
    );
  };
  
  export default Navbar1;
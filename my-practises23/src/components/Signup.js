import React from 'react';
  import '../styles/Signup.css';
  //import '../styles/Login.css';
 import {withRouter}from "react-router-dom";
 import axios from 'axios';

class Signup extends React.Component {
  handleClick=()=> {
    this.props.history.push("/login");
  }
    constructor() {
    super();
    this.state = {
      input: {},
      errors: {}
    };
     
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }
     
  handleChange(event) {
    let input = this.state.input;
    input[event.target.name] = event.target.value;
  
    this.setState({
      input
    });
  }
     
  handleSubmit(event) {
    event.preventDefault();
  
    if(this.validate()){
        console.log(this.state);
  
        let input = {};
        input["name"] = "";
        input["email"] = "";
        input["password"] = "";
        input["confirm_password"] = "";
       
        this.setState({input:input});
        console.log(this.state.input);
        axios.post('http://localhost:8080/places/addUsers', this.state.input)
        .then(res=>{
            console.log(res);
            console.log(res.data);
            //console.log(res.data.userId)
            //sessionStorage.setItem('userID', res.data.userId);
            window.location="/login";
          })
       // this.props.history.push("/login");
        localStorage.setItem('user','username');
   
     }
    }
  
  
  validate(){
      let input = this.state.input;
      let errors = {};
      let isValid = true;
  
      if (!input["name"]) {
        isValid = false;
        errors["name"] = "Please enter your name.";
      }
  
      if (!input["emailId"]) {
        isValid = false;
        errors["emailId"] = "Please enter your email Address.";
      }
  
      if (typeof input["emailId"] !== "undefined") {
          
        var pattern = new RegExp(/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);
        if (!pattern.test(input["emailId"])) {
          isValid = false;
          errors["emailId"] = "Please enter valid email address.";
        }
      }
  
      if (!input["password"]) {
        isValid = false;
        errors["password"] = "Please enter your password.";
      }
  
      if (!input["confirm_password"]) {
        isValid = false;
        errors["confirm_password"] = "Please enter your confirm password.";
      }
  
      if (typeof input["password"] !== "undefined" && typeof input["confirm_password"] !== "undefined") {
          
        if (input["password"] != input["confirm_password"]) {
          isValid = false;
          errors["password"] = "Passwords don't match.";
        }
      } 
  
      this.setState({
        errors: errors
      });
  
      return isValid;
  }
     
  render() {
    return (

        <>
     
        <div className="content">
        <center>
        <div style ={{width:'350px'}} class="crd2">
         <br/>
        <center><h1 style={{fontSize:'25px',marginTop:'auto'}}>SIGN UP</h1></center>
       <br/>
        <form onSubmit={this.handleSubmit}>
        
          <div class="form-group" style={{fontSize:'20px'}}>
            <label for="name">Name</label>
            <input style={{width:'280px'}} 
              type="text" 
              name="name" 
              value={this.state.input.name}
              onChange={this.handleChange}
              class="form-control" 
              placeholder="Enter name" 
              id="name" />
  
              <div className="text-danger">{this.state.errors.name}</div>
          </div>
          <br/>
           
          <div class="form-group" style={{fontSize:'20px'}}>
            <label for="emailId">Email Address</label>
            <input style={{width:'280px'}} 
              type="text" 
              name="emailId" 
              value={this.state.input.email}
              onChange={this.handleChange}
              class="form-control" 
              placeholder="Enter email" 
              id="email" />
  
              <div className="text-danger">{this.state.errors.email}</div>
          </div>
          <br/>
          <div class="form-group" style={{fontSize:'20px'}}>
            <label for="password">Password</label>
            <input style={{width:'280px'}} 
              type="password" 
              name="password" 
              value={this.state.input.password}
              onChange={this.handleChange}
              class="form-control" 
              placeholder="Enter password" 
              id="password" />
  
              <div className="text-danger">{this.state.errors.password}</div>
          </div>
          <br/>
          <div class="form-group" style={{fontSize:'20px'}}>
            <label for="password">Confirm Password</label>
            <input style={{width:'280px'}} 
              type="password" 
              name="confirm_password" 
              value={this.state.input.confirm_password}
              onChange={this.handleChange}
              class="form-control" 
              placeholder="Enter confirm password" 
              id="confirm_password" />
  
              <div className="text-danger">{this.state.errors.confirm_password}</div>
              <br/>
              <center>
              <button type="submit" class="btn btn-primary btn">SignUp</button>&nbsp;
               
                </center>
          </div>
            <br/><br/> 
           
          
        </form>
        
      </div>
      </center>  
      </div>
      
     </>
    );
  }
}
 export default withRouter(Signup);


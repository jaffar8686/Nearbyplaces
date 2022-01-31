import React from 'react';
import '../styles/Login.css'
import axios from 'axios'
class Login extends React.Component {
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

    if (this.validate()) {
      console.log(this.state);

      let input = {};
      input["email"] = "";
      input["password"] = "";
      this.setState({ input: input });
      axios.post('http://localhost:8080/places/authenticate', this.state.input)
      .then(res=>{
          console.log(res);
          console.log(res.data);
          //console.log(res.data.userId)
          //sessionStorage.setItem('userID', res.data.userId);
         

          window.location="/search";
        })
      .catch((error)=>{
        console.log(error);
        alert("Authentication Failed");
      })
       
    }
  }

  validate() {
    let input = this.state.input;
    let errors = {};
    let isValid = true;

    if (!input["email"]) {
      isValid = false;
      errors["email"] = "Please enter your email Address.";
    }

    if (typeof input["email"] !== "undefined") {

      var pattern = new RegExp(/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);
      if (!pattern.test(input["email"])) {
        isValid = false;
        errors["email"] = "Please enter valid email address.";
      }
    }

    if (!input["password"]) {
      isValid = false;
      errors["password"] = "Please enter your password.";
    }


    this.setState({
      errors: errors
    });

    return isValid;
  }

  render() {
    return (
<center>
  <div className="contentSigns">
   <br/>
      <div style={{width:'350px'}} class="card1">
<br/>
<center><h1 style={{fontSize:'25px',marginTop:'auto'}}>LOGIN</h1></center>
        <form onSubmit={this.handleSubmit}>

        <br/>

          <div style={{fontSize:'20px'}}  class="form-group">
            <label for="email">Email Address</label>
            <input style={{width:'280px'}}
              type="text"
              name="email"
              value={this.state.input.email}
              onChange={this.handleChange}
              class="form-control"
              placeholder="Enter email"
              id="email" />

            <div className="text-danger">{this.state.errors.email}</div>
          </div>
          <br/>

          <div style={{fontSize:'20px'}}  class="form-group">
            <label for="password">Password</label>
            <input style={{width:'280px'}}
              type="password"
              name="password"
              value={this.state.input.password}
              onChange={this.handleChange}
              class="form-control"
              placeholder="Enter password"
              id="password" />
              
              

            <br />
            <center>
              <button type="submit" class="btn btn-primary btn">Login</button>&nbsp;

            </center>
          </div>

        </form>

      </div>
      <br/>
      </div>
      </center>
    );
  }
}

export default Login;
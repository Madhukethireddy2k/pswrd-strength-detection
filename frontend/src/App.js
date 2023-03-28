import logo from "./logo.svg";
import "./App.css";
import React from "react";
import { useState } from "react";
import axios from "axios";

class App extends React.Component {
  constructor() {
    super();
    this.state = {
      value: "",
      resp: ""
    };
    this.handleChange = this.handleChange.bind(this);
    
  }

  handleChange  = async (e) => {
    await this.setState({value : e.target.value});
    console.log(this.state.value);
     axios
      .post("http://localhost:8085/api/pswrdstrength", this.state.value)
      .then((response) => {
        this.setState({resp : response.data});
      })
      .catch((error) => {
        this.setState({resp : ""});
      });

  }

  
  render(){
  return (
    <div className="App">
      <br />
      <br />
      <div class="container">
        <div class="row g-3">
          <div class="col-2">
            <h4 class="form-label" style={{"padding-left":"30px"}}>Password</h4>
          </div>
          <div class="col-10">
            <input
              type="text"
              class="form-control"
              
             onChange={this.handleChange}
              placeholder="Enter password"
            />
          </div>
          
          <center>
            <h3>Strength of the given password is {this.state.resp.length ? this.state.resp : ""}</h3>
          </center>
        </div>
      </div>
    </div>
  
  );
  }
}

export default App;

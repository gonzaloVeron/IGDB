import React from 'react';
import './Login.css';
import { signIn } from '../../api/api'

import { Link } from 'react-router-dom';


class Login extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      username: '',
      password: '',
      error: '',
    };
    this.changeUsername = this.changeUsername.bind(this);
    this.changePassword = this.changePassword.bind(this); 
    this.login = this.login.bind(this)
  }

  login() {
    signIn({name: this.state.username, password: this.state.password })
      .then(result => { 
        localStorage.setItem("userName", result.name)
        localStorage.setItem("id", result.id)
        localStorage.setItem("userImage", result.userImage)
        this.props.history.goBack();
      })
      .catch(e => this.setState({ error: "Wrong user or password"}))
  }

  renderInput(value, placeholder, inputType, onChange) {
    return (
          <input type={inputType} placeholder={placeholder} value={value} onChange={onChange} />
    )
  }

  changeUsername(event) {
    this.setState({ username: event.target.value });
  }

  changePassword(event) {
    this.setState({ password: event.target.value })
  }

  render() { 
    return  (
      <div className="container-login">
        <div className="login">
          <h1>IGDB</h1>
          <div>
              <h3>{this.state.error}</h3>
          </div>
          <form method="post">
            {this.renderInput(this.state.username, "User", 'text', this.changeUsername)}
            {this.renderInput(this.state.password, "Password", 'password', this.changePassword)}
            <button type="button" className="btn btn-danger btn-block btn-large" onClick={ this.login }>Log In</button>
            <div>
              <br />
              <h2>You do not have an account? <Link to={'/register'}>Create one</Link></h2>
            </div>
          </form>
        </div>
      </div>
    ) 
       
  }
}

export default Login;
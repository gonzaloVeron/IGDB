import React from 'react';
import '../login/Login.css';
import { Link } from 'react-router-dom';
import { register } from '../../api/api.js'

export default class Register extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      name: '',
      password: '',
      error: '',
    };
    this.changeUsername = this.changeUsername.bind(this);
    this.changePassword = this.changePassword.bind(this); 
    this.register = this.register.bind(this);

  }

  register() {
    register({ name: this.state.name, password: this.state.password })
      .then(result => {
        localStorage.setItem("userName", result.name)
        localStorage.setItem("password", result.password)
        this.props.history.goBack() 
      })
      .catch(e => this.setState({ error: "Usuario y/o contraseña incorrectos" }))
  }

  renderInput(value, placeholder, inputType, onChange) {
    return (
          <input type={inputType} placeholder={placeholder} value={value} onChange={onChange} />
    )
  }

  changeUsername(event) {
    this.setState({ name: event.target.value });
  }

  changePassword(event) {
    this.setState({ password: event.target.value });
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
            {this.renderInput(this.state.username, "Usuario", 'text', this.changeUsername)}
            {this.renderInput(this.state.password, "Contraseña", 'password', this.changePassword)}
            <button type="button" className="btn btn-danger btn-block btn-large" onClick={ this.register }>Registrarse</button>
            <div>
              <br />  
              <h2>Ya tienes cuenta? <Link to={'/login'}>Iniciar sesion</Link></h2>
            </div>
          </form>
        </div>
      </div>
    )    
  }

}
import React from 'react';
import { Link, withRouter } from 'react-router-dom';
import './NavBar.css';
import {Dropdown, Image, Col, Container, Button} from 'react-bootstrap'
import defaultprofileicon from "./defaultprofileicon.jpg"


class NavBar extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            search: '',
            genre: "Any",
            platform: "Any",
            error: '',
        };
        this.changeSearch = this.changeSearch.bind(this);
        this.doSearch = this.doSearch.bind(this);
        this.goHome = this.goHome.bind(this);
        this.logOut = this.logOut.bind(this);
        this.changeGenre = this.changeGenre.bind(this);
        this.changePlatform = this.changePlatform.bind(this);
    }

    changeSearch(event) {
        this.setState({ search: event.target.value }, () => console.log(this.state.search))
    }

    doSearch() {
        this.props.history.push(`/search/${this.state.search}/${this.state.platform}/${this.state.genre}`)
    }

    goHome() {
        this.props.history.push('/home')
    }

    logOut() {
        this.props.history.push('/')
    }

    changeGenre(event){
        this.setState({ genre: event.target.value }, () => console.log(this.state.genre))
    }

    changePlatform(event){
        this.setState({ platform: event.target.value }, () => console.log(this.state.platform))
    }

    render() {
        return (
            <nav className="navbar navbar-light">
                <Link to={"/home"} className="navbar-brand">IGDB</Link>

                <form>
                    <div className="form-row">
                        <div className="col-9">
                            <input type="search" className="form-control" placeholder="What game do you want ?" onChange={this.changeSearch}/>
                            <div className='row'>
                              <select className="col btn btn-danger dropdown-toggle" value={this.state.genre} onChange={this.changeGenre}>
                                  <option value={"Any"}>Genre</option>
                                  <option value={"Adventure"}>Adventure</option>
                                  <option value={"Shooter"}>Shooter</option>
                                  <option value={"Strategy"}>Strategy</option>
                                  <option value={"SurvivalHorror"}>Survival Horror</option>
                                  <option value={"Rol"}>Rol</option>
                                  <option value={"PartyGames"}>PartyGames</option>
                                  <option value={"Simulation"}>Simulation</option>
                                  <option value={"Sports"}>Sports</option>
                                  <option value={"Race"}>Race</option>
                                  <option value={"Music"}>Music</option>
                                  <option value={"Fighting"}>Fighting</option>
                              </select>
                              <select className="col btn btn-danger dropdown-toggle" value={this.state.platform} onChange={this.changePlatform}>
                                  <option value={"Any"}>Platform</option>
                                  <option value={"PS4"}>PS4</option>
                                  <option value={"XBOXONE"}>XBOXONE</option>
                                  <option value={"PC"}>PC</option>
                                  <option value={"SWITCH"}>SWITCH</option>
                                  <option value={"WII"}>WII</option>
                                  <option value={"PSVITA"}>PSVITA</option>
                                  <option value={"PS2"}>PS2</option>
                                  <option value={"PS3"}>PS3</option>
                                  <option value={"XBOX360"}>XBOX360</option>
                                  <option value={"WIIU"}>WIIU</option>
                                  <option value={"PS1"}>PS1</option>
                              </select>
                            </div>
                        </div>
                        <div className="col">
                            <button onClick={this.doSearch} className="btn searchButton" type="submit">&#x1F50D;</button>
                            
                        </div>
                        
                    </div>
                </form>

                <div>
                    {/*this.renderProfileDropdown()*/}
                    {/*
                    <button active onClick={this.goHome} className="buttonNavBar" >Mis ordenes</button>
                    <button active onClick={this.logOut} className="buttonNavBar" >Cerrar sesion</button>
                    */}
                </div>
            </nav>
        )
    }
 
    renderProfileDropdown(){
        return (
          <Dropdown>
            <Dropdown.Toggle as={CustomToggle} id="dropdown-custom-components">
              { this.renderProfileIcon() }
            </Dropdown.Toggle>
    
            <Dropdown.Menu id="basic-nav-dropdown" alignRight >
              <div className="text-center">
                <Image style={{ width: '150px' }} src={defaultprofileicon} roundedCircle />
                <h5>{ /*${this.props.userId}*/ }</h5>
              </div>
              <div className="text-center">
                <Button variant="primary" onClick={this.handleLogout}>Logout</Button>
              </div>
            </Dropdown.Menu>
          </Dropdown>
        )
      }
    
      renderProfileIcon(){
        return (
          <div>
            <Container>
              <Col xs={6} md={4}>
                <Image style={{ width: '40px' }} src={defaultprofileicon} roundedCircle />
              </Col>
            </Container>
          </div>
        )
      }

}

// <---Custom toggle for profile--->
class CustomToggle extends React.Component {
    constructor(props, context) {
      super(props, context);
  
      this.handleClick = this.handleClick.bind(this);
    }
  
    handleClick(e) {
      e.preventDefault();
  
      this.props.onClick(e);
    }
  
    render() {
      return (
        <Link to="" onClick={this.handleClick}>
          {this.props.children}
        </Link>
      );
    }
  }

export default withRouter(NavBar);

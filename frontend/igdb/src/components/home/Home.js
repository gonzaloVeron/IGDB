import React from 'react';
import { getUser, changeImage } from '../../api/api'
import './home.css';
import NavBar from '../navbar/NavBar'
import ReviewCard from '../card/ReviewCard';
import { tsImportEqualsDeclaration } from '@babel/types';
const thumbnail = require('../../images/thumbnail.png');


export default class Home extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            userData:{
                id: -999,
                name:'',
                photo:'',
                myReviews:[],
            },
            error: '',
            genre:"Any",
            platform:"Any",
            search:"Any",
            imageModal:'',
            showModal:"false",
        };
        this.renderUserImage = this.renderUserImage.bind(this)
        this.renderUserReviews = this.renderUserReviews.bind(this)
        this.renderHomeWithoutUser = this.renderHomeWithoutUser.bind(this)
        this.renderNav = this.renderNav.bind(this)
        this.renderHome = this.renderHome.bind(this)
        this.goToRegister = this.goToRegister.bind(this)
        this.goToLogin = this.goToLogin.bind(this)
        this.modal = this.modal.bind(this)
        this.changeGenre = this.changeGenre.bind(this)
        this.changeSearch = this.changeSearch.bind(this)
        this.changePlatform = this.changePlatform.bind(this)
        this.changePath = this.changePath.bind(this)
        this.closeButtonModal = this.closeButtonModal.bind(this)
        this.changeUserImage = this.changeUserImage.bind(this)
        this.openModal = this.openModal.bind(this)
        this.doSearch = this.doSearch.bind(this)
    }

    componentDidMount() {
        let id = localStorage.getItem("id")
        getUser(id).then(result => {
            this.setState({ userData : result });
            console.log(result)
        }).catch(e => {this.setState({ error: e.message })})
    }

    renderNav(){
        return(
            <div style={{paddingLeft:"33%"}}>
                <form>
                    <div className="form-row">
                        <div className="col-6">
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
            </div>
        )
    }

    changeGenre(event){
        this.setState({ genre: event.target.value }, () => console.log(this.state.genre))
    }

    changePlatform(event){
        this.setState({ platform: event.target.value }, () => console.log(this.state.platform))
    }

    changeSearch(event) {
        this.setState({ search: event.target.value }, () => console.log(this.state.search))
    }

    doSearch() {
        if(this.state.search == ""){
            this.props.history.push(`/search/"Any"/${this.state.platform}/${this.state.genre}`)
        }else{
            this.props.history.push(`/search/${this.state.search}/${this.state.platform}/${this.state.genre}`)
        }
    }

    renderHomeWithoutUser(){
        return(
            <div>
                <div className="container">
                    <h1 style={{color: 'white', textAlign: 'center'}}>IGDB</h1>
                    {this.renderNav()}
                </div>
                <div className="row" style={{paddingTop:"17%"}}>
                    <div style={{paddingLeft:"30%"}}>
                        <button type="button" className="btn btn-danger" type="submit" onClick={this.goToRegister}>Register</button> 
                    </div>
                    <div style={{paddingLeft:"36%"}}>
                        <button type="button" className="btn btn-danger" type="submit" onClick={this.goToLogin}>Login</button>
                    </div> 
                </div>
            </div>

        )
    }

    goToRegister(){
        this.props.history.push('/register')
    }
  
    goToLogin(){
        this.props.history.push('/login')
    }

    renderHomeWithUser(){
        return(
            <div>
                <NavBar/>
                <div className="container">
                    <div className="card file-content">
                        <div className="row">
                            {this.renderUserImage()}
                            <div className="col">
                                <h1 style={{color:"white"}}>Username: {this.state.userData.name}</h1>
                                <h1 style={{color:"white"}}>Register date:</h1>
                                <h1 style={{color:"white"}}>....</h1>
                            </div>
                        </div>
                    </div>
                    <div className="card file-content">
                        <h1 style={{paddingLeft:"40%", color:"white"}}>Reviews made</h1>
                        {this.renderUserReviews()}
                    </div>
                </div>
            </div>
        )
    }

    renderUserImage(){
        let thumb = this.state.userData.photo || thumbnail
        return(
            <div style={{marginRight:"2%", marginLeft:"2%", marginTop:"1%"}}>
                <img className="image" src={thumb} alt='' data-toggle="modal" data-target="#exampleModalCenter" onClick={this.openModal} height="200" width="150"/>
            </div>
        )
    }

    openModal(){
        this.setState({showModal:"true"})
    }


    renderUserReviews(){
        return(
            <div style={{paddingLeft:"50%"}}>
                {this.state.userData.myReviews.map((re, i) => {return <ReviewCard key={i} review={re}/>})}
            </div>
        )
    }

    renderHome(){
        if(localStorage.getItem("userName") == null){
            return(this.renderHomeWithoutUser())
        }else{
            return(this.renderHomeWithUser())
        }
    }

    modal(){
        return(
            <div show={this.state.showModal} className="modal fade" id="exampleModalCenter" tabIndex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div className="modal-dialog modal-dialog-centered" role="document">
                    <div className="modal-content">
                        <div className="modal-header">
                            <h5 className="modal-title" id="exampleModalCenterTitle">Change Image</h5>
                            <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div className="modal-body">
                            Insert path:
                            <input type="search" className="form-control" placeholder="Path image" onChange={this.changePath}/>
                        </div>
                        <div className="modal-footer">
                            <button type="button" className="btn btn-secondary" data-dismiss="modal" onClick={this.closeButtonModal}>Close</button>
                            <button type="button" className="btn btn-primary" data-dismiss="modal" onClick={this.changeUserImage}>Save changes</button>
                        </div>
                    </div>
                </div>
            </div>
        )
    }

    changeUserImage(){
        this.setState({showModal:"false"})
        changeImage(this.state.userData.id, {photo:this.state.imageModal})
        .then(result => {
            this.setState({userData: {id:this.state.userData.id, name:this.state.userData.name, photo:this.state.imageModal, myReviews:this.state.userData.myReviews}})
            this.setState({imageModal:''})
          })
          .catch(e => this.setState({ error: "Pasaron cosas" }))
    }

    closeButtonModal(){
        this.setState({imageModal:''})
        this.setState({showModal:"false"})
    }

    changePath(event){
        this.setState({ imageModal: event.target.value }, () => console.log(this.state.imageModal))
    }

    render(){
        return (
            <div>
                {this.renderHome()}
                {this.modal()}
            </div>
        )
    }
}

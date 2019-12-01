import React from 'react';
import './home.css';
import NavBar from '../navbar/NavBar'
import ReviewCard from '../card/ReviewCard';
const thumbnail = require('../../images/thumbnail.png');

export default class Home extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            userData:{
                userName:'',
                urlImage:'',
                reviews:[],
            },
            error: '',
        };
        this.cambiarImagen = this.cambiarImagen.bind(this)
        this.renderUserImage = this.renderUserImage.bind(this)
        this.renderUserReviews = this.renderUserReviews.bind(this)
        this.renderHomeWithoutUser = this.renderHomeWithoutUser.bind(this)
        this.renderNav = this.renderNav.bind(this)
        this.renderHome = this.renderHome.bind(this)
    }

    componentDidMount() {
        
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

    renderHomeWithoutUser(){
        return(
            <div>
                <div className="container">
                    <h1 style={{color: 'white', textAlign: 'center'}}>IGDB</h1>
                    {this.renderNav()}
                </div>
                <div className="row" style={{paddingTop:"17%"}}>
                    <div style={{paddingLeft:"30%"}}>
                        <button type="button" className="btn btn-danger" type="submit">Register</button> 
                    </div>
                    <div style={{paddingLeft:"32%"}}>
                        <button type="button" className="btn btn-danger" type="submit">Login</button>
                    </div> 
                </div>
            </div>

        )
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
                                <h1 style={{color:"white"}}>Username: {this.state.userData.userName}</h1>
                                <h1 style={{color:"white"}}>Register date: {this.state.userData.userName}</h1>
                                <h1 style={{color:"white"}}>Username: {this.state.userData.userName}</h1>
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

    cambiarImagen(){
        console.log("Me tocaste")
    }

    renderUserImage(){
        let thumb = this.state.userData.imageUrl || thumbnail
        return(
            <div style={{marginRight:"2%", marginLeft:"2%", marginTop:"1%"}}>
                <img className="image" src={thumbnail} alt='' onClick={this.cambiarImagen} height="200" width="150"/>
            </div>
        )
    }

    renderUserReviews(){
        return(
            this.state.userData.reviews.map((re, i) => {return <ReviewCard key={i} review={re}/>})
        )
    }

    renderHome(){
        if(localStorage.getItem("userName") == null){
            return(this.renderHomeWithoutUser())
        }else{
            return(this.renderHomeWithUser())
        }
    }

    render(){
        return (
            <div>
                {this.renderHome()}
            </div>
        )
    }
}

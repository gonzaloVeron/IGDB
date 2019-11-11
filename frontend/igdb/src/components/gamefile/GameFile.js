import React from 'react';
import NavBar from '../navbar/NavBar';
import { getGame } from '../../api/api.js';
import './GameFile.css';
const thumbnail = require('../../images/thumbnail.png');

export default class GameFile extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            gameData: {
                id: -999,
                name: '',
                genre: '',
                platform: '',
                sinopsis: '',
                urlImage: '',
            }
        }
        console.log(props)
    }

    
    componentDidMount(){
        let { id } = this.props.match.params
        getGame(id).then(result => {
            this.setState({ gameData : result });
            console.log(result)
        }).catch(e => {this.setState({ error: e.message })})
    }  

    fileTitle(){
        let thumb = this.state.gameData.urlImage || thumbnail
        return (
            <div className="card title-container">
                <div className="card-header header row">
                            <div className="column-image">
                                <img src={thumb} alt='' height="200" width="150"/>
                            </div>
                            <div className="column">
                                <h1 className="card-header title">{this.state.gameData.name}</h1>
                            </div>
                    </div>
            </div>
        );
    }

    fileContent(){
        return (
            <div className="card file-content">
                <div className="file-content-element">
                    Sinopsis: {this.state.gameData.sinopsis}
                </div>
                <div className="file-content-element">
                    Género: {this.state.gameData.genre}
                </div>
                <div className="file-content-element">
                    Plataforma: {this.state.gameData.platform}
                </div>
            </div>
        );
    }

    render(){
        return(
            <div className="GameFile body-container">
                <NavBar/>
                <div className="container">
                    {this.fileTitle()}
                    {this.fileContent()} 
                </div>
            </div>
        )
    }
}
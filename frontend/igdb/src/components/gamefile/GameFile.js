import React from 'react';
import NavBar from '../navbar/NavBar';
import { getGame } from '../../api/api.js';
import {CollapsibleComponent, CollapsibleHead, CollapsibleContent} from 'react-collapsible-component'
import './GameFile.css';
import DevCard2 from '../card/DevCard2';
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
                videos: [],
                images: [],
                devsParticiped: [{id:2, name:"Hideo", lastName:"Kojima", image:"Ninguna"}],
                studio: {
                    id: 7,
                    name:"Capcom",
                    image:"Ninguna",
                },
            }
        }
        console.log(props)
        console.log(this.state)
    }

    
    componentDidMount(){/*
        let { id } = this.props.match.params
        getGame(id).then(result => {
            this.setState({ gameData : result });
            console.log(result)
        }).catch(e => {this.setState({ error: e.message })})
        */
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

    videos(){
        return (
            <div className="file-content-element" style={{marginRight: "2%"}}>
                <CollapsibleHead className="collapsible-head">Videos ({this.state.gameData.videos.length}) </CollapsibleHead>
                <CollapsibleContent className="collapsible-content">
                    <div className="row">
                        <div className="col-sm-6">
                            {this.renderVideoColumn(this.state.gameData.videos.slice(0, (this.state.gameData.videos.length / 2)))}
                        </div>
                        <div className="col-sm-6">
                            {this.renderVideoColumn(this.state.gameData.videos.slice((this.state.gameData.videos.length / 2), this.state.gameData.videos.length))}
                        </div>
                    </div>
                </CollapsibleContent>
            </div>
        )
    }

    renderVideoColumn(videos){
        return videos.map((link, i) => {return(<div key={i}><iframe title={"video" + i} width="420" height="315" src={link} allowFullScreen style={{margin:"1% 1% 1% 1%"}} /></div>)})
    }

    images(){
        return (
            <div style={{marginRight:"2%", marginLeft:"2%", marginTop:"1%"}}>
            <CollapsibleComponent className="file-content-element" >
                <CollapsibleHead className="collapsible-head">Images ({this.state.gameData.images.length}) </CollapsibleHead>
                <CollapsibleContent className="collapsible-content">
                    <div className="row">
                        <div className="col-sm-4">
                            {this.renderImageColumn(this.state.gameData.images.slice(0, (this.state.gameData.images.length / 3)))}
                        </div>
                        <div className="col-sm-4">
                            {this.renderImageColumn(this.state.gameData.images.slice((this.state.gameData.images.length / 3), (this.state.gameData.images.length / 3)*2))}
                        </div>
                        <div className="col-sm-4">
                            {this.renderImageColumn(this.state.gameData.images.slice((this.state.gameData.images.length / 3) * 2, this.state.gameData.images.length))}
                        </div>
                    </div>
                </CollapsibleContent>
            </CollapsibleComponent>
            </div>
        )
    }

    renderImageColumn(images){
        return images.map((link, i) => {return(<img key={i} alt="" width="300" height="220" src={link} style={{margin:"1% 1% 1% 1%"}} />)})
    }

    renderDevsColumn(devs){
        return devs.map((de, i) => {return <DevCard2 key={i} dev={de}/>} )
    }

    renderStudioImageColumn(imageURL){
        return (
            <img alt="" width="300" height="220" src={imageURL} style={{margin:"1% 1% 1% 1%"}} />
        )
    }

    creators(){
        return(
            <div style={{marginRight:"2%", marginLeft:"2%", marginTop:"1%"}}>
                <CollapsibleComponent className="file-content-element" >
                    <CollapsibleHead className="collapsible-head">Creators {}</CollapsibleHead>
                    <CollapsibleContent className="collapsible-content">
                        <div className="row">
                            <div className="col-sm-4">
                                {this.renderStudioImageColumn(this.state.gameData.studio.image)}
                            </div>
                            <div className="col-sm-4">
                                {this.renderDevsColumn(this.state.gameData.devsParticiped)}
                            </div>  
                        </div>
                    </CollapsibleContent>
                </CollapsibleComponent>
            </div>
        )
    }

    render(){
        return(
            <div className="GameFile body-container">
                <NavBar/>
                <div className="container">
                    {this.fileTitle()}
                    {this.fileContent()}
                    {this.videos()}
                    {this.images()}
                    {this.creators()}
                </div>
            </div>
        )
    }
}
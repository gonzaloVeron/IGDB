import React from 'react';
import NavBar from '../navbar/NavBar';
import { getDev } from '../../api/api.js'
import GameCard2 from '../card/GameCard2';
import {CollapsibleComponent, CollapsibleHead, CollapsibleContent} from 'react-collapsible-component'
import StudioCard2 from '../card/StudioCard2';
const thumbnail = require('../../images/thumbnail.png');

export default class DevFile extends React.Component{

    constructor(props){
        super(props)
        this.state = {
            devData: {
                id: -999,
                name: '',
                lastName: '',
                imageUrl: '',
                dateOfBirth: '',
                isWorking: '', //esto deberia decir "actualmente trabajando en: sarasa" o "desempleado"
                currentStudios: [],
                historicalStudios: [],
                gamesParticipated: [],
            } 
        }
        console.log(props)
    }

    componentDidMount(){
        let { id } = this.props.match.params
        getDev(id).then(result => {
            this.setState({ devData : result });
            console.log(result)
        }).catch(e => {this.setState({ error: e.message })})
    } 
    
    fileTitle(){
        let thumb
        if (this.state.devData.imageUrl === "Ninguna"){
            thumb = thumbnail
        } else {
            thumb = this.state.devData.imageUrl
        }
        return (
            <div className="card title-container">
                <div className="card-header header row">
                    <div className="column-image">
                        <img src={thumb} alt='' height="200" width="150"/>
                    </div>
                    <div className="column">
                        <h1 className="card-header title">{this.state.devData.name + " " + this.state.devData.lastName}</h1>
                    </div>
                </div>
            </div>
        )
    }

    fileContent(){
        return (
            <div className="card file-content">
                <div className="file-content-element">
                    Date of birth: {this.state.devData.dateOfBirth}
                </div>
                <div className="file-content-element">
                    Currently exercising: {this.state.devData.isWorking}
                </div>
            </div>
        )
    }

    gamesWorkedOn(){
        return(
            <CollapsibleComponent className="file-content-element">
                <CollapsibleHead className="collapsible-head">Games in which he participated: </CollapsibleHead>
                <CollapsibleContent className="collapsible-content">
                    <div className="row">
                        <div className="col-sm-6"> {/* gamesParticipated.slice las uso para dividir a la mitad la lista de juegos y que quede parejo */}
                            {this.state.devData.gamesParticipated.slice(0, (this.state.devData.gamesParticipated.length / 2)).map((ga, i) => {return(<GameCard2 key={i} game={ga} history={this.props.history}/>)})}
                        </div>
                        <div className="col-sm-6">
                            {this.state.devData.gamesParticipated.slice((this.state.devData.gamesParticipated.length / 2), this.state.devData.gamesParticipated.length).map((ga, i) => {return(<GameCard2 key={i} game={ga} history={this.props.history}/>)})}
                        </div>
                    </div>
                </CollapsibleContent>
            </CollapsibleComponent>
        )
    }

    currentStudios(){
        return (
            <CollapsibleComponent className="file-content-element">
                <CollapsibleHead className="collapsible-head">Current studios: </CollapsibleHead>
                <CollapsibleContent className="collapsible-content">
                    <div className="row">
                        <div className="col-sm-6">
                            {this.state.devData.currentStudios.slice(0, (this.state.devData.currentStudios.length / 2)).map((st, i) => {return(<StudioCard2 key={i} studio={st} history={this.props.history}/>)})}
                        </div>
                        <div className="col-sm-6">
                            {this.state.devData.currentStudios.slice((this.state.devData.currentStudios.length / 2), this.state.devData.currentStudios.length).map((st, i) => {return(<StudioCard2 key={i} studio={st} history={this.props.history}/>)})}
                        </div>
                    </div>
                </CollapsibleContent>
            </CollapsibleComponent>
        )
    }

    historicalStudios(){
        return (
            <CollapsibleComponent className="file-content-element">
                <CollapsibleHead className="collapsible-head">Historical studios: </CollapsibleHead>
                <CollapsibleContent className="collapsible-content">
                    <div className="row">
                        <div className="col-sm-6">
                            {this.state.devData.historicalStudios.slice(0, (this.state.devData.historicalStudios.length / 2)).map((st, i) => {return(<StudioCard2 key={i} studio={st} history={this.props.history}/>)})}
                        </div>
                        <div className="col-sm-6">
                            {this.state.devData.historicalStudios.slice((this.state.devData.historicalStudios.length / 2), this.state.devData.historicalStudios.length).map((st, i) => {return(<StudioCard2 key={i} studio={st} history={this.props.history}/>)})}
                        </div>
                    </div>
                </CollapsibleContent>
            </CollapsibleComponent>

        )
    }

    render(){
        return(
            <div className="DevFile body-container">
                <NavBar/>
                <div className="container">
                    {this.fileTitle()}
                    {this.fileContent()}
                    {this.gamesWorkedOn()}
                    {this.currentStudios()}
                    {this.historicalStudios()}
                </div>
            </div>
        )
    }

}
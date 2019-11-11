import React from 'react';
import NavBar from '../navbar/NavBar';
import { getDevStudio } from '../../api/api.js'
import {CollapsibleComponent, CollapsibleHead, CollapsibleContent} from 'react-collapsible-component'
import GameCard2 from '../card/GameCard2';
import DevCard2 from '../card/DevCard2';
const thumbnail = require('../../images/thumbnail.png');

export default class DevStudio extends React.Component{

    constructor(props){
        super(props)
        this.state = {
            studioData: {
                id: -999,
                name: "",
                imageUrl: '',
                foundationDate: '',
                isActive: '', //esto deberia decir "actualmente activo" o "inactivo" <---- poneeele
                actualDevs: [],
                historicalDevelopers: [],
                gamesDeveloped: [],
            } 
        }
        console.log(props)
        console.log(this.state)
    }

    componentDidMount(){
        let { id } = this.props.match.params
        getDevStudio(id).then(result => {
            console.log(result)
            this.setState({ studioData : result });
        }).catch(e => {this.setState({ error: e.message })})
    } 

    fileTitle(){
        let thumb = this.state.studioData.imageUrl || thumbnail
        return (
            <div className="card title-container">
                <div className="card-header header row">
                    <div className="column-image">
                        <img src={thumb} alt='' height="200" width="150"/>
                    </div>
                    <div className="column">
                        <h2 className="card-header title">{this.state.studioData.name}</h2>
                    </div>
                </div>
            </div>
        )
    }

    fileContent(){
        return (
            <div className="card file-content">
                <div className="file-content-element">
                    Foundation date: {this.state.studioData.foundationDate}
                </div>
                <div className="file-content-element">
                    Is active: {this.state.studioData.isActive}
                </div>
                <div className="file-content-element">
                </div>
                <div className="file-content-element">
                </div>
            </div>
        )
    }

    
    gamesDeveloped(){
        return(
            <CollapsibleComponent className="file-content-element">
                <CollapsibleHead className="collapsible-head">Games developed: </CollapsibleHead>
                <CollapsibleContent className="collapsible-content">
                    <div className="row">
                        <div className="col-sm-6"> 
                            {this.state.studioData.gamesDeveloped.slice(0, (this.state.studioData.gamesDeveloped.length / 2)).map((ga, i) => {return(<GameCard2 key={i} game={ga} history={this.props.history}/>)})}
                        </div>
                        <div className="col-sm-6">
                            {this.state.studioData.gamesDeveloped.slice((this.state.studioData.gamesDeveloped.length / 2), this.state.studioData.gamesDeveloped.length).map((ga, i) => {return(<GameCard2 key={i} game={ga} history={this.props.history}/>)})}
                        </div>
                    </div>
                </CollapsibleContent>
            </CollapsibleComponent>
        )
    }

    currentDevelopers(){
        return (
            <CollapsibleComponent className="file-content-element">
                <CollapsibleHead className="collapsible-head">Current developers: </CollapsibleHead>
                <CollapsibleContent className="collapsible-content">
                    <div className="row">
                        <div className="col-sm-6">
                            {this.state.studioData.actualDevs.slice(0, (this.state.studioData.actualDevs.length / 2)).map((dv, i) => {return(<DevCard2 key={i} dev={dv} history={this.props.history}/>)})}
                        </div>
                        <div className="col-sm-6">
                            {this.state.studioData.actualDevs.slice((this.state.studioData.actualDevs.length / 2), this.state.studioData.actualDevs.length).map((dv, i) => {return(<DevCard2 key={i} dev={dv} history={this.props.history}/>)})}
                        </div>
                    </div>
                </CollapsibleContent>
            </CollapsibleComponent>
        )
    }

    historicalDevelopers(){
        return (
            <CollapsibleComponent className="file-content-element">
                <CollapsibleHead className="collapsible-head">Historical developers: </CollapsibleHead>
                <CollapsibleContent className="collapsible-content">
                    <div className="row">
                        <div className="col-sm-6">
                            {this.state.studioData.historicalDevelopers.slice(0, (this.state.studioData.historicalDevelopers.length / 2)).map((dv, i) => {return(<DevCard2 key={i} dev={dv} history={this.props.history}/>)})}
                        </div>
                        <div className="col-sm-6">
                            {this.state.studioData.historicalDevelopers.slice((this.state.studioData.historicalDevelopers.length / 2), this.state.studioData.historicalDevelopers.length).map((dv, i) => {return(<DevCard2 key={i} dev={dv} history={this.props.history}/>)})}
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
                    {this.gamesDeveloped()}
                    {this.currentDevelopers()}
                    {this.historicalDevelopers()}
                </div>
            </div>
        )
    } 
}
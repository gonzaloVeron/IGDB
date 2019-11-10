import React from 'react';
import NavBar from '../navbar/NavBar';
import { getDev } from '../../api/api.js'

export default class DevFile extends React.Component{

    constructor(props){
        super(props)
        this.state = {
            devData: {
                name: '',
                lastName: '',
                imageUrl: '',
                dateOfBirth: '',
                isWorking: '', //esto deberia decir "actualmente trabajando en: sarasa" o "desempleado"
                devStudiesWorked: [],
                gamesParticipated: [],
            } 
        }
        console.log(props)
    }

    componentDidMount(){
        let { devID } = this.props.match.params
        getDev(devID).then(result => {
            this.setState({ devData : result });
            console.log(result)
        }).catch(e => {this.setState({ error: e.message })})
    } 
    
    fileTitle(){
        return (
            <div className="card title-container">
                <h1 className="card-header title">{this.state.devData.name}</h1>
            </div>
        )
    }

    fileContent(){
        return (
            <div className="card file-content">
                <div className="file-content-element">
                    Fecha de nacimiento: {this.state.devData.dateOfBirth}
                </div>
                <div className="file-content-element">
                    Actualmente activo: {this.state.devData.isWorking}
                </div>
                <div className="file-content-element">
                    Juegos en los que participo: {this.state.devData.devStudiesWorked}
                </div>
            </div>
        )
    }

    imagesAndVideosBox(){
        return(
            <div>
                
            </div>
        )
    }

    render(){
        return(
            <div className="DevFile">
                <NavBar/>
                <div className="container">
                    {this.fileTitle()}
                    {this.fileContent()}
                    {this.imagesAndVideosBox()}
                </div>
            </div>
        )
    }

}
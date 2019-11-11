import React from 'react';
import NavBar from '../navbar/NavBar';
import { getDevStudio } from '../../api/api.js'

export default class DevStudio extends React.Component{

    constructor(props){
        super(props)
        this.state = {
            studioData: {
                id: -999,
                name: "Crazy Bullet",
                imageUrl: '',
                foundationDate: '',
                isActive: '', //esto deberia decir "actualmente activo" o "inactivo" <---- poneeele
                actualDevs: [],
                historicalDevelopers: ["Hideo Kojima", "Gonzalo Veron", "Ola ki aze?"],
                gamesDeveloped: [],
            } 
        }
        console.log(props)
        console.log(this.state)
    }

    componentDidMount(){
        let { devStudioID } = this.props.match.params
        getDevStudio(devStudioID).then(result => {
            this.setState({ studioData : result });
            console.log(result)
        }).catch(e => {this.setState({ error: e.message })})
    } 

    fileTitle(){
        return (
            <div className="card title-container">
                <h1 className="card-header title">{this.state.studioData.name}</h1>
            </div>
        )
    }

    historicalDevs(){
        return(
            <div>
                {
                    this.state.studioData.historicalDevelopers.map((hdev, i) => {
                        return(
                            <div>
                                nombreDev: {hdev} 
                            </div>
                        )
                    })
                }
            </div>
        )
    }

    fileContent(){
        return (
            <div className="card file-content">
                <div className="file-content-element">
                    Fecha de fundacion: {this.state.studioData.foundationDate}
                </div>
                <div className="file-content-element">
                    Actualmente activo: {this.state.studioData.isActive}
                </div>
                <div className="file-content-element">
                    Desarrolladores actuales: {this.state.studioData.actualDevs}
                </div>
                <div className="file-content-element">
                    Desarrolladores historicos: {this.state.studioData.actualDevs}
                </div>
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
                </div>
            </div>
        )
    } 
}
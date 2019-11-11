import React from 'react';
import NavBar from '../navbar/NavBar';
import { getDev } from '../../api/api.js'
import GameCard2 from '../card/GameCard2';

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
                devStudiesWorked: [],
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
        return (
            <div className="card title-container">
                <h1 className="card-header title">{this.state.devData.name + " " + this.state.devData.lastName}</h1>
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
                <div className="file-content-element">
                    Games in which he participated: 
                    <div className="row">
                        <div className="col-sm-6"> {/* gamesParticipated.slice las uso para dividir a la mitad la lista de juegos y que quede parejo */}
                            {this.state.devData.gamesParticipated.slice(0, (this.state.devData.gamesParticipated.length / 2)).map((ga, i) => {return(<GameCard2 key={i} game={ga}/>)})}
                        </div>
                        <div className="col-sm-6">
                            {this.state.devData.gamesParticipated.slice((this.state.devData.gamesParticipated.length / 2), this.state.devData.gamesParticipated.length).map((ga, i) => {return(<GameCard2 key={i} game={ga}/>)})}
                        </div>
                    </div>
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
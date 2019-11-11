import React from 'react';
import './card.css';

export default class ResultCard extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            error: {},
        };
        this.goToResult = this.goToResult.bind(this)
    }

    goToResult(){
        console.log(this.props)
        switch(this.props.result.type){
            case "Game":
                this.props.history.push(`/game/${this.props.result.id}`)
                break;
            case "Dev":
                this.props.history.push(`/dev/${this.props.result.id}`)
                break;
            case "Studio":
                this.props.history.push(`/studio/${this.props.result.id}`)
            default:
                break;
        }        
    }

    render(){
        return(
            <div key={this.props.index}>
                <div className="card card-container">
                    <div className="card-header header">
                        <h3 onClick={this.goToResult}>{this.props.result.name}</h3>
                    </div>
                    <div>
                        <div className="card-body body">
                            {/*Genre: {this.props.game.genero}*/}
                            <br/>
                            {/*Platform: {this.props.game.plataforma}*/}
                            <br/>
                            <button type="button" className='btn btn-primary go-to-button' onClick={this.goToResult}>
                                Go to
                            </button>  
                        </div>
                    </div>
                </div>
                <br/>
            </div>
        )
    }
}
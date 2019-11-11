import React from 'react';
import './card.css';
const thumbnail = require('../../images/thumbnail.png');

export default class GameCard2 extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            error: {},
        };

        this.goToGame = this.goToGame.bind(this)
    }

    goToGame(){
        this.props.history.push(`/game/${this.props.game.id}`)
    }

    render(){
        console.log(this.props)
        let thumb = this.props.game.image || thumbnail
        return(
            <div className="card text-white bg-secondary mb-3" style={{ width: '520px' }}>
                <div className="row no-gutters">
                    <div className="col-md-4">
                        <img src={thumb} alt="..." height="200" width="150"/>
                    </div>
                    <div className="col-md-8">
                        <div className="card-body">
                            <h4 className="card-title">{this.props.game.name}</h4>
                            <p className="card-text">Genero: {this.props.game.genre}</p>
                            <p className="card-text">Plataforma: {this.props.game.platform}</p>
                            <button type="button" className='btn btn-primary go-to-button' onClick={this.goToGame}>
                                Go to
                            </button>  
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}






















import React from 'react';
import './card.css';

export default class GameCard extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            error: {},
        };
        this.goToGame = this.goToGame.bind(this)
    }

    goToGame(){
        this.props.history.push(`/game/${this.props.game.nombre}`)
    }

    render(){
        return(
            <div key={this.props.index}>
                <div className="card card-container">
                    <div className="card-header header">
                        <h3 onClick={this.goToGame}>{this.props.game.nombre}</h3>
                    </div>
                    <div>
                        <div className="card-body body">
                            Genre: {this.props.game.genero}
                            <br/>
                            Platform: {this.props.game.plataforma}
                            <br/>
                            <button type="button" className='btn btn-primary go-to-button' onClick={this.goToGame}>
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

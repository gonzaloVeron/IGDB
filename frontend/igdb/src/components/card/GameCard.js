import React from 'react';
import './card.css';
const thumbnail = require('../../images/thumbnail.png');

export default class GameCard extends React.Component {
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
        let thumb = this.props.game.urlImage || thumbnail
        return(
            <div key={this.props.index}>
                <div className="card card-container">
                    <div className="card-header header row">
                            <div className="column-image">
                                <img src={thumb} alt='' height="200" width="150"/>
                            </div>
                            <div className="column">
                                {this.props.game.name}
                            </div>
                    </div>
                    <div>
                        <div className="card-body body">
                            Genre: {this.props.game.genre}
                            <br/>
                            Platform: {this.props.game.platform}
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

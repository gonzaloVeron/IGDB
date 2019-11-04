import React from 'react';
import './card.css';

export default class GameCard extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            error: {},
        };
    }

    render(){
        return(
            <div key={this.props.index}>
                <div className="card">
                    <div className="card-header">
                        {this.props.game.name}
                    </div>
                    <div>
                        <div className="card-body">
                            <button type="button" className='btn btn-primary' onClick={() => this.props.history.push(`/game/${this.props.game.id}`)}>
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

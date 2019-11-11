import React from 'react';
import './card.css';

export default class GameCard2 extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            error: {},
        };

    }

    render(){
        console.log(this.props)
        return(
            <div className="card text-white bg-secondary mb-3" style={{ width: '520px' }}>
                <div className="row no-gutters">
                    <div className="col-md-4">
                        <img src={this.props.game.urlImage} className="card-img" alt="..."/>
                    </div>
                    <div className="col-md-8">
                        <div className="card-body">
                            <h5 className="card-title">{this.props.game.nombre}</h5>
                            <p className="card-text">{this.props.game.sinopsis}</p>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}






















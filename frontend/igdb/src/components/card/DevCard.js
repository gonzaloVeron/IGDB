import React from 'react';
import './card.css';
const thumbnail = require('../../images/thumbnail.png');

export default class DevCard extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            error: {},
        };
        this.goToDev = this.goToDev.bind(this)
    }

    goToDev(){
        this.props.history.push(`/dev/${this.props.dev.id}`)
    }

    render(){
        let thumb
        if (this.props.dev.image === "Ninguna"){
            thumb = thumbnail
        } else {
            thumb = this.props.dev.image
        }
        return(
            <div key={this.props.index}>
                <div className="card card-container">
                    <div className="card-header header row">
                            <div className="column-image">
                                <img src={thumb} alt='' height="200" width="150"/>
                            </div>
                            <div className="column">
                                {this.props.dev.name + " " + this.props.dev.lastName}
                            </div>
                    </div>
                    <div>
                        <div className="card-body body">
                            <button type="button" className='btn btn-primary go-to-button' onClick={this.goToDev}>
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

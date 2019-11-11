import React from 'react';
import './card.css';
const thumbnail = require('../../images/thumbnail.png');

export default class DevCard2 extends React.Component {
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
        console.log(this.props)
        let thumb
        if (this.props.dev.image === "Ninguna"){
            thumb = thumbnail
        } else {
            thumb = this.props.dev.image
        }
        return(
            <div className="card text-white bg-secondary mb-3" style={{ width: '520px' }}>
                <div className="row no-gutters">
                    <div className="col-md-4">
                        <img src={thumb} alt="..." height="200" width="150"/>
                    </div>
                    <div className="col-md-8">
                        <div className="card-body">
                            <h4 className="card-title">{this.props.dev.name + " " + this.props.dev.lastName}</h4>
                            <button type="button" className='btn btn-primary go-to-button' onClick={this.goToDev}>
                                Go to
                            </button>  
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}






















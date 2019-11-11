import React from 'react';
import './card.css';
const thumbnail = require('../../images/thumbnail.png');

export default class StudioCard2 extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            error: {},
        };

        this.goToStudio = this.goToStudio.bind(this)
    }

    goToStudio(){
        this.props.history.push(`/studio/${this.props.studio.id}`)
    }
    
    render(){
        console.log(this.props)
        return(
            <div className="card text-white bg-secondary mb-3" style={{ width: '520px' }}>
                <div className="row no-gutters">
                    <div className="col-md-4">
                        <img src={this.props.studio.logo || thumbnail} alt="..." height="200" width="150"/>
                    </div>
                    <div className="col-md-8">
                        <div className="card-body">
                            <h4 className="card-title">{this.props.studio.name}</h4>
                        </div>
                            <button type="button" className='btn btn-primary go-to-button' onClick={this.goToStudio}>
                                Go to
                            </button>  
                    </div>
                </div>
            </div>
        )
    }
}






















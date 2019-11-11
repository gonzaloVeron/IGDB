import React from 'react';
import './card.css';
const thumbnail = require('../../images/thumbnail.png');

export default class StudioCard extends React.Component {
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
        let thumb = this.props.studio.logo || thumbnail
        return(
            <div key={this.props.index}>
                <div className="card card-container">
                    <div className="card-header header row">
                            <div className="column-image">
                                <img src={thumb} alt='' height="200" width="150"/>
                            </div>
                            <div className="column">
                                {this.props.studio.name}
                            </div>
                    </div>
                    <div>
                        <div className="card-body body">
                            <button type="button" className='btn btn-primary go-to-button' onClick={this.goToStudio}>
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

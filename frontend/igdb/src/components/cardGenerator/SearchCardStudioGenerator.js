import React from 'react';
import StudioCard from '../card/StudioCard';

export default class SearchCardStudioGenerator extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            error: {},
        };
    }

    render(){
        console.log(this.props.studios);
        return(
        this.props.studios.map((st, i) => {
            return(
                <StudioCard key={i} studio={st} history={this.props.history}/>
            )
        })
        )
    }

}


import React from 'react';
import DevCard from '../card/DevCard'

export default class SearchCardDevGenerator extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            error: {},
        };
    }

    render(){
        console.log(this.props.devs);
        return(
        this.props.devs.map((de, i) => {
            return(
                <DevCard key={i} dev={de} history={this.props.history}/>
            )
        })
        )
    }

}


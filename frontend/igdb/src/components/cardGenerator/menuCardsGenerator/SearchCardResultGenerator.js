import React from 'react';
import ResultCard from '../../card/ResultCard'

export default class SearchCardResultGenerator extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            error: {},
        };
    }

    render(){
        console.log(this.props.results);
        return(
        this.props.results.map((re, i) => {
            return(
                <ResultCard key={i} result={re} history={this.props.history}/>
            )
        })
        )
    }

}

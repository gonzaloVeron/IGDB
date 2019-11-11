import React from 'react';
import GameCard from '../card/GameCard'

export default class SearchCardGameGenerator extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            error: {},
        };
    }

    render(){
        console.log(this.props.games);
        return(
        this.props.games.map((ga, i) => {
            return(
                <GameCard key={i} game={ga} history={this.props.history}/>
            )
        })
        )
    }

}


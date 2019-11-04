import React from 'react';
import NavBar from '../navbar/NavBar';

class Search extends React.Component {

    constructor(props) {
        super(props);
        this.state = {

        };
        console.log(props)
        console.log(this.state)
    }

    /*setContent(text) {
        search(text)
            .then(result => {
                this.setState({restaurants: result.restaurants})
                this.setState({menus: result.menus})
            }) 
            .catch(e => {this.setState({ error: e.message })});
    }*/

    
    render() {
        return(
            <div className="Search">
            <NavBar/>
                <div className="container">
                    <h1 className="blanco">Games with: {this.props.match.params.text}</h1>
                    {/*<RestaurantCardsGenerator restaurants={this.state.restaurants} history={this.props.history}/>/>*/}
                </div>
            </div>
        )   
    }

}

export default Search;
import React from 'react';
import NavBar from '../navbar/NavBar';
import { getSearch } from '../../api/api.js'
import SearchCardGameGenerator from '../cardGenerator/menuCardsGenerator/SearchCardGameGenerator.js'

class Search extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            queryResults: [],

        };
        console.log(props)
        console.log(this.state)
    }

    componentDidMount(){
        let {searchValue, genre, platform} = this.props.match.params
        getSearch(searchValue, platform, genre).then(result => {
            this.setState({queryResults: result.queryResults})
        }).catch(e => {this.setState({ error: e.message })})
    }  

    componentDidUpdate(prevProps){
        if(this.props.match.params != prevProps.match.params){
            this.componentDidMount()
        }
    }
    
    render() {
        return(
            <div className="Search">
            <NavBar/>
                <div className="container">
                    <h1 className="blanco">Games with: {this.props.match.params.searchValue}</h1>
                    <SearchCardGameGenerator games={this.state.queryResults} history={this.props.history}/>/>
                </div>
            </div>
        )   
    }

}

export default Search;
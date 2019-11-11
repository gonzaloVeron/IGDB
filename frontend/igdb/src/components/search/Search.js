import React from 'react';
import NavBar from '../navbar/NavBar';
import { getSearch } from '../../api/api.js'
import SearchCardGameGenerator from '../cardGenerator/SearchCardGameGenerator.js'
import SearchCardStudioGenerator from '../cardGenerator/SearchCardStudioGenerator.js'
import {CollapsibleComponent, CollapsibleHead, CollapsibleContent} from 'react-collapsible-component'
import './Search.css'
import SearchCardDevGenerator from '../cardGenerator/SearchCardDevGenerator';

export default class Search extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            queryResults: {
                games: [],
                devs: [],
                studios: [],
            },

        };
        console.log(props)
        console.log(this.state)
    }

    componentDidMount(){
        let {searchValue, platform, genre} = this.props.match.params
        getSearch(searchValue, platform, genre).then(result => {
            console.log(result)
            this.setState({ queryResults: result }, ()=> console.log(this.state));
        }).catch(e => {this.setState({ error: e.message })})
    }  

    componentDidUpdate(prevProps){
        if(this.props.match.params !== prevProps.match.params){
            this.componentDidMount()
        }
    }

    renderGameSearchResults(){
        return (
            <CollapsibleContent isExpanded={false} className="collapsible-content">
                <SearchCardGameGenerator games={this.state.queryResults.games} history={this.props.history} />
            </CollapsibleContent>
        )
    }

    renderStudiosSearchResults(){
        return (
            <CollapsibleContent isExpanded={false} className="collapsible-content">
                <SearchCardStudioGenerator studios={this.state.queryResults.studios} history={this.props.history} />
            </CollapsibleContent>
        )
    }
    
    renderDevsSearchResults(){
        return (
            <CollapsibleContent isExpanded={false} className="collapsible-content">
                <SearchCardDevGenerator devs={this.state.queryResults.devs} history={this.props.history} />
            </CollapsibleContent>
        )
    }
    
    render() {
        return(
            <div className="Search body-container">
                <NavBar/>
                <div className="container">
                    <CollapsibleComponent>
                        <CollapsibleHead isExpanded={false} className="collapsible-head"><h1 className="blanco">Search Results for Games</h1></CollapsibleHead>
                        {this.renderGameSearchResults()}
                        <CollapsibleHead isExpanded={false} className="collapsible-head"><h1 className="blanco">Search Results for Studios</h1></CollapsibleHead>
                        {this.renderStudiosSearchResults()}
                        <CollapsibleHead isExpanded={false} className="collapsible-head"><h1 className="blanco">Search Results for Developers</h1></CollapsibleHead>
                        {this.renderDevsSearchResults()}
                    </CollapsibleComponent>
                </div>
            </div>
        )   
    }

}
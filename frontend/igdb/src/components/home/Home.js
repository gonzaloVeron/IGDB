import React from 'react';
import OrderCardsGenerator from '../cardGenerator/OrderCardsGenerator.js';
import './home.css';
import NavBar from '../navbar/NavBar'

export default class Home extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            error: '',
        };
        
    }

    /*setContent(user) {
        getUserWithOrders(user)
            .then(userPromise =>{
                this.setState({user: userPromise})
            }) 
            .catch(e => {this.setState({ error: e.message })});
    }*/

    componentDidMount() {
        //this.setContent(this.props.username);
    }

    render(){
        return (
            <div>
                <NavBar />
                <div className="container">
                    <h1 style={{color: 'white', textAlign: 'center'}}>Home</h1>
                </div>
            </div>
        )
    }
}

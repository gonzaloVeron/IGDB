import React from 'react';
import './home.css';
import NavBar from '../navbar/NavBar'

export default class Home extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            error: '',
        };
        
    }

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

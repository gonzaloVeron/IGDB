import React, { Component } from 'react';
import { 
  BrowserRouter as Router,
  Switch, 
  Route,
 } from 'react-router-dom';

import Home from './components/Home';
import GameFile from './components/GameFile';
import Search from './components/Search';

import './App.css';

export default class App extends Component {
  render() {
    console.log(this.props)
    return (
      <Router>
        <Switch>
          <Route path='/' exact component={Home}/>
          <Route path='/index' exact component={Home}/>
          <Route path='/game/:id' component={GameFile}/>
          <Route path='/search' component={Search}/>
        </Switch>
    </Router>
    );
  }
  
}
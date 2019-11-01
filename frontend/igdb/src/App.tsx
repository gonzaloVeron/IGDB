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
    return (
      <Router>
        <Switch>
          <Route path='/' exact>
            <Home />
          </Route>
          <Route path='/index' exact>
            <Home />
          </Route>
          <Route path='/game/:id'>
            <GameFile />
          </Route>
          <Route path='/search'>
            <Search />
          </Route>
        </Switch>
    </Router>
    );
  }
  
}
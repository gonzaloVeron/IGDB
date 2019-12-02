import React from 'react';
import { BrowserRouter as Router, Switch, Route  } from 'react-router-dom';
import Home from './components/home/Home';
import Search from './components/search/Search';
import GameFile from './components/gamefile/GameFile';
import DevFile from './components/devFile/DevFile';
import DevStudio from './components/devStudio/DevStudio';
import Register from './components/register/Register';
import Login from './components/login/Login'
import './App.css';

const App = () => (
  <Router>
      <Switch> 
        <Route path="/search/:platform/:genre/:query" component={Search}/> 
        <Route path="/game/:id" component={GameFile}/>
        <Route path="/home" component={Home}/>
        <Route path="/dev/:id" component={DevFile}/>
        <Route path="/studio/:id" component={DevStudio}/>
        <Route path="/register" component={Register}/>
        <Route path="/login" component={Login}/>
        <Route path="/" component={Home}/> 
      </Switch>
  </Router>
);

export default App;

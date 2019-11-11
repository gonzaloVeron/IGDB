import React, {Suspense}  from 'react';
import { BrowserRouter as Router, Switch, Route  } from 'react-router-dom';
import Home from './components/home/Home';
import Search from './components/search/Search';
import GameFile from './components/gamefile/GameFile';
import DevFile from './components/devFile/DevFile';
import DevStudio from './components/devStudio/DevStudio';
import './App.css';

const App = () => (
  <Router>
    <Suspense fallback={<div>Loading...</div>}>
      <Switch> 
        {/*<Route exact path="/register" component={Register}/>*/}
        <Route path="/search/:searchValue/:platform/:genre" component={Search}/> 
        <Route path="/game/:id" component={GameFile}/>
        <Route path="/home" component={Home}/>
        <Route path="/dev/:id" component={DevFile}/>
        <Route path="/studio/:id" component={DevStudio}/>
        <Route path="/" component={Home}/> 
      </Switch>
    </Suspense>
  </Router>
);

export default App;

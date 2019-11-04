import React, {Suspense}  from 'react';
import { BrowserRouter as Router, Switch, Route  } from 'react-router-dom';
import './App.css'
import Home from './components/home/Home'
import Search from './components/search/Search'

const App = () => (
  <Router>
    <Suspense fallback={<div>Loading...</div>}>
      <Switch> 
        {/*<Route exact path="/register" component={Register}/>*/}
        <Route path="/search/:searchValue/:platform/:genre" component={Search}/> 
        <Route path="/" component={Home}/> 
        <Route path="/home" component={Home}/>
      </Switch>
    </Suspense>
  </Router>
);

export default App;

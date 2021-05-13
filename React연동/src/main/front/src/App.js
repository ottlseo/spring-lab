import './App.css';
import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Main from './view/main';


function App() {
  return (
    <div className="App">
      <Router>
        <Switch>
          <Route exact path="/" exact component={Main} />
        </Switch>
      </Router>
    </div>
  );
}

export default App;
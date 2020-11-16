import React, { Component } from "react";
import { Switch, Route, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import './App.css';


import AddSong from "./components/add-song.component";
import Song from "./components/song.component";
import SongsList from "./components/songs-list.component";

class App extends Component {
  render() {
    return (
      <div>
        <nav className="navbar navbar-expand navbar-dark bg-dark">
          <a href="/songs" className="navbar-brand">
            Yeah
          </a>
          <div className="navbar-nav mr-auto">
            <li className="nav-item">
              <Link to={"/songs"} className="nav-link">
                Songs
              </Link>
            </li>
            <li className="nav-item">
              <Link to={"/addSong"} className="nav-link">
                Add
              </Link>
            </li>
          </div>
        </nav>

        <div className="container mt-3">
          <Switch>
            <Route exact path={["/", "/songs"]} component={SongsList} />
            <Route exact path="/addSong" component={AddSong} />
            <Route path="/songs/:id" component={Song} />
          </Switch>
        </div>
      </div>
    );
  }
}

export default App;
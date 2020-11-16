import React, { Component } from "react";
import SongDataService from "../services/song.service";

export default class AddSong extends Component {
  constructor(props) {
    super(props);
    this.onChangeSong_name = this.onChangeSong_name.bind(this);
    this.onChangeArtist = this.onChangeArtist.bind(this);
    this.saveSong = this.saveSong.bind(this);
    this.newSong = this.newSong.bind(this);

    this.state = {
      id: null,
      song_name: "",
      artist: "", 
      

      submitted: false
    };
  }

  onChangeSong_name(e) {
    this.setState({
      song_name: e.target.value
    });
  }

  onChangeArtist(e) {
    this.setState({
      artist: e.target.value
    });
  }

  saveSong() {
    var data = {
      song_name: this.state.song_name,
      artist: this.state.artist
    };

    SongDataService.create(data)
      .then(response => {
        this.setState({
          id: response.data.id,
          song_name: response.data.song_name,
          artist: response.data.artist,

          submitted: true
        });
        console.log(response.data);
      })
      .catch(e => {
        console.log(e);
      });
  }

  newSong() {
    this.setState({
      id: null,
      song_name: "",
      artist: "",

      submitted: false
    });
  }

  render() {
    return (
        <div className="submit-form">
          {this.state.submitted ? (
            <div>
              <h4>You submitted successfully!</h4>
              <button className="btn btn-success" onClick={this.newSong}>
                Add
              </button>
            </div>
          ) : (
            <div>
              <div className="form-group">
                <label htmlFor="song_name">Song Name</label>
                <input
                  type="text"
                  className="form-control"
                  id="song_name"
                  required
                  //value={this.state.song_name}
                  onChange={this.onChangeSong_name}
                  name="Song_name"
                />
              </div>
  
              <div className="form-group">
                <label htmlFor="artist">Artist</label>
                <input
                  type="text"
                  className="form-control"
                  id="artist"
                  required
                  //value={this.state.artist}
                  onChange={this.onChangeArtist}
                  name="artist"
                />
              </div>
  
              <button onClick={this.saveSong} className="btn btn-success">
                Submit
              </button>
            </div>
          )}
        </div>
      );
  }
}
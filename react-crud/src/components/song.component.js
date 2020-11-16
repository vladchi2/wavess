import React, { Component } from "react";
import SongDataService from "../services/song.service";

export default class Song extends Component {
  constructor(props) {
    super(props);
    this.onChangeSong_name = this.onChangeSong_name.bind(this);
    this.onChangeArtist = this.onChangeArtist.bind(this);
    this.getSong = this.getSong.bind(this);
    this.updateSong = this.updateSong.bind(this);
    this.deleteSong = this.deleteSong.bind(this);

    this.state = {
      currentSong: {
        id: null,
        song_name: "",
        artist: "",
      },
      message: ""
    };
  }

  componentDidMount() {
    this.getSong(this.props.match.params.id);
  }

  onChangeSong_name(e) {
    const song_name = e.target.value;

    this.setState(function(prevState) {
      return {
        currentSong: {
          ...prevState.currentSong,
          song_name: song_name
        }
      };
    });
  }

  onChangeArtist(e) {
    const artist = e.target.value;
    
    this.setState(prevState => ({
      currentSong: {
        ...prevState.currentSong,
        artist: artist
      }
    }));
  }

  getSong(id) {
    SongDataService.get(id)
      .then(response => {
        this.setState({
          currentSong: response.data
        });
        console.log(response.data);
      })
      .catch(e => {
        console.log(e);
      });
  }

  updateSong() {
    SongDataService.update(
      this.state.currentSong.id,
      this.state.currentSong
    )
      .then(response => {
        console.log(response.data);
        this.setState({
          message: "The song was updated successfully!"
        });
      })
      .catch(e => {
        console.log(e);
      });
  }

  deleteSong() {    
    SongDataService.delete(this.state.currentSong.id)
      .then(response => {
        console.log(response.data);
        this.props.history.push('/songs')
      })
      .catch(e => {
        console.log(e);
      });
  }

  render() {
    const { currentSong } = this.state;

    return (
      <div>
        {currentSong ? (
          <div className="edit-form">
            <h4>Song</h4>
            <form>
              <div className="form-group">
                <label htmlFor="song_name">Song_name</label>
                <input
                  type="text"
                  className="form-control"
                  id="song_name"
                  //value={currentSong.song_name}
                  onChange={this.onChangeSong_name}
                />
              </div>
              <div className="form-group">
                <label htmlFor="artist">Artist</label>
                <input
                  type="text"
                  className="form-control"
                  id="artist"
                  //value={currentSong.artist}
                  onChange={this.onChangeArtist}
                />
              </div>

              
            </form>

            <button
              className="badge badge-danger mr-2"
              onClick={this.deleteSong }
            >
              Delete
            </button>

            <button
              type="submit"
              className="badge badge-success"
              onClick={this.updateSong}
            >
              Update
            </button>
            <p>{this.state.message}</p>
          </div>
        ) : (
          <div>
            <br />
            <p>Please click on a Song...</p>
          </div>
        )}
      </div>
    );
  }
}
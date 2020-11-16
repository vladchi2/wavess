import React, { Component } from "react";
import SongDataService from "../services/song.service";
import { Link } from "react-router-dom";

export default class SongsList extends Component {
    constructor(props) {
        super(props);
        this.onChangeSearchSong_name = this.onChangeSearchSong_name.bind(this);
        this.retrieveSongs = this.retrieveSongs.bind(this);
        this.refreshList = this.refreshList.bind(this);
        this.setActiveSong = this.setActiveSong.bind(this);
        this.removeAllSongs = this.removeAllSongs.bind(this);
        this.searchSong_name = this.searchSong_name.bind(this);

        this.state = {
            songs: [],
            currentSong: null,
            currentIndex: -1,
            searchSong_name: ""
          };
    }

    componentDidMount() {
        this.retrieveSongs();
    }

    onChangeSearchSong_name(e) {
        const searchSong_name = e.target.value;
    
        this.setState({
          searchSong_name: searchSong_name
        });
      }
    
      retrieveSongs() {
        SongDataService.getAll()
          .then(response => {
            this.setState({
              songs: response.data
            });
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
      }
    
      refreshList() {
        this.retrieveSongs();
        this.setState({
          currentSong: null,
          currentIndex: -1
        });
      }
    
      setActiveSong(song, index) {
        this.setState({
          currentSong: song,
          currentIndex: index
        });
      }
    
      removeAllSongs() {
        SongDataService.deleteAll()
          .then(response => {
            console.log(response.data);
            this.refreshList();
          })
          .catch(e => {
            console.log(e);
          });
      }
    
      searchSong_name() {
        SongDataService.findBySong_name(this.state.searchSong_name)
          .then(response => {
            this.setState({
              songs: response.data
            });
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
      }
    
      render() {
        const { searchSong_name, songs, currentSong, currentIndex } = this.state;

        return (
        <div className="list row">
            <div className="col-md-8">
            <div className="input-group mb-3">
                <input
                type="text"
                className="form-control"
                placeholder="Search by Song Name"
                value={searchSong_name}
                onChange={this.onChangeSearchSong_name}
                />
                <div className="input-group-append">
                <button
                    className="btn btn-outline-secondary"
                    type="button"
                    onClick={this.searchSong_name}
                >
                    Search
                </button>
                </div>
            </div>
            </div>
            <div className="col-md-6">
              
            <h4>Songs List</h4>

            <ul className="list-group">
                {songs &&
                songs.map((song, index) => (
                    <li
                    className={
                        "list-group-item " +
                        (index === currentIndex ? "active" : "")
                    }
                    onClick={() => this.setActiveSong(song, index)}
                    key={index}
                    >
                    {song.song_name}
                    </li>
                ))}
            </ul>

            <button
                className="m-3 btn btn-sm btn-danger"
                onClick={this.removeAllSongs}
            >
                Remove All
            </button>
            </div>
            <div className="col-md-6">
            {currentSong ? (
                <div>
                <h4>Song</h4>
                <div>
                    <label>
                    <strong>Song_name:</strong>
                    </label>{" "}
                    {currentSong.song_name}
                </div>
                <div>
                    <label>
                    <strong>Artist:</strong>
                    </label>{" "}
                    {currentSong.artist}
                </div>
                <div>
                    <label>
                    <strong>Album_id:</strong>
                    </label>{" "}
                    {currentSong.album_id}
                </div>
                

                <Link
                    to={"/songs/" + currentSong.id}
                    className="badge badge-warning"
                >
                    Edit
                </Link>
                </div>
            ) : (
                <div>
                <br />
                <p>Please click on a Song...</p>
                </div>
            )}
            </div>
        </div>
    );
  }
      


      
}
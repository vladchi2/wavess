import http from "../http-common";

class SongDataService {
  getAll() {
    return http.get("/songs");
  }

  get(id) {
    return http.get(`/songs/${id}`);
  }

  create(data) {
    return http.post("/songs", data);
  }

  update(id, data) {
    return http.put(`/songs/${id}`, data);
  }

  delete(id) {
    return http.delete(`/songs/${id}`);
  }

  deleteAll() {
    return http.delete(`/songs`);
  }

  findBySong_name(song_name) {
    return http.get(`/songs?song_name=${song_name}`);
  }
}

export default new SongDataService();
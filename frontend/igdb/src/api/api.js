import axios from 'axios';

const server = 'http://localhost:7000';

const request = (type, path, body) => axios
  .request({ url: `${server}${path}`, method: type, data: body })
  .then(req => req.data);

export const getGame = gameId => request('get', `/game/${gameId}`)

export const getSearch = (searchValue, platform, genre) => request('get', `/search?name=${searchValue}&platform=${platform}&genre=${genre}`)
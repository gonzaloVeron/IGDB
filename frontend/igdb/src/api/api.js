import axios from 'axios';

const server = 'http://localhost:7000';

const request = (type, path, body) => axios
  .request({ url: `${server}${path}`, method: type, data: body })
  .then(req => req.data);

export const getGame = gameID => request('get', `/game/${gameID}`)

export const getDev = devID => request('get', `/dev/${devID}`)

export const getDevStudio = studioID => request('get', `/studio/${studioID}`)

export const getSearch = (searchValue, platform, genre) => {
  const key = "query=" + searchValue + '&'
  const plat = 'platform=' + platform 
  const get = '&genre=' + genre
  return request('get', '/search?'+ key + plat + get)
}

export const register = body => request('post', '/register', body)

export const signIn = body => request('post', '/login', body)

export const putReview = (gameID, body) => request('put', `/review/${gameID}`, body)

export const deleteReview = (gameID, body) => request('delete', `/review/${gameID}`, body)

export const getUser = userId => request('get', `/user/${userId}`)

export const changeImage = (userId, body) => request('put', `/changephotouser/${userId}`, body)
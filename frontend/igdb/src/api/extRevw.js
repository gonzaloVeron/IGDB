import axios from 'axios';

const server = 'https://api.rawg.io/api';

const request = (type, path, body) => axios
  .request({ url: `${server}${path}`, method: type, data: body })
  .then(req => req.data);

export const getGameData = gameName => {
  return request('get', `/games?page=1&page_size=1&search=${gameName.toLowerCase()}`)
    .then((response)=>{
      console.log(response);
      return response.results[0];
    })
}

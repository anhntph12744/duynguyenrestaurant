import axiosClient from './axiosClient';

const AuthAPI = {
  // use: username, password
  login: (user) => {
    const url = '/service/signin';
    return axiosClient.post(url, user);
  },
  register: (user) => {
    const url = '/service/register';
    return axiosClient.post(url, user);
  },
};

export default AuthAPI;

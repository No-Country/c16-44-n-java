import {headers, confirm} from './api.js'

const BASE_URL = 'http://localhost:8080/v1/user'
const setOptPost = (form) => ({
  method: 'POST',
  headers,
  body: JSON.stringify(form)
})

export const getAllUsers = () => {
  return fetch('/api', {headers})
    .then(confirm)
    .then(console.log)
}

export const postUser = (form) => {
  return fetch('/api', setOptPost(form))
}

export const postItem = (form) => {
  return fetch('/api/item', setOptPost(form))
}

export const login = (form) => {
  return fetch(BASE_URL + '/login', setOptPost(form))
    .then(confirm)
    .then(res => {
      localStorage.setItem('user', JSON.stringify(res))
      return res
    })
}
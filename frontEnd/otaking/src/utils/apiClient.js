import {headers, confirm} from './api.js'

const user = 'http://localhost:8080/v1/user'
const product = 'http://localhost:8080/v1/product'

const setPostOpt = (form) => ({
  method: 'POST',
  headers,
  body: JSON.stringify(form)
})

export const getAllUsers = () => {
  return fetch('/api', {headers})
    .then(confirm)
}

export const postUser = (form) => {
  return fetch('/api', setPostOpt(form))
}

export const postItem = (form) => {
  return fetch('/api/item', setPostOpt(form))
}

export const login = (form) => {
  return fetch(user + '/login', setPostOpt(form))
    .then(confirm)
    .then(res => {
      localStorage.setItem('user', JSON.stringify(res))
      return res
    })
}

export const getCategory = (category) => {
  return fetch(product + '/category/' + category, {headers, next: {revalidate: 15}})
    .then(confirm)
}
import {headers, confirm} from './api.js'

export const getAllUsers = () => {
  return fetch('/api', {headers})
    .then(confirm)
    .then(console.log)
}

export const postUser = (form) => {
  form = {...form, userType: { userType: form.userType}}
  return fetch('/api', {
    method: 'POST',
    headers,
    body: JSON.stringify(form)
  })
}

export const postItem = (form) => {
  return fetch('/api/item', {
    method: 'POST',
    headers,
    body: JSON.stringify(form),
  })
}
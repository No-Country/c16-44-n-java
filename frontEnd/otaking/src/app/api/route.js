import { confirm, headers, res } from '@/utils/api.js'
export const BASE_URL = 'https://c16-44-n-java.onrender.com/v1/user'

const postUser = (res) => {
  return fetch(BASE_URL + '/create', {
    method: 'POST',
    headers,
    body: JSON.stringify(res)
  })
    .then(confirm)
}

export function GET() {
  return fetch(BASE_URL + '/all', {
    headers,
  }).then(confirm)
    .then(res)
}

export function POST(req) {
  return Promise.resolve(req.json())
    .then(postUser)
    .then(res)
}
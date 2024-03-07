import { confirm, headers, res, BASE_URL } from '@/utils/api.js'

const user = BASE_URL + '/user'

const postUser = (res) => {
  return fetch(user + '/create', {
    method: 'POST',
    headers,
    body: JSON.stringify(res)
  })
  .then(confirm)
}

export function GET() {
  return fetch(user + '/all', {
    headers,
  }).then(confirm)
  .then(res)
}

export function POST(req) {
  return Promise.resolve(req.json())
    .then(postUser)
    .then(res)
}
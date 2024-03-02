import { headers, res } from "@/utils/api"
const BASE_URL = 'http://localhost:8080/v1/product'

export const POST = (req) => {
  return Promise.resolve(req.json())
    .then((res) => {
      return fetch(BASE_URL + '/create', {
        headers,
        method: 'POST',
        body: JSON.stringify(res)
      })
  }).then(res)
}
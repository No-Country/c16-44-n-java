import { BASE_URL, headers, res } from "@/utils/api"

const product = BASE_URL + '/product'

export const POST = (req) => {
  return Promise.resolve(req.json())
    .then((res) => {
      return fetch(product + '/create', {
        headers,
        method: 'POST',
        body: JSON.stringify(res)
      })
  }).then(res)
}
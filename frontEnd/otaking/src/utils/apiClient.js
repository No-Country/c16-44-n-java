import { headers, confirm, BASE_URL } from './api.js'

const user = BASE_URL + '/user';
const product = BASE_URL + '/product'
const name_des = product + '/ordered-by-name-des'
const name_asc = product + '/ordered-by-name-asc'
const price_high = product + '/low-to-high'
const price_low = product + '/high-to-low'
const cart = BASE_URL + '/shoppingcarts'

const optionsGET = {
  headers,
  next: { revalidate: 15 }
}

const setPostOpt = (form) => ({
  method: 'POST',
  headers,
  body: JSON.stringify(form)
})

export const getAllUsers = () => {
  return fetch('/api', optionsGET)
    .then(confirm)
}

export const postUser = (form) => {
  return fetch('/api', setPostOpt(form))
}

export const postItem = ({
  name,
  price,
  stock,
  description,
  brand,
  user,
  category,
}, images) => {
  const form = {
    name,
    price,
    stock,
    description,
    brand,
    user: {
      id: user.id,
      userType: user.userType
    },
    category: {
      id: category,
    },
  }

  return fetch(product + '/create', setPostOpt(form))
    .then(confirm)
    .then((res) => {
      images.append('publicationId', res.id)

      return fetch(product + '/saveImages', {
        method: 'POST',
        body: images,
      })
    })
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
  return fetch(product + '/category/' + category, optionsGET)
    .then(confirm)
}

export const getCategoryDes = async (category) => {
  try {
    const response = await fetch(name_des, category, { headers });
    const data = await response.json();
    return data;
  } catch (error) {
    console.error('Error fetching data:', error);
    return null;
  }
};

export const getCategoryAsc = () => {
  return fetch(`${name_asc}`, { headers, next: { revalidate: 15 } })
    .then(confirm)
}

export const getCategoryHigh = () => {
  return fetch(`${price_high}`, { headers, next: { revalidate: 15 } })
    .then(confirm)
}

export const getCategoryLow = () => {
  return fetch(`${price_low}`, { headers, next: { revalidate: 15 } })
    .then(confirm)
}

export const getProduct = (id) => {
  return fetch(product + `/search/${id}`, optionsGET)
    .then(confirm)
}

export const getAllProductos = ({param = '/all', page = 1}) => {
  return fetch(product + param + '?page=' + page, optionsGET)
    .then(confirm)
    .then(res => {
      return res.content
    })
}

export const addCart = (form) => {
  return fetch(cart + '/add', setPostOpt(form))
}
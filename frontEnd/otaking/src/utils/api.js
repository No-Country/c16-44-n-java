// export const BASE_URL = 'http://localhost:8080/v1'
export const BASE_URL = 'https://c16-44-n-java.onrender.com/v1'

export const headers = {
  'Content-Type': 'application/json'
}

export const confirm = (res) => {
  if(res.ok) return res.json();
  return Promise.reject(`Error: ${res.message}.`);
}

export const res = (res) => new Response(JSON.stringify(res))

export const headers = {
  'Content-Type': 'application/json'
}

export const confirm = (res) => {
  if(res.ok) return res.json();
  return Promise.reject(`Error: ${res.message}.`);
}

export const res = (res) => new Response(JSON.stringify(res))

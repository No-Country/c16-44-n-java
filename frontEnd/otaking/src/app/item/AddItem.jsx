'use client'

import { useGlobalContext } from "@/context/store"
import { addCart } from "@/utils/apiClient"

export default function AddItem({productId, name, price}) {
  const { user, setCart } = useGlobalContext()

  function submit(e) {
    e.preventDefault()
    const quantity = new FormData(e.target).get('quantity')
    const product = {quantity, userId: user.id, productId}
    setCart((prev) => [...prev, {...product, name, price}])
    addCart(product)
  }

  return <form className="selector" onSubmit={submit}>
  <label className="label" htmlFor="cant">Cantidad</label>
      <div className="encuadre">
          <fieldset>
              <input className="input-number" type="number" min={1} defaultValue={1} name="quantity">
              </input>
          </fieldset>
          <button type="submit" className="button-style">Añadir al carrito</button>
      </div>
  </form>
}
'use client'
import { useGlobalContext } from "@/context/store.jsx";
import './Cart.css';
import FormWithTable from "../FormWithTable/FormWithTable";
import { useEffect, useState } from "react";

export default function Cart() {
  const {popups:{cart}, closeAllPopups} = useGlobalContext();
  const { cart: products, setCart} = useGlobalContext()

  const [sum, setSum] = useState(0)

  useEffect(() => {
    setSum(products.reduce((acc, {quantity, price}) => acc + quantity * price, 0))
  }, [products])

  function handleChange(e) {
    setCart((prev)=> {
      const product = prev.find(product => product.name === e.target.name)

      product.quantity = e.target.value
      let total = 0

      prev.forEach((prod) => {
        total += prod.quantity * prod.price
      })

      return [...prev]
    })
  }

  function submit() {
    setCart([])
    setSum(0)
    closeAllPopups()
  }
  
  return <FormWithTable 
    heads={['Nombre', 'Cantidad', 'Precio']} 
    isOpen={cart} 
    title={'Comprar'}
    amount={sum}
    onSubmit={submit}
  >
    {products.map(({name, price, quantity}, id) => <tr key={id}>
        <th scope="row">{name}</th>
        <td><input min={0} style={{width: 50, textAlign: 'center'}} name={name} type='number' value={quantity} onChange={handleChange}/></td>
        <td>{price * quantity}</td>
      </tr>
    )}
  </FormWithTable>
}
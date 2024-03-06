'use client'
import { useGlobalContext } from "@/context/store.jsx";
import './Cart.css';
import FormWithTable from "../FormWithTable/FormWithTable";
import useForm from "@/hooks/useForm";
import { useState } from "react";

export default function Cart() {
  const {popups:{cart}} = useGlobalContext();
  const {inputs, handleChange: onChange} = useForm('Comprar');
  const [products, setProducts] = useState([
    {name: 'kakashi kakashi kakashi', price: 50, amount: 1},
    {name: 'yae', price: 40, amount: 1},
    {name: 'woody', price: 80, amount: 1}
  ]);
  const [sum, setSum] = useState(products.reduce((acc, {price}) => acc + price, 0))

  function handleChange(e) {
    function syncronize (inputs) {
      let quantity = 0

      for (const input in inputs) {
        quantity += inputs[input].value * products.find(product => product.name === input).price
      }

      setSum(quantity)
    }

    onChange(e, syncronize)
  }

  return <FormWithTable 
    heads={['Nombre', 'Cantidad', 'Precio']} 
    isOpen={cart} 
    title={'Comprar'}
    amount={sum}
  >
    {products.map(({name, price, amount}, id) => <tr key={id}>
        <th scope="row">{name}</th>
        <td><input min={0} style={{width: 50, textAlign: 'center'}} name={name} type='number' value={inputs[name]?.value ?? amount} onChange={handleChange}/></td>
        <td>{price * (inputs[name]?.value ?? 1)}</td>
      </tr>
    )}
  </FormWithTable>
}
'use client'
import useForm from "@/hooks/useForm"
import './page.css'
import Link from "next/link";
import { usePathname } from "next/navigation";
import { postItem } from "@/utils/apiClient";

export default function Sell() {
  const {inputs: {name, price, stock, description, brand, category}, handleChange, resetForm, getValues} = useForm('sellForm');
  const pathName = usePathname()

  function handleSubmit(e) {
    e.preventDefault()
    const values = getValues()
    for (const prop in values) {
      if (!Number.isNaN(+values[prop])) values[prop] = +values[prop]
    }

    const format = {...values, category: {id: values.category}}
    postItem(format).finally(() => resetForm())
  }

  return <main className="sell">
    <Link href={pathName + '/stock'} >Stock</Link>
    <form className="sell-form" name="sellForm" style={{display: 'flex', flexDirection: 'column'}} onSubmit={handleSubmit} noValidate>
      <h3 className="sell-form__title">¿Qué vamos a vender?</h3>
      <input className="sell-form__item" onChange={handleChange} defaultValue={name?.value ?? ''} type='text' name='name' placeholder="Nombre del producto" required />
      <input className="sell-form__item" onChange={handleChange} defaultValue={price?.value ?? ''} type='number' name='price' placeholder="Precio" required />
      <input className="sell-form__item" onChange={handleChange} defaultValue={stock?.value ?? ''} type='number' name='stock' placeholder="Existencias" required />
      <textarea className="sell-form__item" onChange={handleChange} defaultValue={description?.value ?? ''} name='description' placeholder="Descripción del producto" required />
      <input className="sell-form__item" onChange={handleChange} defaultValue={brand?.value ?? ''} type='text' name='brand' placeholder="marca" required />
      <select className="sell-form__item" name="category" defaultValue={category?.value} onChange={handleChange}>
        <option value="0">--Elije una categoría--</option>
        <option value="1">Vasos</option>
        <option value="2">Afiches</option>
        <option value="3">Stikers</option>
        <option value="4">Juegos</option>
        <option value="5">Muñecos</option>
      </select>
      <menu className="sell-form__menu">
        <button className='sell-form__btn' type="submit">Enviar</button>
        <button className='sell-form__btn' type="reset" onClick={resetForm}>Borrar</button>
      </menu>
    </form>
  </main>
}
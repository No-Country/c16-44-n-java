'use client'
import useForm from "@/hooks/useForm"
import './page.css'
import { postItem } from "@/utils/apiClient";
import { useGlobalContext } from "@/context/store";
import { useState } from "react";

export default function Sell() {
  const { inputs: { name, price, stock, description, brand, category }, handleChange, resetForm, getValues } = useForm('sellForm');
  const { user } = useGlobalContext()
  const [files, setFiles] = useState(null)
  const [file, setFile] = useState(null)

  function handleSubmit(e) {
    e.preventDefault()
    const form = Object.fromEntries(new FormData(e.target))
    const images = new FormData()

    images.append('mainImage', file)

    Array.from(files).forEach((file) => {
      images.append(`images`, file)
    })
    
    postItem({...form, user}, images)
  }

  return <main className="sell">
    <form className="sell-form" name="sellForm" style={{ display: 'flex', flexDirection: 'column' }} onSubmit={handleSubmit} noValidate encType="multipart/form-data">
      <h3 className="sell-form__title">¿Qué vamos a vender?</h3>
      <input className="sell-form__item" onChange={handleChange} value={name?.value ?? ''} type='text' name='name' placeholder="Nombre del producto" required />
      <input className="sell-form__item" onChange={handleChange} value={price?.value ?? ''} type='number' name='price' placeholder="Precio" required />
      <input className="sell-form__item" onChange={handleChange} value={stock?.value ?? ''} type='number' name='stock' placeholder="Existencias" required />
      <textarea className="sell-form__item" onChange={handleChange} value={description?.value ?? ''} name='description' placeholder="Descripción del producto" required />
      <input className="sell-form__item" onChange={handleChange} value={brand?.value ?? ''} type='text' name='brand' placeholder="marca" required />
      <select className="sell-form__item" name="category" value={category?.value} onChange={handleChange}>
        <option value="0">--Elije una categoría--</option>
        <option value="1">Manga</option>
        <option value="2">Indumentaria</option>
        <option value="3">Accesorios</option>
        <option value="4">Figuras</option>
      </select>
      <input className="sell-form__item" onChange={e => setFile(e.target.files[0])} type='file' name='mainImage' required accept="*" encType="multipart/form-data" />
      <input className="sell-form__item" onChange={e => setFiles(e.target.files)} type='file' name='images' multiple required accept="*" encType="multipart/form-data" />
      <menu className="sell-form__menu">
        <button className='sell-form__btn' type="submit">Enviar</button>
        <button className='sell-form__btn' type="reset" onClick={resetForm}>Borrar</button>
      </menu>
    </form>
  </main>
}
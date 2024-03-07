'use client'
import './page.css'
import ProductCard from '@/components/ProductCard/ProductCard'
import { getAllProductos } from '@/utils/apiClient'
import { useEffect, useState } from 'react'

export default function All() {
  const [cards, setCards] = useState([])
  const [page, setPage] = useState(1)

  useEffect(() => {
    getAllProductos({})
      .then(setCards)
  }, [])

  function click() {
    getAllProductos({page})
      .then((res) => {
        setCards(prev => [...prev, ...res])
        setPage(page + 1)
      })
  }

  function change(e) {
    setPage(1)
    getAllProductos({param: e.target.value, page: 1})
      .then(setCards)
  }

  return <main className='search'>
    <hgroup>
      <h2>{`Mostrando productos para: todo`}</h2>
      <p>1-9 productos</p>
    </hgroup>
    <form>
      <search>
        <label>Ordenar por: </label>
        <select name='filter' onChange={change} >
          <optgroup label='nombre'>
            <option value={'/ordered-by-name-asc'}>ascendente</option>
            <option value={'/ordered-by-name-des'}>descendente</option>
          </optgroup>
          <optgroup label='precio'>
            <option value={'/low-to-high'}>ascendente</option>
            <option value={'/high-to-low'}>descendente</option>
          </optgroup>
        </select>
      </search>
    </form>
    <div className="flexbox-card">
      {cards.map((card) => (
        <ProductCard key={card.id} {...card} />
      ))}
    </div>
    <button type='button' onClick={click}>Cargar</button>
  </main>
}
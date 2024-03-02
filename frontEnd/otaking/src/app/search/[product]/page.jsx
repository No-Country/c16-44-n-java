'use client'
import './page.css'

export default function Product({params}) {
  const product = {fabric: 'indumentaria', figure: 'figuras', accesories: 'accesorios'};

  return <main className="search">
    <hgroup style={{backgroundColor: 'green', gridColumn: 'span 2'}}>
      <h2 className="search__title">{`Mostrando productos para: ${product[params.product] ?? params.product}`}</h2>
      <p>1-9 productos</p>
    </hgroup>
    <form style={{gridColumn: '4', justifySelf: 'end'}}>
      <search>
        <label>Ordenar por: </label>
        <select name='filter' onChange={({target: {value}}) => console.log(value)}>
          <optgroup label='nombre'>
            <option value={'/ordered-by-name-des'}>descendente</option>
            <option value={'/ordered-by-name-asc'}>ascendente</option>
          </optgroup>
          <optgroup label='precio'>
            <option value={'/low-to-high'}>ascendente</option>
            <option value={'/high-to-low'}>descendente</option>
          </optgroup>
        </select>
      </search>
    </form>
  </main>
}
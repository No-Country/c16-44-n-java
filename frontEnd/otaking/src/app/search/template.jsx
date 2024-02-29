'use client'
import './template.css'

export default function SearchLayOut({children}) {
  return <main className="search">
    <hgroup style={{backgroundColor: 'green', gridColumn: 'span 2'}}>
      <h2 className="search__title">Mostrando productos para: [producto]</h2>
      <p>1-9 productos</p>
    </hgroup>
    <form style={{gridColumn: '4', justifySelf: 'end'}}>
      <search>
        <h3>Ordenar por:</h3>
        <select>
          <option>nombre descendente</option>
          <option>nombre ascendente</option>
          <option>precio descendente</option>
          <option>precio ascendente</option>
        </select>
      </search>
    </form>

    {children}
  </main>
}
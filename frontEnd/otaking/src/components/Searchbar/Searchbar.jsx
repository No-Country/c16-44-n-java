import { useState } from "react"
import './Searchbar.css'

export default function Searchbar() {
  const [input, setInput] = useState('')

  function onChange(e) {
    setInput(e.target.value.toLowerCase())
  }

  return <form className="search">
    <input 
      className="search__bar"
      type="text" 
      onChange={onChange} 
      placeholder="Búsqueda" 
      required
      minLength={1}
      value={input}
    />
    <button className="search__btn" type="submit"/>
  </form>
}
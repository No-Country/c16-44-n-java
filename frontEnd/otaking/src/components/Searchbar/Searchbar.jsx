import { useState } from "react"
import './Searchbar.css'

export default function Searchbar() {
  const [input, setInput] = useState('')

  function onChange(e) {
    setInput(e.target.value.toLowerCase())
  }

  return <form className="search-form">
    <input 
      className="search-form__bar"
      type="search" 
      onChange={onChange} 
      placeholder="Búsqueda" 
      required
      minLength={1}
      value={input}
    />
    <button className="search-form__btn" type="submit"/>
  </form>
}
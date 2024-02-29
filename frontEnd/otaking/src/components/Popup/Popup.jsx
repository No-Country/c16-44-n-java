'use client'
import './Popup.css'

export default function Popup({children, isOpen}) {
  return <div className={`popup${isOpen ? ' popup_open' : ''}`} inert={!isOpen} >
    {children}
  </div>
}
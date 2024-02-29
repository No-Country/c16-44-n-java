'use client'
import Popup from '../Popup'
import './PopupWithForm.css'

export default function PopupWithForm({isOpen, children, title}) {
  return <Popup isOpen={isOpen}>
    <form className={`form`}>
      <h3 className="form__title">{title}</h3>
      <fieldset>
        {children}
      </fieldset>
      <menu className='form__menu'>
        <button type='submit' className='form__btn form__btn_type_sbm'>{title}</button>
        <button type='button' className='form__btn form__btn_type_cl'>Cancel</button>
      </menu>
    </form>
  </Popup>
}
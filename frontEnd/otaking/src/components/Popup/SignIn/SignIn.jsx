
'use client'
import { useGlobalContext } from "@/context/store";
import PopupWithForm from "../PopupWithForm/PopupWithForm";

export default function SignIn() {
  const { popups: {signIn}} = useGlobalContext();

  return <PopupWithForm isOpen={signIn} title={'Iniciar sesión'}>
    <input className='form__item' type='email' name='email' placeholder='Correo' required />
    <input className='form__item' type='password' name='password' placeholder='Contraseña' required />
  </PopupWithForm>
}
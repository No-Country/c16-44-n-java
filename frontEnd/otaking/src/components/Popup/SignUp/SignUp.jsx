'use client';
import PopupWithForm from '../PopupWithForm/PopupWithForm';
import { useGlobalContext } from '@/context/store';

export default function SignUp() {
  const { popups: {signUp}} = useGlobalContext();

  return <PopupWithForm isOpen={signUp} title={'Registrarse'} >
    <input className='form__item' type='email' name='email' placeholder='Correo' required />
    <input className='form__item' type='password' name='password' placeholder='Contraseña' required />
    <input className='form__item' type='password' name='confirmPass' placeholder='Confirmar contraseña' required />
  </PopupWithForm>
}
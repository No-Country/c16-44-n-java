'use client';
import useForm from '@/hooks/useForm';
import PopupWithForm from '../PopupWithForm/PopupWithForm';
import { useGlobalContext } from '@/context/store';
import { postUser } from '@/utils/apiClient';

export default function SignUp() {
  const title = 'Registrarse'
  const { popups: {signUp}} = useGlobalContext();
  const {inputs: {
      name,
      lastName,
      email,
      address,
      password,
      confirmPass,
    },
    handleChange,
    getValues,
  } = useForm(title)

  function handleSubmit() {
    const values = getValues()
    if(values.password !== values.confirmPass) return
    
    const format = {...values, userType: {id: +values.userType, userType: values.rol}}

    postUser(format)
  }

  return <PopupWithForm isOpen={signUp} title={title} onSubmit={handleSubmit} >
    <input onChange={handleChange} value={name?.value ?? ''} className='form__item' type='text' name='name' placeholder='Nombre' required />
    <input onChange={handleChange} value={lastName?.value ?? ''} className='form__item' type='text' name='lastName' placeholder='Apellido' required />
    <div style={{display: 'flex', justifyContent: 'space-evenly'}}>
      <label >Comprador <input value='1' name='userType' type='radio'/></label>
      <label >Vendedor <input value='3' name='userType' type='radio' /></label>
    </div>
    <input onChange={handleChange} value={email?.value ?? ''} className='form__item' type='email' name='email' placeholder='Correo' required />
    <input onChange={handleChange} value={address?.value ?? ''} className='form__item' type='text' name='address' placeholder='Dirección' required />
    <input onChange={handleChange} value={password?.value ?? ''} className='form__item' type='password' name='password' placeholder='Contraseña' required />
    <input onChange={handleChange} value={confirmPass?.value ?? ''} className='form__item' type='password' name='confirmPass' placeholder='Confirmar contraseña' required />
    <span className='form__err'>{}</span>
  </PopupWithForm>
}
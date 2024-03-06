'use client'
import { useGlobalContext } from "@/context/store";
import PopupWithForm from "../PopupWithForm/PopupWithForm";
import useForm from "@/hooks/useForm";
import { login } from "@/utils/apiClient";

export default function SignIn() {
  const {setUser} = useGlobalContext()
  const { popups: {signIn}, closeAllPopups} = useGlobalContext();
  const {inputs: {
    email,
    password,
  },
  handleChange,
  getValues,
  } = useForm('Iniciar sesión');

  function handleSubmit() {
    login(getValues()).then(setUser).then(closeAllPopups)
  }

  return <PopupWithForm isOpen={signIn} title={'Iniciar sesión'} onSubmit={handleSubmit}>
    <input defaultValue={email?.value} onChange={handleChange} className='form__item' type='email' name='email' placeholder='Correo' required />
    <input defaultValue={password?.value} onChange={handleChange} className='form__item' type='password' name='password' placeholder='Contraseña' required />
  </PopupWithForm>
}
'use client';
import { createContext, useContext, useEffect, useState } from "react";
import usePopup from '../hooks/usePopup.js';

const GlobalContext = createContext({})

export const GlobalContextProvider = ({children}) => {
  const [popups, openPopup, closeAllPopups] = usePopup('signIn', 'signUp', 'cart');
  const [user, setUser] = useState(null)
  const [cart, setCart] = useState([])

  useEffect(() => {
    const user = localStorage.getItem('user')
    setUser(() => user ? JSON.parse(user) : null)
  }, [])

  return <GlobalContext.Provider value={{
    popups, 
    openPopup, 
    closeAllPopups, 
    user, 
    setUser,
    cart,
    setCart,
  }}>
    {children}
  </GlobalContext.Provider>
}

export const useGlobalContext = () => useContext(GlobalContext)
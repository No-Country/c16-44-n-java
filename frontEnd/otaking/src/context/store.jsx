'use client';
import { createContext, useContext, useState } from "react";
import usePopup from '../hooks/usePopup.js';

const GlobalContext = createContext({})

export const GlobalContextProvider = ({children}) => {
  const [popups, openPopup, closeAllPopups] = usePopup('signIn', 'signUp');
  const [user, setUser] = useState(()=> {
    const user = localStorage.getItem('user')
    return user ? JSON.parse(user) : null
  })

  return <GlobalContext.Provider value={{
    popups, 
    openPopup, 
    closeAllPopups, 
    user, 
    setUser,
  }}>
    {children}
  </GlobalContext.Provider>
}

export const useGlobalContext = () => useContext(GlobalContext)
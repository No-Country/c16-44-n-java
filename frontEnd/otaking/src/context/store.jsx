'use client';
import { createContext, useContext, useState } from "react";
import usePopup from '../hooks/usePopup.js';

const GlobalContext = createContext({})

export const GlobalContextProvider = ({children}) => {
  const [popups, openPopup, closeAllPopups] = usePopup('signIn', 'signUp');

  return <GlobalContext.Provider value={{popups, openPopup, closeAllPopups}}>
    {children}
  </GlobalContext.Provider>
}

export const useGlobalContext = () => useContext(GlobalContext)
'use client'

import { useState, useCallback, useEffect, useRef } from "react";

export default function usePopup(...theModals) {
  const
    settedFalse = useRef(Object.fromEntries(theModals.map(key => [key, false]))),
    [modals, setModalOpen] = useState(settedFalse.current),

    openModal = useCallback(function (modal) {
      setModalOpen((state) => {
        if (!state.hasOwnProperty(modal)) {
          throw new Error(`Typed wrong the argument "${modal}" for openModal name.`)
        }

        return {...state, [modal]: true}
      })
    }, []),

    closeAllModals = useCallback(function () {
      setModalOpen(settedFalse.current)
    }, []);

  useEffect(() => {
    const hasOpened = Object
      .values(modals)
      .some(Boolean);

    function handleListenerClose(e) {
      const
        hasClicked = ['popup_open']
          .some(click => e.target.classList.contains(click)),
        escPressed = e.key === 'Escape';

      if (hasClicked || escPressed) closeAllModals()
    }

    if(hasOpened) {
      document.addEventListener('click', handleListenerClose)
      document.addEventListener('keydown', handleListenerClose)
    }

    return () => {
      document.removeEventListener('keydown', handleListenerClose)
      document.removeEventListener('click', handleListenerClose)
    }
  }, [modals, closeAllModals])

  return [
    modals,
    openModal,
    closeAllModals,
  ]
}
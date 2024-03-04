'use client'
import './Header.css';
import crown from '../../../public/crown.svg';
import Image from 'next/image';
import Searchbar from '../Searchbar/Searchbar';
import { useState } from 'react';
import { useGlobalContext } from '@/context/store';
import Link from 'next/link';

export default function Header() {
  const [userMenu, setUserMenu] = useState(false);
  const [cataloge, setCataloge] = useState(false)
  const { openPopup, user, setUser } = useGlobalContext(); 

  function handleMenuUserBtn(e) {
    openPopup(e.target.dataset.popup);
  }

  return (
    <header className='header'>
      <div className='header__wrapper'>
        <Link href={'/'} className='logo'>
          <Image className='logo__crown' src={crown} alt="crown" />
          <h1 className='logo__title'>Otaking</h1>
        </Link>
        <button className='header__menu' onClick={() => setCataloge(!cataloge)}>Catálogo&nbsp;
          <img className='header__arrow' src='/bxs--down-arrow.svg' alt='down-arrow' />
        </button>
        <Searchbar />
      </div>
      <div className="header__user">
        <button className='header__btn-cart' data-popup='cart' onClick={handleMenuUserBtn} />
        {user ? 
          <button className='header__btn-perfil' onClick={() => setUserMenu(!userMenu)}>¡Hola {user.name}!</button> :
          <button className='header__btn-user' onClick={() => setUserMenu(!userMenu)}></button>
        }
      </div>
      <menu className={`header__menu-user menu${userMenu ? ' menu_open' : ''}`}>
        <ul className='menu__list' onClick={() => setUserMenu(false)}>
          {user ?
            <>
              <li><Link href='/sell' className='menu__item' >Vender</Link></li>
              <li><button className='menu__item' onClick={() => setUser(() => (localStorage.clear(), null))}>Salir</button></li>
            </> :
            <>
              <li><button className='menu__item' data-popup='signIn' onClick={handleMenuUserBtn}>Iniciar sesión</button></li>
              <li><button className='menu__item' data-popup='signUp' onClick={handleMenuUserBtn}>Registrarse</button></li>
            </>
          }
        </ul>
      </menu>
      <menu className={`header__menu-cataloge menu${cataloge ? ' menu_open' : ''}`}>
        <ul className='menu__list' onClick={() => setCataloge(false)}>
          <li><Link href={`/search/all`} className='menu__item' >Todo</Link></li>
        </ul>
      </menu>
    </header>
  )
}
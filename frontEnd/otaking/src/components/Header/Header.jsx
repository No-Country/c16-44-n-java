'use client'
import './Header.css';
import crown from '../../../public/crown.svg';
import Image from 'next/image';
import Searchbar from '../Searchbar/Searchbar';
import { useState } from 'react';

export default function Header() {
  const [userMenu, setUserMenu] = useState(false);

  return (
    <header className='header'>
      <div className='header__wrapper'>
        <div className='logo'>
          <Image className='logo__crown' src={crown} alt="crown" />
          <h1 className='logo__title'>Otaking</h1>
        </div>
        <button className='header__menu'>Catálogo&nbsp;
          <img className='header__arrow' src='/bxs--down-arrow.svg' alt='down-arrow' />
        </button>
        <Searchbar />
      </div>
      <div className="header__user">
        <button className='header__btn-cart'></button>
        <button className='header__btn-user' onClick={() => setUserMenu(!userMenu)}></button>
      </div>
      <menu className={`header__menu-user menu${userMenu ? ' menu_open' : ''}`}>
        <ul className='menu__list'>
          <li className='menu__item'>Iniciar sesión</li>
          <li className='menu__item'>Registrarse</li>
        </ul>
      </menu>
    </header>
  )
}
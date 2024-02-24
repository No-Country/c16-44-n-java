import './Header.css';
import crown from '../../../public/crown.svg';
import Image from 'next/image';
import Searchbar from '../Searchbar/Searchbar';

export default function Header() {
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
        <button className='btn_cart'></button>
        <button className='btn_user'></button>
      </div>
    </header>
  )
}
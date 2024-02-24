import Link from "next/link";
import './NavCategory.css';

export default function NavCategory() {
  const links = [
    {name: 'Manga', href: '/category/manga'}, 
    {name: 'Indumentaria', href: '/category/fabric'}, 
    {name: 'Accesorios', href: '/category/accesories'}, 
    {name: 'Figuras', href: '/category/figure'},
  ];

  return <article className="nav-category">
    <h2 className="nav-category__title">Categorías</h2>
    <nav className="nav-category__list">
      {
        links.map((link) => 
          <li className={`nav-category__item nav-category__item_name_${link.name.toLowerCase()}`} key={link.name}>
            <Link href={link.href} className="nav-category__link">{link.name}</Link>
          </li>
        )
      }
    </nav>
  </article>
}
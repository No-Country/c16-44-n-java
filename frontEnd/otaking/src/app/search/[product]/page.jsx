'use client'
import React, { useState, useEffect } from 'react';
import './page.css'
import ProductCard from "@/components/ProductCard/ProductCard";
import { getCategoryDes, getCategoryAsc, getCategoryHigh, getCategoryLow } from '@/utils/apiClient';

export default function Product({ params }) {
  const product = { fabric: 'indumentaria', figure: 'figuras', accesories: 'accesorios' };

  const [items, setItems] = useState([]);

  const fetchData = async () => {
    switch (params.order) {
      case 'ordered-by-name-asc':
        getCategoryAsc;
        break;
      case 'ordered-by-name-des':
        getCategoryDes;
        break;
      case 'low-to-high':
        getCategoryHigh;
        break;
      case 'high-to-low':
        getCategoryLow;
        break;
    }

    try {
      const response = await fetch(url, { headers });
      const data = await response.json();
      setItems(data); // Actualiza el estado con los datos recibidos
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  };

  useEffect(() => {
    const testItems = [
      { name: 'Camiseta', price: 19.99 },
      { name: 'Pantalón', price: 29.99 },
      { name: 'Zapatos', price: 39.99 },
      { name: 'Bufanda', price: 9.99 },
      { name: 'Gorra', price: 14.99 },
      { name: 'Calcetines', price: 4.99 },
      { name: 'Pulsera', price: 7.99 },
      { name: 'Reloj', price: 49.99 },
      { name: 'Bolso', price: 59.99 },
    ];
    setItems(testItems);
    fetchData();
  }, [params.order]);

return (
  <>
    <main>
      <div className='search'>
        <hgroup style={{ backgroundColor: 'green', gridColumn: 'span 2' }}>
          <h2 className="search__title">{`Mostrando productos para: ${product[params.product] ?? params.product}`}</h2>
          <p>1-9 productos</p>
        </hgroup>
      </div>
      <div className="products__grid">
        {items.slice(0, 9).map((item, index) => (
          <ProductCard key={index} {...item} />
        ))}
      </div>
      {/* {items.slice(0, 9).map((item) => {
            return (<ProductCard key={item.id} {...item} />)
          })}
        </div> */}
      {/* <div className='products__grid'>
          {options.map((options, i) => {
            return (<ProductCard key={i.id} {...options} />)
          })}
        </div> */}
    </main>
  </>
)
}
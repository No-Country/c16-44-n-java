import React from 'react';
import '@/components/Showcase/Showcase.css';
import ProductCard from "@/components/ProductCard/ProductCard";

export const Showcase = ({name_category}) => {

    const cantProducts = [...Array(8)]
    const product = {id: 1, name: 'kakashi', price: 1200, image_url: '/images/books.jpg'}
    return (
        <>
            <div className='showcase__container'>
                <h2 className='lines-effect'>{name_category}</h2>
            </div>
            <div className="products__grid">
                {cantProducts.map((_,i) => {
                    return (<ProductCard key={i} id={product.id} name={product.name} 
                    price={product.price} image_url={product.image_url}
                    /> )
                })}
            </div>
            {/* armar el "ver mas" */}

        </>
    )
}

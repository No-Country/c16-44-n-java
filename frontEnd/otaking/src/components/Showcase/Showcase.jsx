import React from 'react';
import '@/components/Showcase/Showcase.css';
import ProductCard from "@/components/ProductCard/ProductCard";

export const Showcase = ({name_category, items}) => {
    return (
        <>
            <div className='showcase__container'>
                <h2 className='lines-effect'>{name_category}</h2>
            </div>
            <div className="products__grid">
                {items.slice(0, 9).map((item) => {
                    return (<ProductCard key={item.id} {...item}/> )
                })}
            </div>
            {/* armar el "ver mas" */}

        </>
    )
}

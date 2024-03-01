import React from 'react'
import '@/components/ProductCard/ProductCard.css'

const ProductCard = () => {
    return (
        <div className='product-card'>
            <div className='product-card__top'>
                {/* img */}
                <img src='/images/figures.jpg' className='product-card__img'></img>
            </div>
            <div className="product-card__bottom">
                {/* name, price */}
                <p className='product-card__name'>Figura Dupla</p>
                <p className='product-card__price'>$15,000</p>
            </div>
        </div>
    )
}

export default ProductCard
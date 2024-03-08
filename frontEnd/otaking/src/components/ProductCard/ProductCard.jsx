"use client"
import Link from 'next/link'
import React from 'react'
import '@/components/ProductCard/ProductCard.css'

const ProductCard = ({ id, name, price, mainImage }) => {
    let default_img = '../images/camara.jpg'
    return (
        <div className='product-card'>
            <div className='product-card__top'>
                <Link href={{
                    pathname: '/item',
                    query: {
                        id
                    }
                }}>
                    <img src={default_img} className='product-card__img'></img> 
                </Link>
            </div>
            <div className="product-card__bottom">
                <p className='product-card__name'>{name}</p>
                <p className='product-card__price'>${price}</p>
            </div>
        </div>
    )
}
export default ProductCard
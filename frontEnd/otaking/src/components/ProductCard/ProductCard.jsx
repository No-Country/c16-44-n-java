"use client"
import Link from 'next/link'
import React from 'react'
import '@/components/ProductCard/ProductCard.css'

const ProductCard = ({ id, name, price, image_url }) => {
    return (
        <div className='product-card'>
            <div className='product-card__top'>
                <Link href={`/v1/product/search/${id}`}>
                    <img src={image_url} className='product-card__img'></img> 
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
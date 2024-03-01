import React from 'react'
import '@/components/ProductCard/ProductCard.css'

const ProductCard = () => {
    return (
        <div className='container_product_card'>
            <div className='product_card'>
                <div className='top_card'>
                    {/* img */}
                    <img src='/images/figures.jpg' className='product_img'></img>
                </div>
                <div className="bottom_card">
                    {/* name, price */}
                    <span className='product_name'>Figura Dupla</span>
                    <span className='product_price'>$15,000</span>
                </div>
            </div>
        </div>
    )
}

export default ProductCard
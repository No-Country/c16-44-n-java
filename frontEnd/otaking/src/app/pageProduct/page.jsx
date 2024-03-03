import React from 'react'
import '@/app/pageProduct/page.css'

export const Product = (id, name, price, description, category,
    brand, image_url, user) => {
    return (<main>
        <div className="container">
            <div className="columns-container">
                <div className="size-columns">
                    <div className="product-images-block">
                        <div className="thumbnail-container">
                            <img src={image_url}/>
                        </div>
                        <div class="thumbnail-container thumbnail">
                            <img src={image_url}/>
                            <img src={image_url}/>
                            <img src={image_url}/>
                        </div>
                    </div>
                </div>
                <div className="size-columns">
                    <h1 className="title">{name}</h1>
                    <div className="product-description-block">
                        <div className="description">
                            <h3 className="label">Descripcion</h3>
                            <p>{description}</p>
                        </div>
                    <div className="size-columns">
                    <div className="encuadre">
                            <p>{brand}</p>
                            <p>{category}</p> 
                            <p>{user}</p>    
                        </div>
                    </div>
                       
                    </div>
                    <div className="product-description-block">
                        <h3>Precio final:</h3>
                        <h2 class="title">${price}</h2>
                    </div>
                    <div className="product-description-block">
                        <form className="selector">
                        <label className="label" for="cant">Cantidad</label>
                            <div className="encuadre">
                                
                                <fieldset>
                                    <input className="input-number" type="number">
                                    </input>
                                </fieldset>
                                <button className="button-style">Añadir al carrito</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </main>
    )
}
export default Product;
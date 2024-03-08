import '@/app/item/page.css'
import { getProduct } from '@/utils/apiClient'
import AddItem from './AddItem'

// id, name, price, description, category, brand, image_url, user

export const Item = async ({searchParams}) => {
    const {
        name, 
        brand, 
        category, 
        user, 
        price, 
        description, 
        mainImage, 
        images,
    } = await getProduct(searchParams.id)

    return (<main>
        <div className="container">
            <div className="columns-container">
                <div className="size-columns">
                    <div className="product-images-block">
                        <div className="thumbnail-container">
                            <img src={mainImage?.url}/>
                        </div>
                        <div className="thumbnail-container thumbnail">
                            <img src={images[0]?.url}/>
                            <img src={images[1]?.url}/>
                            <img src={images[2]?.url}/>
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
                            <p>{user?.name}</p>    
                        </div>
                    </div>
                       
                    </div>
                    <div className="product-description-block">
                        <h3>Precio final:</h3>
                        <h2 className="title">${price}</h2>
                    </div>
                    <div className="product-description-block">
                        <AddItem productId={searchParams.id} name={name} price={price} />
                    </div>
                </div>
            </div>
        </div>
    </main>
    )
}
export default Item;
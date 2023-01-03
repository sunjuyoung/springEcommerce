import React from 'react'
import { Link } from 'react-router-dom';
import "./Card.scss";

const Card = ({item}) => {

  return (
    <Link to={`/product/${item.id}`} style={{textDecorationLine:'none'}}>
        <div className='card'>
            <div className="image">
                {item.isNew && <span>New Season</span>}
                <img src={item.img} alt=""  className='mainImage'/>
                <img src={item.img2} alt=""  className='secondImage'/>
            </div>
            <h2>{item.title}</h2>
            <div className="prices">
                <h3>{item.price}</h3>
                <h3>{item.oldPrice}</h3>
                <h3>{item.per} %</h3>
            </div>
        </div>
    </Link>
  )
}

export default Card
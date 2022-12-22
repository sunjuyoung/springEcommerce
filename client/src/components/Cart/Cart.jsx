import React, { useState } from 'react'
import "./Cart.scss";
import DeleteOutlinedIcon from "@mui/icons-material/DeleteOutlined";

const Cart = () => {
  
  
    const data = [    
        {
            id:1,
            img:"https://images.pexels.com/photos/1972115/pexels-photo-1972115.jpeg?auto=compress&cs=tinysrgb&w=1600",
            img2:"https://images.pexels.com/photos/1163194/pexels-photo-1163194.jpeg?auto=compress&cs=tinysrgb&w=1600",
            title:"inner",
            description:"description descriptiondescriptiondescriptiondescription...descriptiondescriptiondescription",
            oldPrice:300,
            price:200,
            isNew:true,
            per:10
        },
                {
            id:2,
            img:"https://images.pexels.com/photos/1972115/pexels-photo-1972115.jpeg?auto=compress&cs=tinysrgb&w=1600",
            img2:"https://images.pexels.com/photos/1163194/pexels-photo-1163194.jpeg?auto=compress&cs=tinysrgb&w=1600",
            title:"inner",
            description:"description descriptiondescriptiondescriptiondescription...descriptiondescriptiondescription",
            oldPrice:300,
            price:200,
            isNew:true,
            per:10
        }
    ]      

  return (
    <div className="cart">
    <h1>장바구니</h1>
    {data?.map((item) => (
      <div className="item" key={item.id}>
        <img src={item.img} alt="" />
        <div className="details">
          <h1>{item.title}</h1>
          <p>{item.desc?.substring(0, 100)}</p>

          <div className="price">
            {item.quantity} x ${item.price}
          </div>
        </div>


        <div className="item_total">
          <span>10000</span>
        </div>


        <DeleteOutlinedIcon
          className="delete"
        />
      </div>
    ))}
    <div className="total">
      <span>SUBTOTAL</span>
      <span>10000</span>
    </div>
    <button>PROCEED TO CHECKOUT</button>
    <span className="reset">
      Reset Cart
    </span>
  </div>
  )
}

export default Cart
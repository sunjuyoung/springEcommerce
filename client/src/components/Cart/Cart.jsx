import React, { useState } from 'react'
import "./Cart.scss";
import DeleteOutlinedIcon from "@mui/icons-material/DeleteOutlined";
import { useDispatch, useSelector } from 'react-redux';
import { removeItem, selectCart,resetCart } from '../../redux/cartReducer';

const Cart = () => {
  const products = useSelector(selectCart);
  const dispatch = useDispatch();

  return (
    <div className="cart">
    <h1>장바구니</h1>
    {products?.map((item) => (
      <div className="item" key={item.id}>
        <img src="https://images.pexels.com/photos/1972115/pexels-photo-1972115.jpeg?auto=compress&cs=tinysrgb&w=1600" alt="" />
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
          onClick={()=>dispatch(removeItem({
            id:item.id
          }))}
        />
   
      </div>
    ))}
    <div className="total">
      <span>SUBTOTAL</span>
      <span>10000</span>
    </div>
    <button>PROCEED TO CHECKOUT</button>
    <span className="reset" onClick={()=>dispatch(resetCart())}>
      Reset Cart
    </span>
  </div>
  )
}

export default Cart
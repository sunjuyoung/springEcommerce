import React, { useState } from 'react'
import "./Cart.scss";
import DeleteOutlinedIcon from "@mui/icons-material/DeleteOutlined";
import { useDispatch, useSelector } from 'react-redux';
import { removeItem, selectCart,resetCart,plusCartItem,minusCartItem } from '../../redux/cartReducer';

const Cart = () => {
  const products = useSelector(selectCart);
  const dispatch = useDispatch();

  const totalPrice = () =>{
    let total = 0;
    products.forEach((item)=> total+= item.quantity * item.price);
    return total;
  }

  return (
    <div className="cart">
    <h1>장바구니</h1>
    {products?.map((item) => (
      <div className="item" key={item.id}>
        <img src="https://images.pexels.com/photos/1972115/pexels-photo-1972115.jpeg?auto=compress&cs=tinysrgb&w=1600" alt="" />
        <div className="details">
          <h1>{item.title}</h1>
          <p>{item.desc?.substring(0, 100)}</p>

          <div className="quantity">
            <button onClick={()=>dispatch(minusCartItem({id:item.id}))}>-</button>
              {item.quantity}
              <button onClick={()=>dispatch(plusCartItem({id:item.id}))}>+</button>
          </div>
        </div>

        <div className="item_total">
          <span>{item.quantity * item.price}원</span>
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
      <span>{totalPrice()}원</span>
    </div>
    <button>PROCEED TO CHECKOUT</button>
    <span className="reset" onClick={()=>dispatch(resetCart())}>
      Reset Cart
    </span>
  </div>
  )
}

export default Cart
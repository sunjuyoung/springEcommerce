import React, { useState } from 'react'
import './Product.scss';
import AddShoppingCartIcon from "@mui/icons-material/AddShoppingCart";
import FavoriteBorderIcon from "@mui/icons-material/FavoriteBorder";
import BalanceIcon from "@mui/icons-material/Balance";

const Product = () => {

  const [selectedImg, setSelectedImg] = useState(0);

  const data = 
    {
        id:1,
        img:"https://images.pexels.com/photos/1972115/pexels-photo-1972115.jpeg?auto=compress&cs=tinysrgb&w=1600",
        img2:"https://images.pexels.com/photos/1163194/pexels-photo-1163194.jpeg?auto=compress&cs=tinysrgb&w=1600",
        title:"inner",
        oldPrice:300,
        price:200,
        isNew:true,
        per:10
    }
    const images = [
      "https://images.pexels.com/photos/1972115/pexels-photo-1972115.jpeg?auto=compress&cs=tinysrgb&w=1600",
      "https://images.pexels.com/photos/1163194/pexels-photo-1163194.jpeg?auto=compress&cs=tinysrgb&w=1600"
    ]


  return (
    <div className='product'>
       <div className="left">
            <div className="images">
              <img
                src={images[0]}
                alt=""
               onClick={e=>setSelectedImg(0)}
              />
              <img
                src={images[1]}
                alt=""
                onClick={e=>setSelectedImg(1)}
              />
            </div>
            <div className="mainImg">
              <img
                src={images[selectedImg]}
                alt=""
              />
            </div>
          </div>
          <div className="right">
            <h1>터틀넥티셔츠</h1>
            <hr></hr>
            <span className="price">1000</span>
            <p>{data?.attributes?.desc}</p>
            <div className="quantity">
              <button
              >
                -
              </button>
              1
              <button>+</button>
            </div>
            <button
              className="add"
            >
              <AddShoppingCartIcon /> ADD TO CART
            </button>
            <div className="links">
              <div className="item">
                <FavoriteBorderIcon /> ADD TO WISH LIST
              </div>
              <div className="item">
                <BalanceIcon /> ADD TO COMPARE
              </div>
            </div>
            <div className="info">
              <span>Vendor: Polo</span>
              <span>Product Type: T-Shirt</span>
              <span>Tag: T-Shirt, Women, Top</span>
            </div>
            <hr />
            <div className="info">
              <span>DESCRIPTION</span>
              <hr />
              <span>ADDITIONAL INFORMATION</span>
              <hr />
              <span>FAQ</span>
            </div>
          </div>
    </div>
  )
}

export default Product
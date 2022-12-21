import React, { useState } from 'react'
import { useParams } from 'react-router-dom';
import List from '../../components/List/List';
import './Products.scss';

const Products = () => {


  const catId =  parseInt(useParams().id);
  const [maxPrice, setMaxPrice] = useState(1000)
  const [sort, setSort] = useState(null)
  console.log(sort);

  console.log(maxPrice)
  return (
    <div className='products'>
        <div className="left">
          {/* categories */}
          <div className="fillterItem">
            <h2>Product Categories</h2>
            <div className="inputItem">
              <input type="checkbox" name="1" id="1" value={1} />
              <label htmlFor='1'>Shirt</label>
            </div>
            <div className="inputItem">
              <input type="checkbox" name="2" id="2" value={2} />
              <label htmlFor='2'>Pants</label>
            </div>
            <div className="inputItem">
              <input type="checkbox" name="3" id="3" value={3} />
              <label htmlFor='3'>etc</label>
            </div>
          </div>
          {/* price */}
          <div className="fillterItem">
          <h2>filter By price</h2>
          <div className="inputItem">
            <span>0</span>
            <input type="range" name="" id="" min={0} max={1000} onChange={(e)=> setMaxPrice(e.target.value)} />
            <span>{maxPrice}</span>
          </div>
          </div>
          {/* sort */}
          <div className="fillterItem">
            <h2>sort by</h2>
            <div className="inputItem">
              <input type="radio" name="price" id="pop" value="pop" onChange={e=>setSort("pop")} />
              <label htmlFor='pop'>판매 인기순</label>
            </div>
            <div className="inputItem">
              <input type="radio" name="price" id="desc" value="desc" onChange={e=>setSort("desc")} />
              <label htmlFor='desc'>높은 가격순</label>
            </div>
            <div className="inputItem">
              <input type="radio" name="price" id="asc" value="asc" onChange={e=>setSort("asc")} />
              <label htmlFor='asc'>낮은 가격순</label>
            </div>
            <div className="inputItem">
              <input type="radio" name="price" id="new" value="new" onChange={e=>setSort("new")} />
              <label htmlFor='desc'>신상품순</label>
            </div>
          </div>
        </div>
        {/* right */}
        <div className="right">
          <img className='catImg'
          src="https://images.pexels.com/photos/1074535/pexels-photo-1074535.jpeg?auto=compress&cs=tinysrgb&w=1600" 
          alt="" />
          <List catId={catId} maxPrice={maxPrice} sort={sort}/>
        </div>
    </div>
  )
}

export default Products
import React, { useState } from 'react'
import KeyboardArrowDownIcon from '@mui/icons-material/KeyboardArrowDown';
import SearchIcon from '@mui/icons-material/Search';
import PersonOutlineIcon from '@mui/icons-material/PersonOutline';
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import ShoppingCartOutlinedIcon from '@mui/icons-material/ShoppingCartOutlined';
import {
Link
  } from "react-router-dom";
import './Navbar.scss'
import Cart from '../Cart/Cart';
import { useSelector } from 'react-redux';
import { selectCart } from '../../redux/cartReducer';

const Navbar = () => {
    const products = useSelector(selectCart);
  return (
    <div className='navbar'>
        <div className='wrapper'>
            <div className='left'>

                <div className="item">
                    <img src='/img/ko.png' alt='' />
                    <KeyboardArrowDownIcon />
                </div>

                <div className='item'>
                    <span>Ko</span>
                    <KeyboardArrowDownIcon />
                </div>

                <div className='item'>
                    <Link className='link' to="/products/1">Women</Link>
                </div>
                <div className='item'>
                    <Link className='link' to="/products/2">Men</Link>
                </div>
                <div className='item'>
                    <Link className='link' to="/products/3">Children</Link>
                </div>

            </div>
            {/* left end */}
            <div className='center'>
                <Link to="/">JAVA STORE</Link>
            </div>

            <div className='right'>

            <div className='item'>
                <Link className='link' to="/">Hompage</Link>
            </div>
            <div className='item'>
                <Link className='link' to="/">About</Link>
            </div>
            <div className='item'>
                <Link className='link' to="/">Contact</Link>
            </div>
            <div className='item'>
                <Link className='link' to="/">Stores</Link>
            </div>
            <div className='icons'>
                <SearchIcon />
                <PersonOutlineIcon />
                <FavoriteBorderIcon />
                <div className='cartIcon'>
                    <Link className='link' to="/cart/1">
                        <ShoppingCartOutlinedIcon />
                        <span>{products.length}</span>
                    </Link>
                </div>
            </div>

            </div>
        </div>
    
    </div>
  )
}

export default Navbar
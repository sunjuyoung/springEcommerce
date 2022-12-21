import React, { useState } from 'react'
import ArrowBackOutlinedIcon from '@mui/icons-material/ArrowBackOutlined';
import ArrowForwardOutlinedIcon from '@mui/icons-material/ArrowForwardOutlined';
import './Slider.scss';

const Slider = () => {

    const [currentSlide, setCurrentSlide] = useState(0);

    const data = [
       {
        id:1,
        img:"slide1.jpg"
       },
       {
        id:2,
        img:"slide2.jpg"
       },
       {
        id:3,
        img:"slide3.jpg"
       },
    ]
    const prevSlide = () =>{
        setCurrentSlide(currentSlide == 0? 2 : (prev)=>prev-1)
    }
    const nextSlide = () =>{
        setCurrentSlide(currentSlide == 2? 0 : (prev)=>prev+1)
    }

  return (
    <div className='slider'>
        <div className="container" style={{transform: `translateX(-${currentSlide * 100}vw)`}}>
            {data?.map(item=>(
                <img src={`${process.env.PUBLIC_URL}/img/${item.img}`} alt="" key={item.id}/>
            ))}
            {/* <img src={data[0]} alt="" />
            <img src={data[1]} alt="" />
            <img src={data[2]} alt="" /> */}
        </div>
        <div className="icons">
            <div className="icon" onClick={prevSlide}>
                <ArrowBackOutlinedIcon />
            </div>
            <div className="icon" onClick={nextSlide}>
                <ArrowForwardOutlinedIcon />
            </div>
        </div>
    </div>
  )
}

export default Slider
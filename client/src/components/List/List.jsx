import React from 'react'
import Card from '../Card/Card';
import "./List.scss";

const List = () => {

    
    const data = [
        {
            id:1,
            img:"https://images.pexels.com/photos/1972115/pexels-photo-1972115.jpeg?auto=compress&cs=tinysrgb&w=1600",
            img2:"https://images.pexels.com/photos/1163194/pexels-photo-1163194.jpeg?auto=compress&cs=tinysrgb&w=1600",
            title:"inner",
            oldPrice:300,
            price:200,
            isNew:true,
            per:10
        },
        {
            id:2,
            img:"https://images.pexels.com/photos/1972115/pexels-photo-1972115.jpeg?auto=compress&cs=tinysrgb&w=1600",
            img2:"https://images.pexels.com/photos/1163194/pexels-photo-1163194.jpeg?auto=compress&cs=tinysrgb&w=1600",
            title:"outer",
            oldPrice:300,
            price:200,
            per:10
        },
        {
            id:3,
            img:"https://images.pexels.com/photos/2065200/pexels-photo-2065200.jpeg?auto=compress&cs=tinysrgb&w=1600",
            title:"bottom",
            oldPrice:300,
            price:200,
            per:10
        },
        {
            id:4,
            img:"https://images.pexels.com/photos/1972115/pexels-photo-1972115.jpeg?auto=compress&cs=tinysrgb&w=1600",
            title:"etc",
            oldPrice:300,
            price:200,
            per:10
        },
        {
            id:5,
            img:"https://images.pexels.com/photos/1972115/pexels-photo-1972115.jpeg?auto=compress&cs=tinysrgb&w=1600",
            title:"etc",
            oldPrice:300,
            price:200,
            per:10
        },
    ]

  return (
    <div className='list'>
        {data?.map(item=>(
            <Card item={item} key={item.id} ></Card>
        ))}
    </div>
  )
}

export default List
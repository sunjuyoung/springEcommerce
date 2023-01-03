import { createSlice } from '@reduxjs/toolkit'

const initialState = {
  products: [],
}

export const cartSlice = createSlice({
  name: 'cart',
  initialState,
  reducers: {
    addToCart: (state,action) => {
        const item = state.products.find(item=>item.id === action.payload.id)
        if(item){
            item.quantity += action.payload.quantity;
        }else{
            state.products.push(action.payload);
        }
    },
    removeItem: (state,action) => {
      state.products = state.products.filter(item=> item.id !== action.payload.id)
    },
    minusCartItem: (state,action) => {
        const item = state.products.find(item=>item.id === action.payload.id)
        item.quantity -= 1;
                
      },
    plusCartItem: (state,action) => {
    const item = state.products.find(item=>item.id === action.payload.id)
    item.quantity += 1;
            
    },
    resetCart: (state) => {
      state.products = []
    },
  },
})

// Action creators are generated for each case reducer function
export const { addToCart, removeItem, resetCart,minusCartItem,plusCartItem } = cartSlice.actions
export const selectCart = (state) => state.cart.products;

export default cartSlice.reducer
package com.example.phoenixstore.view.adapter

import com.example.phoenixstore.model.Products

interface ProductsListener {
    fun OnProductsClick(product:Products, position: Int)
}
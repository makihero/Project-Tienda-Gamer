package com.example.phoenixstore.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.phoenixstore.model.Products
import com.example.phoenixstore.network.Callback
import com.example.phoenixstore.network.FirestoreService

class OrderViewModel: ViewModel() {
    val firestoreService = FirestoreService()
    var listProducts : MutableLiveData<List<Products>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh() {
        getProductsFromFrirebase()
    }

    fun getProductsFromFrirebase(){
        firestoreService.getProducts(object : Callback<List<Products>> {
            override fun onSuccess(result: List<Products>?) {
                listProducts.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }

    fun processFinished() {
        isLoading.value = true
    }
}
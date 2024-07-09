package com.basebox.mytimbu.repo

import com.basebox.mytimbu.data.RetrofitInstance
import com.basebox.mytimbu.models.Product
import retrofit2.Call

class ProductRepository {
    private val api = RetrofitInstance.api

    fun getProducts(organizationId: String, appId: String, apiKey: String): Call<Product> {
        return api.getProducts(organizationId, appId, apiKey)
    }
}
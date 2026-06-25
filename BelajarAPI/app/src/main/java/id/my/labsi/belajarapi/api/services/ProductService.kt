package id.my.labsi.belajarapi.api.services

import id.my.labsi.belajarapi.api.model.ProductResponse
import retrofit2.Call
import retrofit2.http.GET

interface ProductService {

    @GET("products")
    fun getAll(): Call<ProductResponse>

}
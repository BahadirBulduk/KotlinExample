package bahadirbulduk.kotlinandroidexample.services

import bahadirbulduk.kotlinandroidexample.services.response.PostResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by administrator on 22/05/2017.
 */

class BaseService {

    private val restInterface : RestInterface

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        restInterface = retrofit.create(RestInterface::class.java)
    }

    fun getPost() : Call<PostResponse> {
        return restInterface.getPost();
    }

}
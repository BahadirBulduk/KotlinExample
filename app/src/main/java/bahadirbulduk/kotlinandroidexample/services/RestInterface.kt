package bahadirbulduk.kotlinandroidexample.services

import bahadirbulduk.kotlinandroidexample.services.response.PostResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by administrator on 22/05/2017.
 */

interface RestInterface {

    @GET("/posts/1")
    fun getPost() : Call<PostResponse>;

}
package bahadirbulduk.kotlinandroidexample.services

import bahadirbulduk.kotlinandroidexample.services.response.PostResponse
import java.util.*

/**
 * Created by administrator on 22/05/2017.
 */

class PostManager(private val api: BaseService = BaseService()) {

    fun getPost(): PostResponse {

        val callResponse = api.getPost()
        val response = callResponse.execute()

        if (response.isSuccessful) {
            val post = response.body()
            return PostResponse(post.userId, post.id, post.title, post.body)
        } else {
            return PostResponse(0, 0, "", "")
        }


    }
}
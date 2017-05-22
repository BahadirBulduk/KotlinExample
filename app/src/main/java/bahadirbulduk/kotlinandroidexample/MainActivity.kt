package bahadirbulduk.kotlinandroidexample

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import bahadirbulduk.kotlinandroidexample.services.PostManager
import bahadirbulduk.kotlinandroidexample.services.response.PostResponse
import butterknife.BindView
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    /**
     * lateinit
     *
     * Normally, properties declared as having a non-null type must be initialized in the constructor.
     * However, fairly often this is not convenient. For example, properties can be initialized through
     * dependency injection, or in the setup method of a unit test. In this case, you cannot supply
     * a non-null initializer in the constructor, but you still want to avoid null checks when
     * referencing the property inside the body of a class.
     */

    @BindView(R.id.example_textview)
    lateinit var exampleTextviewButterKnife: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val postmanager = PostManager()

        // ButterKnife version
        ButterKnife.bind(this)
        exampleTextviewButterKnife.text = "ButterKnife version"


        //Kotlin findViewById version
        val exampleTextview = findViewById(R.id.example_textview) as TextView
        exampleTextview.text = "findViewById version"

        //Kotlin extension version
        this.example_textview.text = "Kotlin extension version"


        //Click listener for button
        this.click_me.setOnClickListener {
            Toast.makeText(applicationContext, "Clicked Button", Toast.LENGTH_SHORT).show()
        }

        getPost(exampleTextviewButterKnife,postmanager).execute()

    }

    open class getPost(textView: TextView , postManager: PostManager ) : AsyncTask<Void, Void, String>() {
        val exampleTextview = textView
        val postmanager = postManager



        override fun doInBackground(vararg params: Void?): String {
            val postResponse = postmanager.getPost()
            val title = postResponse.title
            return title
        }

        override fun onPostExecute(title: String?) {
            super.onPostExecute(title)
            exampleTextview.text = title
        }
    }
}

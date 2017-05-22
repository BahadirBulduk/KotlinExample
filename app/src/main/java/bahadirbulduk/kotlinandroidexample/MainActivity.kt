package bahadirbulduk.kotlinandroidexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.activity_main.*

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
    lateinit var exampleTextviewButterKnife : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ButterKnife version
        ButterKnife.bind(this)
        exampleTextviewButterKnife.setText("ButterKnife version")


        //Kotlin findViewById version
        val exampleTextview = findViewById(R.id.example_textview) as TextView
        exampleTextview.setText("findViewById version")

        //Kotlin extension version
        this.example_textview.setText("Kotlin extension version")


        //Click listener for button
        this.click_me.setOnClickListener {
            Toast.makeText(applicationContext,"Clicked Button",Toast.LENGTH_SHORT).show()
        }
    }
}

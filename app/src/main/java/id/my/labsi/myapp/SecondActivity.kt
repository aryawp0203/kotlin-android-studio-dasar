package id.my.labsi.myapp

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val textView: TextView = findViewById(R.id.tv_show)

        if(intent.hasExtra("text1")){
            textView.text = intent.getStringExtra("text1")
        } else {
            Toast.makeText(applicationContext, "Tidak ada data", Toast.LENGTH_SHORT).show()
        }
    }
}
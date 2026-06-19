package id.my.labsi.myapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnKlik: Button = findViewById(R.id.btn_click)
        val btnSecond: Button = findViewById(R.id.btn_second)

        btnKlik.setOnClickListener{

            // EXPLICIT INTENT
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("text1", "Ini adalah data teks saya")
            startActivity(intent)
        }

        btnSecond.setOnClickListener {
            // IMPLICIT INTENT
//            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://web.labsi.my.id"))
//            if (intent.resolveActivity(packageManager) != null){
//                startActivity(intent)
//            } else {
//                Toast.makeText(applicationContext, "Tidak ada aplikasi yang support", Toast.LENGTH_SHORT).show()
//            }

            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
//                setPackage("com.whatsapp")
            }
            intent.putExtra(Intent.EXTRA_TEXT, "Hai, ini adalah kiriman")

            if (intent.resolveActivity(packageManager) != null){
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "Tidak ada aplikasi yang support", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
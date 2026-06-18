package id.my.labsi.myapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var angkaBulat: Int = 0
//    val angkaDesimal: Double = 14.3
//    val angkaPanjang: Long = 900000000000000000L
//
//    val karakter: Char = 'A'
//    var kata: String = "Ini adalah contoh teks panjang"
//
//    var benar: Boolean = true
//    val salah: Boolean = false
//
//    val angkaArray: Array<Int> = arrayOf(1,2,3,4,5)
//    val stringArray: Array<String> = arrayOf("Aku","Adalah","Programmer")
//    val booleanArray: Array<Boolean> = arrayOf(true,false,true)

    fun hitung(){
        angkaBulat++
//      angkaBulat = angkaBulat + 1
    }

    fun hitung(angka: Int, kata: String){

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtLoading: TextView = findViewById(R.id.txt_loading)
        val btnHitung: Button = findViewById(R.id.btn_hitung)

        btnHitung.setOnClickListener({
            hitung()
            txtLoading.text = angkaBulat.toString()
        })

//        if(angkaBulat == 4 && angkaDesimal > 13){
//            benar = true
//            kata = "Konsisi terpenuhi"
//        } else {
//            benar = false
//            kata = "Kondisi tidak terpenuhi"
//        }
    }
}
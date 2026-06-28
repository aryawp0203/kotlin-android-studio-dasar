package id.my.labsi.passingdatatoast

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editInputNama: EditText
    private lateinit var btnKirim: Button
    private lateinit var strNama: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editInputNama = findViewById(R.id.edt_nama)
        btnKirim = findViewById(R.id.btn_kirim)

        btnKirim.setOnClickListener {
            strNama = editInputNama.text.toString()

            Toast.makeText(applicationContext, "Perkenalkan nama saya " + strNama, Toast.LENGTH_SHORT).show()
        }
    }
}
package id.my.labsi.myapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainLayout: ConstraintLayout = findViewById(R.id.main)
        val editText: EditText = findViewById(R.id.edit_text)
        val btnKlik: Button = findViewById(R.id.btn_click)

        btnKlik.setOnClickListener{
            val teks: String = editText.text.toString()
//            Toast.makeText(applicationContext, teks, Toast.LENGTH_SHORT).show()
//            Snackbar.make(mainLayout, teks, Snackbar.LENGTH_LONG).show()
            val builder = AlertDialog.Builder(this)
            builder.setTitle("My App")
            builder.setMessage(teks)
            builder.setPositiveButton("Tutup"){
                dialog, which ->
                dialog.dismiss()
            }

            val dialog = builder.create()
            dialog.show()
        }
    }
}
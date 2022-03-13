package dev.sanskar.words

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddWordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_word)

        val editText = findViewById<EditText>(R.id.editText_word)
        val button = findViewById<Button>(R.id.button_add)

        button.setOnClickListener {
            val text = editText.text.toString()
            val intent = Intent()
            intent.putExtra("WORD", text)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
package com.example.notepad
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.core.view.marginStart
import com.example.notepad.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import kotlin.system.exitProcess
class MainActivity : AppCompatActivity() {
    lateinit var textViewContainer: LinearLayout
    lateinit var fBtn: FloatingActionButton
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        fBtn = findViewById(R.id.floatingBtn)
        textViewContainer = findViewById(R.id.linear_layout)
        fBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, WritingPad::class.java)
            startActivityForResult(intent, 1)
        }
        val saveText = readFromFile()
        displaySavedText(saveText)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            // Get the text entered by the user in the WritingPadActivity
            val newText = data?.getStringExtra("text")

            // Save the new text to file
            writeToFile(newText)

            // Display the saved text in a new TextView
            val textView = TextView(this)
            textView.text = newText
            textViewContainer.addView(textView)
            displaySavedText(readFromFile())
        }
    }

    private fun writeToFile(text: String?) {
        if (text != null && text.isNotEmpty()) {
            val file = File(filesDir, "saved_text.txt")
            if (!file.exists()) {
                file.createNewFile()
            }
            val outputStream = FileOutputStream(file, true)
            if (file.length() > 0) {
                outputStream.write("\n".toByteArray())
            }
            outputStream.write(text.toByteArray())
            outputStream.close()
        }
    }

    private fun displaySavedText(text: String) {
        if (text.isNotEmpty()) {
            val savedTexts = text.split("\n")
            for (savedText in savedTexts) {
                var textView = textViewContainer.findViewWithTag<TextView>(savedText)
                if (textView == null) {
                    textView = TextView(this)
                    textView.text = savedText
                    textView.tag = savedText
                    textView.setBackgroundResource(R.drawable.edit_background)
                    val layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    ).apply {
                        marginStart = resources.getDimensionPixelSize(R.dimen.dimension)
                    }
                    textView.setTextColor(ContextCompat.getColor(this, R.color.white))
                    textViewContainer.addView(textView)

                    // Set an onClickListener to open the file when the TextView is clicked
                    textView.setOnClickListener {
                        /*val file = File(filesDir, "saved_text.txt")
                        val uri = FileProvider.getUriForFile(this, "com.example.notepad.fileprovider", file)

                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.setDataAndType(uri, "text/plain")
                        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                        startActivity(intent)*/

                        val intent = Intent(this@MainActivity, WritingPad::class.java)
                        intent.putExtra("text", savedText)
                        startActivityForResult(intent, 1)


                    }
                } else {
                    textView.text = savedText
                }
            }
        }
    }


    private fun readFromFile(): String {
        val file = File(filesDir, "saved_text.txt")
        return if (file.exists()) {
            file.readText()
        } else {
            ""
        }
    }
    override fun onBackPressed() {
        finishAffinity()
    }
    }


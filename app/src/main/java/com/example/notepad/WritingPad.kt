package com.example.notepad

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.BackgroundColorSpan
import android.text.style.StyleSpan
import android.widget.TextView
import android.widget.Toast
import com.example.notepad.databinding.ActivityWritingPadBinding
import com.google.android.material.textfield.TextInputEditText
import java.io.File

class WritingPad : AppCompatActivity() {

    lateinit var Vtxt: TextView
    lateinit var textVi: TextInputEditText
    lateinit var binding: ActivityWritingPadBinding

    /*  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWritingPadBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_writing_pad)
        setContentView(binding.root)
        textVi = findViewById(R.id.txtVi)
        binding.Btnbold.setOnClickListener {
            val cursorPosition = textVi.selectionEnd
            val spannableString = if (textVi.text is SpannableStringBuilder) {
                // If the text is already a SpannableStringBuilder, reuse it
                textVi.text as SpannableStringBuilder
            } else {
                // Otherwise, create a new SpannableStringBuilder from the text
                SpannableStringBuilder(textVi.text)
            }
            val boldSpans = spannableString.getSpans(textVi.selectionStart, textVi.selectionEnd, StyleSpan::class.java)
            if (boldSpans.isNotEmpty()){
                for (boldSpan in boldSpans){
                    spannableString.removeSpan(boldSpan)
                }
            }else{
                spannableString.setSpan(
                    StyleSpan(Typeface.BOLD),
                    textVi.selectionStart,
                    textVi.selectionEnd,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
            textVi.setText(spannableString, TextView.BufferType.SPANNABLE)
            if (cursorPosition > textVi.length()) {
                textVi.setSelection(textVi.length())
            } else {
                textVi.setSelection(cursorPosition)
            }
        }
        binding.BtnItalic.setOnClickListener {
            val cursorPosition = textVi.selectionEnd
            val spannableString = if (textVi.text is SpannableStringBuilder) {
                textVi.text as SpannableStringBuilder
            } else {
                SpannableStringBuilder(textVi.text)
            }
            val italicSpans = spannableString.getSpans(textVi.selectionStart, textVi.selectionEnd, StyleSpan::class.java)
            if (italicSpans.isNotEmpty()){
                for (italicSpan in italicSpans){
                    spannableString.removeSpan(italicSpan)
                }
            }else{
                spannableString.setSpan(
                    StyleSpan(Typeface.ITALIC),
                    textVi.selectionStart,
                    textVi.selectionEnd,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
            textVi.setText(spannableString, TextView.BufferType.SPANNABLE)
            if (cursorPosition > textVi.length()) {
                textVi.setSelection(textVi.length())
            } else {
                textVi.setSelection(cursorPosition)
            }
        }
        binding.BtnHighlight.setOnClickListener {
            val selectedColor = getColorFromName(binding.Spinner.selectedItem.toString())
            val spannable = textVi.text as Spannable
            spannable.setSpan(
                BackgroundColorSpan(selectedColor),
                textVi.selectionStart,
                textVi.selectionEnd,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            textVi.setSelection(textVi.selectionEnd)
        }
        binding.BtnSave.setOnClickListener {
            val text = textVi.text.toString()
            val intent = Intent().apply {
                putExtra("text",text)
            }
            setResult(RESULT_OK,intent)
            finish()
        }
        val savedText = intent.getStringExtra("text")
        if (savedText != null) {
            textVi.setText(savedText)
        }
    } */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWritingPadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        textVi = findViewById(R.id.txtVi)
        binding.Btnbold.setOnClickListener {
            val cursorPosition = textVi.selectionEnd
            val spannableString = if (textVi.text is SpannableStringBuilder) {
                // If the text is already a SpannableStringBuilder, reuse it
                textVi.text as SpannableStringBuilder
            } else {
                // Otherwise, create a new SpannableStringBuilder from the text
                SpannableStringBuilder(textVi.text)
            }
            val boldSpans = spannableString.getSpans(
                textVi.selectionStart,
                textVi.selectionEnd,
                StyleSpan::class.java
            )
            if (boldSpans.isNotEmpty()) {
                for (boldSpan in boldSpans) {
                    spannableString.removeSpan(boldSpan)
                }
            } else {
                spannableString.setSpan(
                    StyleSpan(Typeface.BOLD),
                    textVi.selectionStart,
                    textVi.selectionEnd,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
            textVi.setText(spannableString, TextView.BufferType.SPANNABLE)
            if (cursorPosition > textVi.length()) {
                textVi.setSelection(textVi.length())
            } else {
                textVi.setSelection(cursorPosition)
            }
        }
        binding.BtnItalic.setOnClickListener {
            val cursorPosition = textVi.selectionEnd
            val spannableString = if (textVi.text is SpannableStringBuilder) {
                textVi.text as SpannableStringBuilder
            } else {
                SpannableStringBuilder(textVi.text)
            }
            val italicSpans = spannableString.getSpans(
                textVi.selectionStart,
                textVi.selectionEnd,
                StyleSpan::class.java
            )
            if (italicSpans.isNotEmpty()) {
                for (italicSpan in italicSpans) {
                    spannableString.removeSpan(italicSpan)
                }
            } else {
                spannableString.setSpan(
                    StyleSpan(Typeface.ITALIC),
                    textVi.selectionStart,
                    textVi.selectionEnd,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
            textVi.setText(spannableString, TextView.BufferType.SPANNABLE)
            if (cursorPosition > textVi.length()) {
                textVi.setSelection(textVi.length())
            } else {
                textVi.setSelection(cursorPosition)
            }
        }
        binding.BtnHighlight.setOnClickListener {
            val selectedColor = getColorFromName(binding.Spinner.selectedItem.toString())
            val spannable = textVi.text as Spannable
            spannable.setSpan(
                BackgroundColorSpan(selectedColor),
                textVi.selectionStart,
                textVi.selectionEnd,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            textVi.setSelection(textVi.selectionEnd)
        }
        binding.BtnSave.setOnClickListener {
            val boldRanges = ArrayList<Pair<Int, Int>>()
            val italicRanges = ArrayList<Pair<Int, Int>>()
            val highlightRanges = ArrayList<Pair<Int, Int>>()
            val spannable = textVi.text as Spannable
            val boldSpans = spannable.getSpans(0, textVi.length(), StyleSpan::class.java)
            val italicSpans = spannable.getSpans(0, textVi.length(), StyleSpan::class.java)
            val highlightSpans =
                spannable.getSpans(0, textVi.length(), BackgroundColorSpan::class.java)
            for (boldSpan in boldSpans) {
                boldRanges.add(
                    Pair(
                        spannable.getSpanStart(boldSpan),
                        spannable.getSpanEnd(boldSpan)
                    )
                )
            }
            for (italicSpan in italicSpans) {
                italicRanges.add(
                    Pair(
                        spannable.getSpanStart(italicSpan),
                        spannable.getSpanEnd(italicSpan)
                    )
                )
            }

            val text = textVi.text.toString()
            val intent = Intent().apply {
                putExtra("text",text)
            }
            setResult(RESULT_OK,intent)
            finish()
        }
    }
    private fun getColorFromName(colorName: String): Int {
        return when (colorName) {
            "RED" -> {
                try {
                    Color.parseColor("#F73131")
                } catch (e: java.lang.IllegalArgumentException) {
                    Color.BLACK
                }
            }
            "BLUE" -> {
                try {
                    Color.parseColor("#1F96DA")
                } catch (e: java.lang.IllegalArgumentException) {
                    Color.BLACK
                }
            }
            "GREEN" -> {
                try {
                    Color.parseColor("#14D90E")
                } catch (e: java.lang.IllegalArgumentException) {
                    Color.BLACK
                }
            }
            "ORANGE" -> {
                try {
                    Color.parseColor("#FFA600")
                } catch (e: java.lang.IllegalArgumentException) {
                    Color.BLACK
                }
            }
            else -> Color.BLACK
        }
    }
}


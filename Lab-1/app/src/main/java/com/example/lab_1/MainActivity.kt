package com.example.lab_1


import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun ok(view: View) {
        val radio: RadioButton? = findViewById(type_product.checkedRadioButtonId)
        val radio2: RadioButton? = findViewById(company.checkedRadioButtonId)
        if(radio != null && radio2 != null) {
            textView.setText(radio.text.toString() + " and " + radio2.text.toString())
        }
        else {
            Toast.makeText(this,"Choose something please",Toast.LENGTH_LONG).show()
        }
    }
    fun cancel(view: View) {
        textView.setText("")
        type_product.clearCheck()
        company.clearCheck()
    }

}

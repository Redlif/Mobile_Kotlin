package com.example.lab_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun ok (view:View){
        val company_Text=company_text.text.toString()
        val product_Text=product.text.toString()
        if(company_Text!="" && product_Text!=""){
            textView.setText(company_Text+" and "+product_Text)
        }
        else {
            Toast.makeText(this,"Field can't be empty",Toast.LENGTH_LONG).show()
        }
    }
    fun cancel (view: View){
        company_text.setText("")
        product.setText("")
        textView.setText("")
    }
}

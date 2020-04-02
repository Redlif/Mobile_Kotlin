package com.example.lab_1


import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var radio1:String=""
    var radio2:String=""
    var radio111:Int=0
    var radio222:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        type_product.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener{group, checkedId ->
                var radio11 = findViewById(checkedId) as RadioButton
                radio1=radio11.text.toString()
                radio11.isChecked=true
                radio111=checkedId
            }
        )
        company.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener{group, checkedId ->
                 var radio22 = findViewById(checkedId) as RadioButton
                radio2=radio22.text.toString()
                radio22.isChecked=true
                radio222=checkedId
            }
        )
    }


    fun ok (view:View){

        if (radio1!="" && radio2!=""){
            textView.setText(radio1 +" and "+ radio2)
             }
        else
            Toast.makeText(this," Choose something, please! ",Toast.LENGTH_LONG).show()

    }
    fun cancel (view: View){
        var bottom1=findViewById(radio111) as RadioButton
        var bottom2=findViewById(radio222) as RadioButton
        if(bottom1!=null ){
            bottom1.isChecked=false
            radio111=0
        }
        if(bottom2!=null){
            bottom2.isChecked=false
            radio222=0
        }

        radio1=""
        radio2=""
        textView.setText("")
    }
}

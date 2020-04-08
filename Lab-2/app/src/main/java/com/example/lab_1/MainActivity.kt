package com.example.lab_1


import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), FirstFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onFragmentInteraction(text: String) {
        val manager = supportFragmentManager
        val fragment = manager.findFragmentById(R.id.fragmentInput) as InputFragment
        fragment.input(text)
    }


}

package com.example.tablewarelab3

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_input.*

class InputFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    fun input (text:String){
        textView.setText(text)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_input, container, false)
        val ButtonOk = view.findViewById(R.id.show) as Button
        val clickOk = View.OnClickListener { view->ok(view) }
        ButtonOk.setOnClickListener ( clickOk )
        return view
    }

    private fun ok(view: View?) {
        val intent = Intent(context, ShowActivity::class.java)
        startActivity(intent)
    }
}
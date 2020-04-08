package com.example.lab_1

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {

    private var mListener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_first, container, false)
        val ButtonOk = view.findViewById(R.id.button) as Button
        val ButtonCancel = view.findViewById(R.id.button2) as Button
        val clickOk = View.OnClickListener { view->ok(view) }
        ButtonOk.setOnClickListener ( clickOk )
        val clickCancel = View.OnClickListener { view->cancel(view) }
        ButtonCancel.setOnClickListener (clickCancel )
        return view
    }

    fun ok(view: View) {

        val radio = view.findViewById(R.id.type_product) as RadioGroup
        val radio2 = company
        val button1 = radio.checkedRadioButtonId as RadioButton
        val button2 = radio2.checkedRadioButtonId as RadioButton
        if(button1 != null && button2 != null) {
            mListener?.onFragmentInteraction(button1.text.toString() + " and " + button2.text.toString())
        }
        else {
            Toast.makeText(context,"Choose something please", Toast.LENGTH_LONG).show()
        }
    }
    fun cancel(view: View) {
        mListener?.onFragmentInteraction("")
        type_product.clearCheck()
        company.clearCheck()
    }

    internal interface OnFragmentInteractionListener {
        fun onFragmentInteraction(text: String)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }
}

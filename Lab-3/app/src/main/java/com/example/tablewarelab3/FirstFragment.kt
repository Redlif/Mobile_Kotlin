package com.example.tablewarelab3
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
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
        val db = BaseHelper(context,null)
        val radio = type_product
        val radio2 = company
        val button1 = radio.checkedRadioButtonId
        val button2 = radio2.checkedRadioButtonId
        val product = findIdProduct(button1)
        val company = FindIdCompany(button2)
        val add = ModelTableware(product, company)
        if(product != "" && company != "") {
            mListener?.onFragmentInteraction(product + " and " + company)
            db.addInformation(add)
            Toast.makeText(context,"Add to database", Toast.LENGTH_LONG).show()

        }
        else {
            Toast.makeText(context,"Choose something please", Toast.LENGTH_LONG).show()
        }

    }
    fun findIdProduct(buttonId: Int) : String
    {
        when (buttonId) {
            bread.id -> {
                return bread.text.toString()
            }
            tablet.id -> {
                return tablet.text.toString()
            }
            mask.id -> {
                return mask.text.toString()
            }
            pen.id -> {
                return pen.text.toString()
            }
            phone.id -> {
                return phone.text.toString()
            }
        }
        return ""
    }
    fun FindIdCompany(buttonId:Int):String
    {
        when (buttonId) {
            rozetka.id -> {
                return rozetka.text.toString()
            }
            samsung.id -> {
                return samsung.text.toString()
            }
            novus.id -> {
                return novus.text.toString()
            }
            silpo.id -> {
                return silpo.text.toString()
            }
        }
        return ""
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